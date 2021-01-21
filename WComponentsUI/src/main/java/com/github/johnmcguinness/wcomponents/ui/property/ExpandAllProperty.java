package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class ExpandAllProperty extends BooleanProperty {

	public ExpandAllProperty expandAll() {
		return expandAll(true);
	}

	public ExpandAllProperty expandAll(final boolean value) {
		return new ExpandAllProperty(value);
	}

	private ExpandAllProperty(final Boolean value) {
		super(value);
	}
}
