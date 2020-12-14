package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Action;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBox;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 *
 * @author John McGuinness
 */
public final class ChangeActionProperty implements Property<Action>, CheckBox.PropertySetter, CheckBoxGroup.PropertySetter {

	private final Action value;

	public static ChangeActionProperty onChange(final Action action) {
		return new ChangeActionProperty(action);
	}
	
	private ChangeActionProperty(final Action value) {
		this.value = value;
	}

	@Override
	public Action value() {
		return this.value;
	}

	@Override
	public void apply(final CheckBox button) {
		button.setActionOnChange(value());
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setActionOnChange(value());
	}
}
