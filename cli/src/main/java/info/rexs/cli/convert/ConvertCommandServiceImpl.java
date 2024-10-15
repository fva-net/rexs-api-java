package info.rexs.cli.convert;

import java.nio.file.Files;

import org.springframework.stereotype.Service;

import com.beust.jcommander.internal.Console;

import info.rexs.schema.constants.RexsVersion;
import info.rexs.io.RexsFileReader;
import info.rexs.io.RexsFileWriter;
import info.rexs.model.RexsModel;
import info.rexs.upgrade.RexsUpgradeException;
import info.rexs.upgrade.RexsUpgrader;
import info.rexs.upgrade.upgraders.ModelUpgraderResult;
import info.rexs.upgrade.upgraders.UpgradeNotifications.Notification;

@Service
public class ConvertCommandServiceImpl {

	public void convert(Console console, ConvertOptions options) {

		/*
		 * Read rexs model from file
		 */
		RexsModel rexsModel = null;

		try {
			if (Files.size(options.getFile()) < 1) {
				console.println(String.format("The REXS file '%s' is empty.", options.getFile()));
				return;
			}

			RexsFileReader rexsFileReader = new RexsFileReader(options.getFile());
			rexsModel = rexsFileReader.read();

		} catch (Exception ex) {
			console.println(String.format("The REXS file '%s' could not be read (%s).", options.getFile(), ex.getMessage()));
			return;
		}

		/*
		 * Upgrade rexs model
		 */
		RexsVersion targetVersion = options.getTargetVersion() != null ? options.getTargetVersion() : rexsModel.getVersion();

		if (targetVersion.isLess(rexsModel.getVersion())) {
			console.println(String.format("The target version is smaller than the version of the REXS model (%s < %s).", targetVersion.getName(), rexsModel.getVersion().getName()));
			return;
		}

		ModelUpgraderResult rexsUpgraderResult = null;

		try {
			RexsUpgrader rexsUpgrader = new RexsUpgrader(rexsModel);
			rexsUpgraderResult = rexsUpgrader.upgrade(options.getTargetVersion(), options.isStrictMode());

			if (rexsUpgraderResult.getNotifications() != null
					&& rexsUpgraderResult.getNotifications().getNotifications() != null
					&& !rexsUpgraderResult.getNotifications().getNotifications().isEmpty()) {

				console.println("Upgrade notifications:");
				for (Notification notification : rexsUpgraderResult.getNotifications().getNotifications()) {
					console.println(String.format("- %s", notification.getMessageVerbose()));
				}
			}

		} catch (RexsUpgradeException ex) {
			console.println(String.format("An error occurred during the version upgrade (%s).", ex.getMessage()));
			return;
		}

		/*
		 * Write rexs model to target file
		 */
		try {
			if (Files.exists(options.getTargetFile()) && !options.isOverrideExistingFile()) {
				console.println(String.format("The target REXS file '%s' already exists. Use the option 'override' to overwrite the file", options.getTargetFile()));
				return;
			}

			RexsFileWriter rexsFileWriter = new RexsFileWriter(options.getTargetFile());
			rexsFileWriter.write(rexsUpgraderResult.getModel());

		} catch (Exception ex) {
			console.println(String.format("An error occurred while writing the REXS file (%s).", ex.getMessage()));
		}
	}
}
