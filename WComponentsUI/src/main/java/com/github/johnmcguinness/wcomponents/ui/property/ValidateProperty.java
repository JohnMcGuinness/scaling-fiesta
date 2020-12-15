package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class ValidateProperty
	extends BooleanProperty
	implements Panel.PropertySetter, Section.PropertySetter,
	FieldSet.PropertySetter, FieldLayout.PropertySetter {

	public static ValidateProperty validate(final boolean value) {
		return new ValidateProperty(value);
	}

	private ValidateProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Panel panel) {
		panel.setValidate(value());
	}

	@Override
	public void apply(final Section section) {
		section.setValidate(value());
	}

	@Override
	public void apply(final FieldSet fieldset) {
		fieldset.setValidate(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setValidate(value());
	}
}
