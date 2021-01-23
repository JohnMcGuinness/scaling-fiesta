package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WComponent;
import com.github.johnmcguinness.wcomponents.ui.Ref;
import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.PasswordInput;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the component being referenced.
 */
public final class ReferenceProperty<T extends WComponent> implements Property<Ref<T>>,
		Panel.PropertySetter, TextInput.PropertySetter, Button.PropertySetter, PasswordInput.PropertySetter {

	private final Ref<T> value;

	public static <T extends WComponent> ReferenceProperty<T> ref(final Ref<T> ref) {
		return new ReferenceProperty<>(ref);
	}

	private ReferenceProperty(final Ref<T> ref) {
		this.value = ref;
	}

	/**
	 *
	 * @return the value of the property.
	 */
	@Override
	public Ref<T> value() {
		return this.value;
	}

	@Override
	public void apply(final Panel panel) {
		value().current((T) panel);
	}

	@Override
	public void apply(final TextInput textInput) {
		value().current((T) textInput);
	}

	@Override
	public void apply(final Button button) {
		value().current((T) button);
	}

	@Override
	public void apply(final PasswordInput password) {
		value().current((T) password);
	}
}
