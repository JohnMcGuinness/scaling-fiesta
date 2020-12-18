package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Lazy;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBox;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 */
public final class ReadOnlyProperty extends LazyBooleanProperty
	implements TextInput.PropertySetter, CheckBox.PropertySetter, CheckBoxGroup.PropertySetter {

	public static ReadOnlyProperty readOnly(final boolean value) {
		return readOnly(() -> value);
	}

	public static ReadOnlyProperty readOnly(final Lazy<Boolean> value) {
		return new ReadOnlyProperty(value);
	}

	private ReadOnlyProperty(final Lazy<Boolean> value) {
		super(value);
	}

	@Override
	public void apply(final TextInput input) {
		input.setReadOnly(value());
	}

	@Override
	public void apply(final CheckBox checkbox) {
		checkbox.setReadOnly(value());
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setReadOnly(value());
	}
}
