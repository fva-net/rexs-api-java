package info.rexs.upgrade.upgraders;

import info.rexs.model.RexsModel;
import lombok.Getter;

@Getter
public class ModelUpgraderResult {

	private final RexsModel model;
	private final UpgradeNotifications notifications;

	public ModelUpgraderResult(RexsModel model, UpgradeNotifications notifications) {
		this.model = model;
		this.notifications = notifications;
	}

}
