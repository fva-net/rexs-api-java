package info.rexs.upgrade.upgraders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import info.rexs.model.RexsComponent;
import info.rexs.model.RexsModel;
import info.rexs.model.RexsRelation;
import info.rexs.model.RexsRelationRef;
import info.rexs.schema.constants.RexsRelationRole;
import info.rexs.schema.constants.standard.RexsStandardAttributeIds;
import info.rexs.schema.constants.standard.RexsStandardComponentTypes;
import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.UpgradeNotifications.AttributeSource;
import info.rexs.upgrade.upgraders.UpgradeNotifications.ComponentSource;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;
import info.rexs.upgrade.upgraders.UpgradeNotifications.NotificationType;
import info.rexs.upgrade.upgraders.UpgradeNotifications.RelationSource;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ModelUpgraderV13toV14 {

	private static final ChangelogFile CHANGELOG_FILE = ChangelogFile.V1_3_TO_V1_4;

	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();

	public ModelUpgraderV13toV14(RexsModel model, boolean strictMode) {
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

		checkDuplicateReferences(newModel);
		setCoordinateSystemReference(newModel);

		newModel.setVersion(RexsStandardVersions.V1_4);
		newModel.setApplicationId("REXS API Upgrader");

		return new ModelUpgraderResult(newModel, notifications);
	}

	private void checkDuplicateReferences(RexsModel model) {
		for (RexsRelation rel: new ArrayList<>(model.getRelations())) {
			checkDuplicateReferences(model, rel);
		}
	}

	private void checkDuplicateReferences(RexsModel model, RexsRelation rel) {
		Map<RexsRelationRole, List<RexsRelationRef>> map = rel.getRefs().stream()
				.collect(Collectors.groupingBy(RexsRelationRef::getRole));
		boolean hasDuplicate = false;
		for (Entry<RexsRelationRole, List<RexsRelationRef>> entry: map.entrySet()) {
			RexsRelationRole role = entry.getKey();
			if (1 < entry.getValue().size()) {
				notifications.add(new Notification(NotificationType.FIXME, "relation has more than one reference for role "+role.getKey(),
						new RelationSource(rel.getId())));
				hasDuplicate = true;
			}
		}
		// remove relation
		if (strictMode && hasDuplicate) {
			notifications.add(new Notification(NotificationType.WARNING, "removed relation that has more than one reference for one role ",
					new RelationSource(rel.getId())));
			model.removeRelation(rel);
		}
	}

	private void setCoordinateSystemReference(RexsModel model) {
		for (RexsComponent gearUnitComp: model.getComponentsOfType(RexsStandardComponentTypes.gear_unit)) {
			// Set reference to gear unit. Attribute may not yet exist.
			gearUnitComp.addAttribute(RexsStandardAttributeIds.reference_component_for_position, gearUnitComp.getId());
			notifications.add(new Notification("set coordinate system reference for gear unit",
					new ComponentSource(gearUnitComp.getId()),
					new AttributeSource(RexsStandardAttributeIds.reference_component_for_position.getId())));
		}
	}

}
