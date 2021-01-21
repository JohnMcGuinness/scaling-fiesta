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
 * A {@link Field} consists of a label and the component which is labeled.
 *
 * @author John McGuinness
 */
public final class Field {

	private final Label label;

	private final WComponent labeled;

	/**
	 * Creates a {@link Field} using the {@link String} to create a {@link Label} and the {@link WComponent} to label.
	 *
	 * @param label the field's label.
	 * @param labeled the component which is being labeled.
	 *
	 * @return the new {@link Field} instance.
	 */
	public static Field field(final String label, final WComponent labeled) {
		return field(Label.label(label), labeled);
	}

	/**
	 * Creates a {@link Field} using the {@link Label} and the {@link WComponent} to label.
	 *
	 * @param label the field's label.
	 * @param labeled the component which is being labeled.
	 *
	 * @return the new {@link Field} instance.
	 */
	public static Field field(final Label label, final WComponent labeled) {
		return new Field(label, labeled);
	}

	private Field(final Label label, final WComponent labelled) {
		this.label = Objects.requireNonNull(label);
		this.labeled = Objects.requireNonNull(labelled);
	}

	/**
	 * @return the field's label.
	 */
	public Label label() {
		return this.label;
	}

	/**
	 * @return the component that is labeled.
	 */
	public WComponent labeled() {
		return this.labeled;
	}
}
