package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class ValidateProperty
        extends BooleanProperty
        implements Panel.PropertySetter, Section.PropertySetter {

	public static ValidateProperty validate(final boolean value) {
		return new ValidateProperty(value);
	}

	private ValidateProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Panel panel) {
		panel.setVisible(value());
	}

	@Override
	public void apply(final Section section) {
		section.setVisible(value());
	}
}
