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

import com.github.bordertech.wcomponents.WText;

/**
 *
 * @author John McGuinness
 */
public final class Text extends WText {

	/**
	 * Create a {@link Text}.
	 *
	 * @param value the text content
	 *
	 * @return a new {@link Text}.
	 */
	public static Text textContent(final String value) {
		return new Text(value);
	}

	private Text(final String text) {
		super(text);
	}

	/**
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link Text}.
		 *
		 * @param text the {@link Text} to apply the property to.
		 */
		void apply(Text text);
	}
}
