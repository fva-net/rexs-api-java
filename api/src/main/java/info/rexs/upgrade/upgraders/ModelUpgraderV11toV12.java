package info.rexs.upgrade.upgraders;

import info.rexs.schema.constants.standard.RexsStandardVersions;
import info.rexs.model.RexsModel;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.ChangelogFile;
import info.rexs.upgrade.upgraders.changelog.ChangelogResolver;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelog;

public class ModelUpgraderV11toV12 {

	private static final ChangelogFile CHANGELOG_FILE = ChangelogFile.V1_1_TO_V1_2;

	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();

	public ModelUpgraderV11toV12(RexsModel model, boolean strictMode) {
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

		newModel.setVersion(RexsStandardVersions.V1_2);
		newModel.setApplicationId("REXS API Upgrader");

		return new ModelUpgraderResult(newModel, notifications);
	}
}
