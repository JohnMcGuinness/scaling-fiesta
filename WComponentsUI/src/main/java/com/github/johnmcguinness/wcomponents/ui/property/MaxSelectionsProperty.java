package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 *
 * @author John McGuinness
 */
public final class MaxSelectionsProperty extends IntProperty implements CheckBoxGroup.PropertySetter {

	public static MaxSelectionsProperty maximumSelections(final int value) {
		return new MaxSelectionsProperty(value);
	}

	public MaxSelectionsProperty(final int value) {
		super(value);
	}

	@Override
	public <T> void apply(final CheckBoxGroup<T> group) {
		group.setMaxSelect(value());
	}
}
