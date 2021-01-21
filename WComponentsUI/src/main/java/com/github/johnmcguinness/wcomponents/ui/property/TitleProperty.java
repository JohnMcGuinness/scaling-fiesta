package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import java.util.Objects;

/**
 * Declare the title for a component.
 *
 * @author John McGuinness
 */
public final class TitleProperty
	implements Property<String>, FieldSet.PropertySetter, FieldLayout.PropertySetter {

	private final String value;

	public static TitleProperty title(final String value) {
		return new TitleProperty(value);
	}

	private TitleProperty(final String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public void apply(final FieldSet fieldset) {
		fieldset.setTitle(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setTitle(value());
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof TitleProperty && this.value.equals(((TitleProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
