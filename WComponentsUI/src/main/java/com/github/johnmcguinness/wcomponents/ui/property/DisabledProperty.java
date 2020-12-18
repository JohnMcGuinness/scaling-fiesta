package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBox;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 *
 * @author John McGuinness
 */
public final class DisabledProperty 
	extends BooleanProperty 
	implements Button.PropertySetter, CheckBox.PropertySetter, CheckBoxGroup.PropertySetter {

	public static DisabledProperty disabled(final boolean value) {
		return new DisabledProperty(value);
	}
	
	private DisabledProperty(final boolean value) {
		super(value);
	}

	@Override
	public void apply(final Button button) {
		button.setDisabled(value());
	}

	@Override
	public void apply(final CheckBox checkbox) {
		checkbox.setDisabled(value());
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setDisabled(value());
	}
}
