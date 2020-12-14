package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 */
public final class MinLengthProperty extends IntProperty implements TextInput.PropertySetter {

	public static MinLengthProperty minLegth(final int value) {
		return new MinLengthProperty(value);
	}
	
	private MinLengthProperty(final int value) {
		super(value);
	}

	@Override
	public void apply(final TextInput textInput) {
		textInput.setMinLength(value());
	}
}
