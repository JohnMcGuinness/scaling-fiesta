package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class CollapsedProperty extends BooleanProperty {

	public static CollapsedProperty collapsed() {
		return collapsed(true);
	}

	public static CollapsedProperty collapsed(final boolean value) {
		return new CollapsedProperty(value);
	}

	private CollapsedProperty(final Boolean value) {
		super(value);
	}
}
