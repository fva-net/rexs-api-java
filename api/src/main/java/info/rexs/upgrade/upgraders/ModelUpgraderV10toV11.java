package info.rexs.upgrade.upgraders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.schema.RexsSchemaRegistry;
import info.rexs.schema.constants.RexsAttributeId;
import info.rexs.schema.constants.RexsComponentType;
import info.rexs.schema.constants.RexsRelationRole;
import info.rexs.schema.constants.RexsRelationType;
import info.rexs.schema.constants.RexsUnitId;
import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardRelationRoles;
import info.rexs.schema.constants.standard.RexsStandardRelationTypes;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;
import info.rexs.upgrade.upgraders.UpgradeNotifications.NotificationType;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ModelUpgraderV10toV11 {

	private static class AttributeLocation {
		public final RexsComponentType component;
		public final RexsAttributeId attribute;

		public AttributeLocation(RexsComponentType component, RexsAttributeId attribute) {
			this.component = component;
			this.attribute = attribute;
		}
	}

	private static final ChangelogFile CHANGELOG_FILE = ChangelogFile.V1_0_TO_V1_1;

	/** attributes that are deleted by the changelog upgrader but are meant to live on with a different numeric id */
	private static final List<AttributeLocation> attributesToRestore = Arrays.asList(
			new AttributeLocation(RexsStandardComponentTypes.bevel_gear, RexsStandardAttributeIds.face_width),
			new AttributeLocation(RexsStandardComponentTypes.bevel_gear, RexsStandardAttributeIds.rotational_speed),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.addendum_coefficient_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.addendum_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.chamfer_angle),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.dedendum_coefficient_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.dedendum_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.normal_module),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.normal_pressure_angle),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.protuberance_amount),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.protuberance_amount_factor),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.protuberance_height),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.protuberance_height_factor),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.tip_radius),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.tip_radius_factor),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.tooth_tip_chamfer),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.utilized_dedendum_coefficient_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cutter_wheel_tool, RexsStandardAttributeIds.utilized_dedendum_reference_profile),
			new AttributeLocation(RexsStandardComponentTypes.cylindrical_gear, RexsStandardAttributeIds.number_of_teeth),
			new AttributeLocation(RexsStandardComponentTypes.cylindrical_gear, RexsStandardAttributeIds.rotational_speed),
			new AttributeLocation(RexsStandardComponentTypes.cylindrical_gear, RexsStandardAttributeIds.u_coordinate_on_shaft),
			new AttributeLocation(RexsStandardComponentTypes.external_load, RexsStandardAttributeIds.u_coordinate_on_shaft),
			new AttributeLocation(RexsStandardComponentTypes.rack_shaped_tool, RexsStandardAttributeIds.normal_module),
			new AttributeLocation(RexsStandardComponentTypes.rack_shaped_tool, RexsStandardAttributeIds.normal_pressure_angle),
			new AttributeLocation(RexsStandardComponentTypes.rolling_bearing_with_catalog_geometry, RexsStandardAttributeIds.temperature_lubricant),
			new AttributeLocation(RexsStandardComponentTypes.rolling_bearing_with_detailed_geometry, RexsStandardAttributeIds.temperature_lubricant),
			new AttributeLocation(RexsStandardComponentTypes.shaft_section, RexsStandardAttributeIds.u_coordinate_on_shaft),
			new AttributeLocation(RexsStandardComponentTypes.zero_degree_grinding_disk_tool, RexsStandardAttributeIds.normal_module),
			new AttributeLocation(RexsStandardComponentTypes.zero_degree_grinding_disk_tool, RexsStandardAttributeIds.normal_pressure_angle));

	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();

	public ModelUpgraderV10toV11(RexsModel model, boolean strictMode) {
		this.oldModel = model;
		this.newModel = new RexsModel(model);
		this.strictMode = strictMode;

		try {
			this.changelog = ChangelogResolver.getInstance().resolve(CHANGELOG_FILE);
		} catch(RexsUpgradeException ex) {
			System.err.println(ex);
		}
	}

	public ModelUpgraderResult doupgrade() throws RexsUpgradeException {
		ModelChangelogUpgrader changeLogUpgrader = new ModelChangelogUpgrader(newModel, changelog, strictMode);
		newModel = changeLogUpgrader.applyChangelog();
		notifications.addAll(changeLogUpgrader.getNotifications().getNotifications());

		checkMissingRoles(newModel);
		updateCouplingToSideRelation(newModel);
		upgradeOrder(newModel);

		List<RexsComponent> rollingBearings = newModel.getComponents().stream()
				.filter(comp ->
				comp.getType()==RexsStandardComponentTypes.rolling_bearing_with_catalog_geometry ||
				comp.getType()==RexsStandardComponentTypes.rolling_bearing_with_detailed_geometry)
				.toList();
		for (RexsComponent bearing: rollingBearings) {
			upgradeBearing(newModel, bearing);
			upgradeBearingRows(newModel, bearing);
		}

		restoreAttributeValues();

		newModel.setVersion(RexsStandardVersions.V1_1);
		newModel.setApplicationId("REXS API Upgrader");

		return new ModelUpgraderResult(newModel, notifications);
	}

	private void checkMissingRoles(RexsModel model) {
		checkMissingRoles(model, RexsStandardRelationTypes.REXS_RELATIONS_1_0);
	}

	private void checkMissingRoles(RexsModel model, List<RexsRelationType> relationTypes) {
		for (RexsRelationType relType: relationTypes) {
			List<RexsRelation> relations = new ArrayList<>(model.getRelationsOfType(relType));
			for (RexsRelation relation: relations) {
				boolean remove = false;
				for (RexsRelationRole specifiedRole: relType.getRoles()) {
					// check if required role is present in relation
					boolean roleIsPresent = relation.getRefs().stream().anyMatch(ref -> ref.getRole()==specifiedRole);
					if (!roleIsPresent) {
						notifications.add(new UpgradeNotifications.Notification(NotificationType.FIXME,
								"role "+specifiedRole.getKey()+" missing from relation "+relation.getId(),
								new UpgradeNotifications.RelationSource(relation.getId())));
						// ignore relation
						remove = true;
					}
				}
				if (remove) {
					model.removeRelation(relation);
					notifications.add(new Notification(NotificationType.WARNING,
							"remove relation "+relation.getId(), new UpgradeNotifications.RelationSource(relation.getId())));
				}

				// check for extra unspecified refs
				for (RexsRelationRef ref: relation.getRefs()) {
					boolean roleIsPresent = relType.getRoles().stream().anyMatch(role -> role==ref.getRole());
					if (!roleIsPresent)
						notifications.add(new Notification(NotificationType.WARNING,
								"extraneous role "+ref.getRole().getKey()+" in relation "+relation.getId(),
								new UpgradeNotifications.RelationSource(relation.getId())));

				}
			}
		}

	}

	private void updateCouplingToSideRelation(RexsModel model) {
		List<RexsRelation> relations = new ArrayList<>(model.getRelationsOfType(RexsStandardRelationTypes.coupling));
		for (RexsRelation rel: relations) {
			RexsRelationRef assemblyRef = rel.findRefByRole(RexsStandardRelationRoles.assembly);
			RexsRelationRef side1Ref = rel.findRefByRole(RexsStandardRelationRoles.side_1);
			RexsRelationRef side2Ref = rel.findRefByRole(RexsStandardRelationRoles.side_2);

			RexsComponent couplingComp = model.getComponent(assemblyRef.getId());
			if (couplingComp.getType()==RexsStandardComponentTypes.switchable_coupling) {
				RexsRelation newRel = new RexsRelation(rel.getId(), RexsStandardRelationTypes.side, rel.getOrder());
				RexsRelationRef newAssemblyRef = new RexsRelationRef(assemblyRef.getId(), RexsStandardRelationRoles.assembly, assemblyRef.getHint());
				RexsRelationRef newInnerRef = new RexsRelationRef(side1Ref.getId(), RexsStandardRelationRoles.inner_part, side1Ref.getHint());
				RexsRelationRef newOuterRef = new RexsRelationRef(side2Ref.getId(), RexsStandardRelationRoles.outer_part, side2Ref.getHint());

				newRel.addRef(newAssemblyRef);
				newRel.addRef(newInnerRef);
				newRel.addRef(newOuterRef);
				model.addRelation(newRel);

				model.removeRelation(rel);
				notifications.add(new UpgradeNotifications.Notification("convert coupling to side relation "+rel.getId(),
						new UpgradeNotifications.ComponentSource(couplingComp.getId()),
						new UpgradeNotifications.RelationSource(rel.getId())));

			} else {
				notifications.add(new UpgradeNotifications.Notification(
						NotificationType.FIXME, "coupling has wrong type: "+couplingComp.getType(),
								new UpgradeNotifications.ComponentSource(couplingComp.getId())));
			}


		}

	}

	private void upgradeOrder(RexsModel model) {
		for (RexsComponent component: model.getComponents()) {
			upgradeOrder(component, RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly);
			upgradeOrder(component, RexsStandardRelationTypes.ordered_reference, RexsStandardRelationRoles.origin);

		}

	}

	private void upgradeOrder(RexsComponent parentComponent, RexsRelationType relType, RexsRelationRole parentRole) {
		List<RexsRelation> sortedRelations = newModel.getRelationsOfType(relType).stream()
				.filter(rel -> Objects.equals(rel.findComponentIdByRole(parentRole), parentComponent.getId()))
				.sorted(Comparator.comparing(RexsRelation::getOrder))
				.toList();
		for (int i=0; i<sortedRelations.size(); i++) {
			RexsRelation rel = sortedRelations.get(i);
			if (!Objects.equals(rel.getOrder(), i+1)) {
				rel.setOrder(i+1);
			}
		}
	}

	private void upgradeBearing(RexsModel model, RexsComponent bearingComp) {
		if (bearingComp.hasAttribute(RexsStandardAttributeIds.bearing_type)) {
			String type = bearingComp.getStringValue(RexsStandardAttributeIds.bearing_type);
			switch (type) {
			case "four_point_contact_ball_bearing": {
				// remove all bearing rows but one
				List<RexsRelation> relations = model.getRelations(RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly, bearingComp.getId());
				List<RexsComponent> rowComps = relations.stream()
						.map(rel -> model.getComponent(rel.findComponentIdByRole(RexsStandardRelationRoles.part)))
						.filter(comp -> comp.getType()==RexsStandardComponentTypes.rolling_bearing_row)
						.toList();
				if (1 < rowComps.size()) {
					notifications.add(
							new UpgradeNotifications.Notification("remove superfluous bearing rows from "+bearingComp,
							new UpgradeNotifications.ComponentSource(bearingComp.getId())));
  					// keep only the first bearing row
					rowComps.stream().skip(1).forEach(rowComp -> {
						removeBearingRowElements(model, rowComp);
						model.removeComponent(rowComp);
						// TODO remove relations?
					});
				}

				RexsComponent firstRowComp = rowComps.get(0);
				if (firstRowComp.hasAttribute(RexsStandardAttributeIds.axial_force_absorption_of_row)) {
					firstRowComp.getAttribute(RexsStandardAttributeIds.axial_force_absorption_of_row).setStringValue("both_directions");
				}
				break;
			}
//			case "crossed_roller_bearing": {
//				List<RexsRelation> relations = model.getRelations(RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly, bearingComp.getId());
//				List<RexsComponent> rowComps = relations.stream()
//						.map(rel -> model.getComponent(rel.findComponentIdByRole(RexsStandardRelationRoles.part)))
//						.filter(comp -> comp.getType()==RexsStandardComponentTypes.rolling_bearing_row)
//						.toList();
//				if (rowComps.size()==1) {
//					RexsComponent newRowComp = new RexsComponent(rowComps.get(0));
//					model.addOrderedAssemblyRelation(bearingComp, newRowComp, 1);
//				}
//				break;
//			}

			}
		}
	}


	private void removeBearingRowElements(RexsModel model, RexsComponent rowComp) {
		List<RexsRelation> relations = model.getRelations(RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly, rowComp.getId());
		for (RexsRelation rel: relations) {
			int rollingElementId = rel.findComponentIdByRole(RexsStandardRelationRoles.part);
			RexsComponent elementComp = model.getComponent(rollingElementId);
			notifications.add(new Notification(NotificationType.WARNING,
					"remove rolling element "+elementComp,
					new UpgradeNotifications.ComponentSource(rollingElementId)));
			model.removeComponent(elementComp);
			model.removeRelation(rel);
		}


	}

	private void upgradeBearingRows(RexsModel model, RexsComponent bearingComp) {
		List<RexsRelation> relations = model.getRelations(RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly, bearingComp.getId());
		for (RexsRelation rel: relations) {
			int bearingRowId = rel.findComponentIdByRole(RexsStandardRelationRoles.part);
			RexsComponent rowComp = model.getComponent(bearingRowId);
			upgradeRollingElements(model, rowComp);
		}

		RexsComponent oldBearingComp = oldModel.getComponent(bearingComp.getId());
		if (oldBearingComp.hasAttribute(RexsStandardAttributeIds.all_rows_are_identical)) {
			boolean rowsIdentical = oldBearingComp.getBooleanValue(RexsStandardAttributeIds.all_rows_are_identical);
			if (rowsIdentical) {
				notifications.add(new Notification("create instances of identical rows",
						new UpgradeNotifications.ComponentSource(bearingComp.getId())));
				if (1 < relations.size())
					throw new RuntimeException("too many rows");
				int bearingRowId = relations.get(0).findComponentIdByRole(RexsStandardRelationRoles.part);
				relations.get(0).setOrder(1);
				RexsComponent rowComp = model.getComponent(bearingRowId);
				int numRows = bearingComp.getIntegerValue(RexsStandardAttributeIds.number_of_bearing_rows);
				for (int order = 1; order < numRows; order++) {
					RexsComponent newRow = new RexsComponent(rowComp);
					newRow.setId(model.getNextFreeComponentId());
					model.addComponent(newRow);
					model.addOrderedAssemblyRelation(bearingComp, newRow, order+1);

				}
			}
		}
	}

	private void upgradeRollingElements(RexsModel model, RexsComponent rowComp) {
		RexsComponent oldRowComp = oldModel.getComponent(rowComp.getId());
		if (oldRowComp.hasAttribute(RexsStandardAttributeIds.all_rolling_elements_are_identical)) {
			boolean elementsIdentical = oldRowComp.getBooleanValue(RexsStandardAttributeIds.all_rolling_elements_are_identical);
			if (elementsIdentical) {
				// create number_of_rolling_elements-1 additional rolling elements
				notifications.add(new Notification("create instances of identical rolling elements",
						new UpgradeNotifications.ComponentSource(rowComp.getId())));
				List<RexsRelation> relations = model.getRelations(RexsStandardRelationTypes.ordered_assembly, RexsStandardRelationRoles.assembly, rowComp.getId());
				if (1 < relations.size())
					throw new RuntimeException("too many elements");
				int elementId = relations.get(0).findComponentIdByRole(RexsStandardRelationRoles.part);
				RexsComponent elementComp = model.getComponent(elementId);
				relations.get(0).setOrder(1);
				int numElements = rowComp.getIntegerValue(RexsStandardAttributeIds.number_of_rolling_elements);
				for (int order = 1; order < numElements; order++) {
					RexsComponent newElement = new RexsComponent(elementComp);
					newElement.setId(model.getNextFreeComponentId());
					model.addComponent(newElement);
					model.addOrderedAssemblyRelation(rowComp, newElement, order);
				}
			}
		}
	}

	private void restoreAttributeValues() {
		for (AttributeLocation loc: attributesToRestore) {
			List<RexsComponent> components = newModel.getComponentsOfType(loc.component);
			for (RexsComponent component: components)
				restoreAttributeValue(component, loc.attribute);
		}
	}

	private void restoreAttributeValue(RexsComponent comp, RexsAttributeId attrId) {
		// the generic update deletes the attribute accidently. Make sure the attribute and its value is restored
		RexsComponent oldComp = oldModel.getComponent(comp.getId());
		if (oldComp.hasAttribute(attrId)) {
			RexsUnitId defaultUnit = RexsSchemaRegistry.getInstance().getAttributeUnit(attrId.getId(), RexsStandardVersions.V1_1);
			double oldValue = oldComp.getDoubleValue(attrId, defaultUnit);
			comp.addAttribute(attrId, oldValue);
		}
	}

}
