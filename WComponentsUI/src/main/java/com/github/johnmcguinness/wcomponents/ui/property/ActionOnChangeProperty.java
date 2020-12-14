package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Action;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 * Declares the action on change property for components that support an 'onchange' action.
 * @author John McGuinness
 */
public final class ActionOnChangeProperty implements Property<Action>, CheckBoxGroup.PropertySetter {

	private final Action action;

	public static ActionOnChangeProperty onChange(final Action action) {
		return new ActionOnChangeProperty(action);
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
