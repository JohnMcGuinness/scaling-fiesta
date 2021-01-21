package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.johnmcguinness.wcomponents.ui.component.Text;
import com.github.johnmcguinness.wcomponents.ui.component.TextInput;
import java.util.Objects;

/**
 * Declare the text for a component.
 *
 * @author John McGuinness
 */
public final class TextProperty
	implements Property<String>, Button.PropertySetter, TextInput.PropertySetter, Text.PropertySetter {

	private final String value;

	public static TextProperty text(final String value) {
		return new TextProperty(value);
	}

	private TextProperty(final String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public void apply(final Button button) {
		button.setText(value());
	}

	@Override
	public void apply(final TextInput input) {
		input.setText(value());
	}

	@Override
	public void apply(final Text text) {
		text.setText(value());
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof TextProperty && this.value.equals(((TextProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
