package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class MaxProperty extends IntProperty {

	public static MaxProperty max(final int value) {
		return new MaxProperty(value);
	}

	private MaxProperty(final int value) {
		super(value);
	}
}
