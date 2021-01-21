package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Action;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 * Declares the action on change property for components that support an 'onchange' action.
 *
 * @author John McGuinness
 */
public final class ActionOnChangeProperty implements Property<Action>, CheckBoxGroup.PropertySetter {

	private final Action action;

	/**
	 * Creates an {@link ActionOnChangeProperty} using the provided value.
	 *
	 * @param value the {@link Action} to use as the on change property.
	 *
	 * @return a new {@link ActionOnChangeProperty}.
	 */
	public static ActionOnChangeProperty onChange(final Action value) {
		return new ActionOnChangeProperty(value);
	}

	private ActionOnChangeProperty(final Action action) {
		this.action = action;
	}

	@Override
	public Action value() {
		return this.action;
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setActionOnChange(value());
	}
}
