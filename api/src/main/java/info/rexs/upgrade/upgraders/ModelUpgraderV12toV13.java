package info.rexs.upgrade.upgraders;

import java.util.Comparator;
import java.util.List;

import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;
import info.rexs.schema.constants.RexsValueType;
import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardRelationRoles;
import info.rexs.schema.constants.standard.RexsStandardRelationTypes;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.UpgradeNotifications.ComponentSource;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ModelUpgraderV12toV13 {

	private static final ChangelogFile CHANGELOG_FILE = ChangelogFile.V1_2_TO_V1_3;

	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();

	public ModelUpgraderV12toV13(RexsModel model, boolean strictMode) {
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

		upgradeStageGearData(newModel);
		upgradeFlankGeometry(newModel);
		upgradeTools(newModel);

		ModelChangelogUpgrader changeLogUpgrader = new ModelChangelogUpgrader(newModel, changelog, strictMode);
		newModel = changeLogUpgrader.applyChangelog();
		notifications.addAll(changeLogUpgrader.getNotifications().getNotifications());

		newModel.setVersion(RexsStandardVersions.V1_3);
		newModel.setApplicationId("REXS API Upgrader");

		return new ModelUpgraderResult(newModel, notifications);
	}

	private void upgradeStageGearData(RexsModel model) {
		for (RexsComponent stageGearDataComp: model.getComponentsOfType(RexsStandardComponentTypes.stage_gear_data)) {
			RexsComponent stageComp = model.getStageFromStageGearData(stageGearDataComp.getId());
			notifications.add(new Notification("upgrade type of stage gear data "+stageGearDataComp.getId(),
					new ComponentSource(stageGearDataComp.getId())));

			if (stageComp.isOfType(RexsStandardComponentTypes.cylindrical_stage)) {
				stageGearDataComp.setType(RexsStandardComponentTypes.cylindrical_stage_gear_data);
			}
			if (stageComp.isOfType(RexsStandardComponentTypes.bevel_stage)) {
				stageGearDataComp.setType(RexsStandardComponentTypes.bevel_stage_gear_data);
			}
			if (stageComp.isOfType(RexsStandardComponentTypes.worm_stage)) {
				stageGearDataComp.setType(RexsStandardComponentTypes.worm_stage_gear_data);
			}
		}

	}

	private void upgradeFlankGeometry(RexsModel model) {
		for (RexsComponent stageComp: model.getComponentsOfType(RexsStandardComponentTypes.cylindrical_stage)) {
			for (RexsComponent flankComp: model.getFlankGeometriesOfStage(stageComp.getId())) {
				flankComp.setType(RexsStandardComponentTypes.cylindrical_gear_flank);
				notifications.add(new Notification("upgrade type of flank "+flankComp.getId(),
						new ComponentSource(flankComp.getId())));
			}
		}

		for (RexsComponent stageComp: model.getComponentsOfType(RexsStandardComponentTypes.bevel_stage)) {
			for (RexsComponent flankComp: model.getFlankGeometriesOfStage(stageComp.getId())) {
				flankComp.setType(RexsStandardComponentTypes.bevel_gear_flank);
				notifications.add(new Notification("upgrade type of flank "+flankComp.getId(),
						new ComponentSource(flankComp.getId())));
			}
		}

		for (RexsComponent stageComp: model.getComponentsOfType(RexsStandardComponentTypes.worm_stage)) {
			for (RexsComponent flankComp: model.getFlankGeometriesOfStage(stageComp.getId())) {
				flankComp.setType(RexsStandardComponentTypes.worm_gear_flank);
				notifications.add(new Notification("upgrade type of flank "+flankComp.getId(),
						new ComponentSource(flankComp.getId())));
			}
		}
	}


	private void upgradeTools(RexsModel model) {
		for (RexsComponent gearComp: model.getComponentsOfType(RexsStandardComponentTypes.cylindrical_gear)) {
			List<RexsRelation> toolRelations = model.getRelations(RexsStandardRelationTypes.ordered_reference, RexsStandardRelationRoles.origin, gearComp.getId()).stream()
			  .sorted(Comparator.comparingInt(RexsRelation::getOrder))
			  .toList();

			RexsComponent leftFlankComp = model.getFlankGeometry(gearComp.getId(), RexsStandardRelationRoles.left.getKey());
			RexsComponent rightFlankComp = model.getFlankGeometry(gearComp.getId(), RexsStandardRelationRoles.right.getKey());

			// replace ordered references to tool by manufacturing step relation
			for (RexsRelation toolrel: toolRelations) {
				RexsComponent toolComp = model.getComponent(toolrel.findComponentIdByRole(RexsStandardRelationRoles.referenced));

				RexsComponent leftManufacturingStepComp = model.createComponent(
						RexsStandardComponentTypes.cylindrical_gear_manufacturing_settings, "ManufacturingSettings");
				boolean result1 = model.addManufacturingStepRelation(leftFlankComp, toolComp, leftManufacturingStepComp, 0);
				RexsComponent rightManufacturingStepComp = model.createComponent(
						RexsStandardComponentTypes.cylindrical_gear_manufacturing_settings, "ManufacturingSettings");
				boolean result2 = model.addManufacturingStepRelation(rightFlankComp, toolComp, rightManufacturingStepComp, 1);

				notifications.add(new Notification("replace reference to tool by manufacturing step relations ",
						new ComponentSource(toolComp.getId()),
						new ComponentSource(gearComp.getId()),
						new ComponentSource(leftFlankComp.getId()),
						new ComponentSource(rightFlankComp.getId())
				));

				// move attributes from flank geometry component to machine setting component
				if (leftFlankComp.hasAttribute(RexsStandardAttributeIds.machining_allowance)) {
					double machiningAllowance = (Double) leftFlankComp.getValue(RexsStandardAttributeIds.machining_allowance, RexsValueType.FLOATING_POINT);
					leftManufacturingStepComp.addAttribute(RexsStandardAttributeIds.machining_allowance, machiningAllowance);
					leftFlankComp.removeAttribute(RexsStandardAttributeIds.machining_allowance);
				}
				if (leftFlankComp.hasAttribute(RexsStandardAttributeIds.machining_allowance_tolerance)) {
					double machiningAllowance = (Double) leftFlankComp.getValue(RexsStandardAttributeIds.machining_allowance_tolerance, RexsValueType.FLOATING_POINT);
					leftManufacturingStepComp.addAttribute(RexsStandardAttributeIds.machining_allowance_tolerance, machiningAllowance);
					leftFlankComp.removeAttribute(RexsStandardAttributeIds.machining_allowance_tolerance);
				}

				model.removeRelation(toolrel);
			}


		}
	}

}
