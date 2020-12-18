package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 */
public final class ColumnsProperty extends IntProperty implements TextInput.PropertySetter {

	public static ColumnsProperty columns(final int value) {
		return new ColumnsProperty(value);
	}
	
	private ColumnsProperty(final int value) {
		super(value);
	}

	@Override
	public void apply(final TextInput textInput) {
		textInput.setColumns(value());
	}
}
