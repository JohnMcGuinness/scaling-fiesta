//  _ _ _  ___                                         _        _ _  _
// | | | ||  _] ___  _ _ _  ___  ___  _ _  ___  _ _  _| |_  ___| | || |
// | | | || [__/ . \| ' ' || . \/ . \| ' |/ ._]| ' |  | |  [_-[| | || |
// |__/_/ `___/\___/|_|_|_||  _/\___/|_|_|\___.|_|_|  |_|  /__/ \__||_|
//                         |_|
//
//  WComponentsUI provides a declarative API for creating WComponents web
//  applications.
//
package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WLabel;

/**
 * A label for components that can be labeled.
 *
 * @author John McGuinness
 */
public final class Label extends WLabel {

	/**
	 * Creates a {@link Label) with the provided {@code text}.
	 *
	 * @param text the text of the label.
	 *
	 * @return a FieldSet with the provided {@code text}.
	 */
	public static Label label(final String text) {
		return new Label(text);
	}

	/**
	 * Creates a {@link Label) with the provided {@code text}.
	 *
	 * @param text the text of the label.
	 * @param hint the hint for the label.
	 *
	 * @return a FieldSet with the provided {@code text}.
	 */
	public static Label label(final String text, final String hint) {
		return new Label(text, hint);
	}

	private Label(final String label) {
		super(label);
	}

	private Label(final String label, final String hint) {
		super(label);
		setHint(hint);
	}
}
