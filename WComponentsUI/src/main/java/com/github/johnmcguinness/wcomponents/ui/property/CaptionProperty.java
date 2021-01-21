package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class CaptionProperty extends StringProperty {

	public static CaptionProperty caption(final String value) {
		return new CaptionProperty(value);
	}

	private CaptionProperty(final String value) {
		super(value);
	}
}
