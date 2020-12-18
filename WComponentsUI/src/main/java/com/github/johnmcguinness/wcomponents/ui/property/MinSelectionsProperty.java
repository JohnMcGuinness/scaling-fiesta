package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 *
 * @author John McGuinness
 */
public final class MinSelectionsProperty extends IntProperty implements CheckBoxGroup.PropertySetter {

	public static MinSelectionsProperty minimumSelections(final int value) {
		return new MinSelectionsProperty(value);
	}

	public MinSelectionsProperty(final int value) {
		super(value);
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setMinSelect(value());
	}
}
