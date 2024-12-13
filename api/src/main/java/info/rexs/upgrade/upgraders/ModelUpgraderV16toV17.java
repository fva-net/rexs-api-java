package info.rexs.upgrade.upgraders;

import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.model.RexsModel;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ModelUpgraderV16toV17 {

	private static final ChangelogFile CHANGELOG_FILE = ChangelogFile.V1_6_TO_V1_7;

	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();

	public ModelUpgraderV16toV17(RexsModel model, boolean strictMode) {
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

		newModel.setVersion(RexsStandardVersions.V1_7);
		newModel.setApplicationId("REXS API Upgrader");

		return new ModelUpgraderResult(newModel, notifications);
	}
}