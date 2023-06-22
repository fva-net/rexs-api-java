package info.rexs.upgrade.upgraders;

import java.io.IOException;
import java.io.InputStream;

import jakarta.xml.bind.JAXBException;

import info.rexs.db.constants.standard.RexsStandardVersions;
import info.rexs.model.RexsModel;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.upgraders.changelog.jaxb.RexsChangelogFile;

public class ModelUpgraderV11toV12 {

	private static final String CHANGELOG_FILENAME = "/info/rexs/upgrade/upgraders/changelog/rexs_changelog_1.1_to_1.2.xml";
	
	private RexsModel newModel;
	private final RexsModel oldModel;
	private final boolean strictMode;

	private RexsChangelogFile.RexsChangelog changelog;
	private UpgradeNotifications notifications = new UpgradeNotifications();
	
	public ModelUpgraderV11toV12(RexsModel model, boolean strictMode) {
		this.oldModel = model;
		this.newModel = new RexsModel(model);
		this.strictMode = strictMode;
		
		try (InputStream stream = this.getClass().getResourceAsStream(CHANGELOG_FILENAME)) {
			changelog = RexsChangelogFile.load(stream);
		} catch(IOException ex) {
			System.err.println(ex);
		} catch (JAXBException ex) {
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
