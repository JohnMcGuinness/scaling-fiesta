package com.github.johnmcguinness.wcomponents.ui.property;

/**
 * Declares the number of button columns for components that have columns of
 * buttons.
 * 
 * @author John McGuinness
 */
public final class ButtonColumnsProperty extends IntProperty {
	
	public static ButtonColumnsProperty buttonColumns(final int value) {
		return new ButtonColumnsProperty(value);
	}

	private ButtonColumnsProperty(final int value) {
		super(value);
	}
}
