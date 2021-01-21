package com.github.johnmcguinness.wcomponents.ui.property;

import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class CharProperty implements Property<Character> {

	private final Character value;

	protected CharProperty(final Character value) {
		this.value = value;
	}

	@Override
	public final Character value() {
		return this.value;
	}

	@Override
	public final boolean equals(final Object obj) {
		return obj instanceof CharProperty && Objects.equals(this.value, ((CharProperty) obj).value);
	}

	@Override
	public final int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
