package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBox;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import com.github.johnmcguinness.wcomponents.ui.component.PasswordInput;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 */
public final class MandatoryProperty extends BooleanProperty implements 
	TextInput.PropertySetter, PasswordInput.PropertySetter, CheckBox.PropertySetter,
	CheckBoxGroup.PropertySetter {

	public static MandatoryProperty mandatory() {
		return mandatory(true);
	}

	public static MandatoryProperty mandatory(final boolean value) {
		return new MandatoryProperty(value);
	}

	private MandatoryProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final TextInput input) {
		input.setMandatory(value());
	}

	@Override
	public void apply(final PasswordInput input) {
		input.setMandatory(value());
	}

	@Override
	public void apply(final CheckBox checkbox) {
		checkbox.setMandatory(value());
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setMandatory(value());
	}
}
