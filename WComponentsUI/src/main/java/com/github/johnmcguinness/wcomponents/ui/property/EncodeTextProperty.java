package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class EncodeTextProperty extends BooleanProperty {

	public EncodeTextProperty encodeText() {
		return encodeText(true);
	}

	public EncodeTextProperty encodeText(final boolean value) {
		return new EncodeTextProperty(value);
	}
	
	private EncodeTextProperty(final Boolean value) {
		super(value);
	}
}
