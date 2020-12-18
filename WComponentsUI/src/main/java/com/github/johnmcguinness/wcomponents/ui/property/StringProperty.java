package com.github.johnmcguinness.wcomponents.ui.property;

import java.util.Objects;

/**
 * 
 * @author John McGuinness
 */
public abstract class StringProperty implements Property<String> {

	private final String value;
	
	protected StringProperty(final String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return this.value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof StringProperty && this.value.equals(((StringProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
