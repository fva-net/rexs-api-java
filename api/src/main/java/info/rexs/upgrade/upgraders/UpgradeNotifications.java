package info.rexs.upgrade.upgraders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UpgradeNotifications {

	public static enum NotificationType {
		/** for changes and upgrades that went as expected and specified by the spec */
		INFO,
		/**
		 * for deviations from the spec that can be safely ignored  
		 * for errors are be fixed automatically and do not require the users attention
		 * for deprecated things
		 * */
		WARNING,
		/** for errors that must be resolved by the user */
		FIXME,
		/** for serious errors that can not be fixed easily */
		ERROR
	}

	public static class Notification {
		private final NotificationType type;
		private final String message;
		private final List<Source> sources;

		public Notification(String message, Source ... sources) {
			this.type = NotificationType.INFO;
			this.message = message;
			this.sources = Arrays.asList(sources);
		}

		public Notification(NotificationType type, String message, Source ... sources) {
			this.type = type;
			this.message = message;
			this.sources = Arrays.asList(sources);
		}

		public NotificationType getType() {
			return type;
		}

		public String getMessage() {
			return message;
		}

		public String getMessageVerbose() {
			String sourceStr = sources.stream().map(source -> source.toString()).reduce((a,b) -> a+", "+b).orElse("");
			return type+": "+message+" ["+sourceStr+"]";
		}
	}

	public static interface Source {
	}

	public static class ComponentSource implements Source {
		public final int componentId;

		public ComponentSource(int componentId) {
			this.componentId = componentId;
		}

		@Override
		public String toString() {
			return "Component "+componentId;
		}
	}

	public static class AttributeSource implements Source {
		public final String attributeId;

		public AttributeSource(int attributeId) {
			this.attributeId = Integer.toString(attributeId);
		}
		public AttributeSource(String attributeId) {
			this.attributeId = attributeId;
		}
		@Override
		public String toString() {
			return "Attribute "+attributeId;
		}
	}

	public static class RelationSource implements Source {
		public final int relationId;

		public RelationSource(int relationId) {
			this.relationId = relationId;
		}
		@Override
		public String toString() {
			return "Relation "+relationId;
		}
	}

	private List<Notification> notifications = new ArrayList<>();

	public UpgradeNotifications() {
	}

	public UpgradeNotifications(List<Notification> notifications) {
		this.notifications.addAll(notifications);
	}

	public void add(Notification notification) {
		notifications.add(notification);
	}

	public void addAll(Collection<Notification> notification) {
		notifications.addAll(notification);
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}
}
