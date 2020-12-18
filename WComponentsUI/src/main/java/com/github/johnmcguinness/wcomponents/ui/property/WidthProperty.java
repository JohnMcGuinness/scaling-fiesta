package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class WidthProperty extends IntProperty {

	public static WidthProperty width(final int value) {
		return new WidthProperty(value);
	}
	
	private WidthProperty(final int value) {
		super(value);
	}
}
