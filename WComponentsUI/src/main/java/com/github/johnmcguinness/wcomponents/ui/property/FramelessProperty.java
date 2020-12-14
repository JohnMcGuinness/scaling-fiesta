package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;

/**
 *
 * @author John McGuinness
 */
public final class FramelessProperty extends BooleanProperty implements CheckBoxGroup.PropertySetter {

	public static FramelessProperty frameless() {
		return frameless(true);
	}

	public static FramelessProperty frameless(final boolean value) {
		return new FramelessProperty(value);
	}
	
	private FramelessProperty(final Boolean value) {
		super(value);
	}

	@Override
	public <T> void apply(final CheckBoxGroup<T> group) {
		group.setFrameless(value());
	}
}
