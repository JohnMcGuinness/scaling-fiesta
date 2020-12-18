package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class EditableProperty extends BooleanProperty {

	public EditableProperty editable() {
		return editable(true);
	}

	public EditableProperty editable(final boolean value) {
		return new EditableProperty(value);
	}

	private EditableProperty(final Boolean value) {
		super(value);
	}
}
