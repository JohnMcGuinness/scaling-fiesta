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

import com.github.bordertech.wcomponents.WComponent;
import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public final class Field {

	private final Label label;

	private final WComponent labelled;

	public Field(final Label label, final WComponent labelled) {
		this.label = Objects.requireNonNull(label);
		this.labelled = Objects.requireNonNull(labelled);
	}

	public Label label() {
		return this.label;
	}

	public WComponent labelled() {
		return this.labelled;
	}
}


