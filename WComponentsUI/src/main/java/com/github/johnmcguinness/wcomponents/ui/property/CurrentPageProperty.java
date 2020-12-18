package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class CurrentPageProperty extends IntProperty {

	public static CurrentPageProperty currentPage(final int value) {
		return new CurrentPageProperty(value);
	}

	private CurrentPageProperty(final int value) {
		super(value);
	}
}
