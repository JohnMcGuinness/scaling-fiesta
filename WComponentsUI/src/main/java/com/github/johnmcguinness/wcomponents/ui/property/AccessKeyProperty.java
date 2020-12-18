package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import java.util.Objects;

/**
 * Declares the access key property for components that support accessKey.
 * 
 * @author John McGuinness
 */
public final class AccessKeyProperty implements Property<Character>, Button.PropertySetter, Panel.PropertySetter {

	private final Character value;

	public static AccessKeyProperty accessKey(final char value) {
		return new AccessKeyProperty(value);
	}
	
	private AccessKeyProperty(final Character value) {
		this.value = value;
	}

	@Override
	public Character value() {
		return this.value;
	}

	@Override
	public void apply(final Panel panel) {
		panel.setAccessKey(value());
	}

	@Override
	public void apply(final Button button) {
		button.setAccessKey(value());
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof AccessKeyProperty && this.value.equals(((AccessKeyProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
