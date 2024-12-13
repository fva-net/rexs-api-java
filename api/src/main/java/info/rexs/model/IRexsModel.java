package info.rexs.model;


import java.util.List;

/**
 * This class represents a common model for REXS components .
 * It provides methods to manage components within the model.
 */
public interface IRexsModel {
	/**
	 * Returns all components of the model as a list.
	 *
	 * @return a list of {@link RexsComponent} representing all components in the model.
	 */
	List<RexsComponent> getComponents();
	/**
	 * Adds a component to the model.
	 *
	 * @param component the component to be added as a {@link RexsComponent}.
	 */
	void addComponent(RexsComponent component);
	/**
	 * Checks if the model contains a component with the specified ID.
	 *
	 * @param compId the ID of the component to check for.
	 * @return {@code true} if the model contains the component, otherwise {@code false}.
	 */
	boolean hasComponent(Integer compId);
	/**
	 * Returns the component with the specified ID.
	 *
	 * @param compId the ID of the component to retrieve.
	 * @return the component as a {@link RexsComponent}, or {@code null} if the model does not contain a component with the specified ID.
	 */
	RexsComponent getComponent(Integer compId);
}
