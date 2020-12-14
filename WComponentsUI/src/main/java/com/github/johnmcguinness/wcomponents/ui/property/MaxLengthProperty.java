package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 */
public final class MaxLengthProperty extends IntProperty implements TextInput.PropertySetter {

	public static MaxLengthProperty maxLegth(final int value) {
		return new MaxLengthProperty(value);
	}
	
	private MaxLengthProperty(final int value) {
		super(value);
	}

	@Override
	public void apply(final TextInput textInput) {
		textInput.setMaxLength(value());
	}
}
