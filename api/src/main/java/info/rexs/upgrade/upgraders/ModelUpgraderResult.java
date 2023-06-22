package info.rexs.upgrade.upgraders;

import info.rexs.model.RexsModel;

public class ModelUpgraderResult {
	
	private final RexsModel model;
	private final UpgradeNotifications notifications;
	
	public ModelUpgraderResult(RexsModel model, UpgradeNotifications notifications) {
		this.model = model;
		this.notifications = notifications;
	}

	public RexsModel getModel() {
		return model;
	}

	public UpgradeNotifications getNotifications() {
		return notifications;
	}
	
}