package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WComponent;
import com.github.johnmcguinness.wcomponents.ui.Ref;
import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the component being referenced.
 */
public final class ReferenceProperty<T extends WComponent> implements Property<Ref<T>>, 
	Panel.PropertySetter, TextInput.PropertySetter, Button.PropertySetter {

	private final Ref<T> value;
	
	public static <T extends WComponent> ReferenceProperty<T> ref(final Ref<T> component) {
		return new ReferenceProperty<>(component);
	}
	
	private ReferenceProperty(final Ref<T> value) {
		this.value = value;
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
}
