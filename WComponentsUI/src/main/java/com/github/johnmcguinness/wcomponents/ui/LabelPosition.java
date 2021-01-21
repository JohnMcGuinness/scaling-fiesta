//  _ _ _  ___                                         _        _ _  _
// | | | ||  _] ___  _ _ _  ___  ___  _ _  ___  _ _  _| |_  ___| | || |
// | | | || [__/ . \| ' ' || . \/ . \| ' |/ ._]| ' |  | |  [_-[| | || |
// |__/_/ `___/\___/|_|_|_||  _/\___/|_|_|\___.|_|_|  |_|  /__/ \__||_|
//                         |_|
//
//  WComponentsUI provides a declarative API for creating WComponents web
//  applications.
//
package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WFieldLayout;

/**
 * Used by {@link FieldLayout} to indicate where its field's labels should be positioned.
 *
 * @author John McGuinness
 */
public enum LabelPosition {

	/**
	 * The label will be positioned just above the labeled component.
	 */
	ABOVE(WFieldLayout.LAYOUT_STACKED),
	/**
	 * The label will be positioned to the side (usually to the left) of the labeled component.
	 */
	BESIDE(WFieldLayout.LAYOUT_FLAT);

	/**
	 * the string value to convert to.
	 */
	private final String layoutValue;

	/**
	 * Create a {@link LabelPosition} indicating what the equivalent {@link String} value in {@link WFieldLayout} is.
	 *
	 * @param value the {@link String} value from {@link WFieldLayout}.
	 */
	LabelPosition(final String value) {
		this.layoutValue = value;
	}

	/**
	 * Convert from the {@link LabelPosition} int value to the equivalent {@link WFieldLayout} value.
	 *
	 * @return the {@link WFieldLayout} layout string value.
	 */
	public String convert() {
		return this.layoutValue;
	}
}
