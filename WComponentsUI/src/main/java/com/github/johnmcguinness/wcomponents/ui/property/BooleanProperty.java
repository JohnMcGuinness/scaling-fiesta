package com.github.johnmcguinness.wcomponents.ui.property;

import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class BooleanProperty implements Property<Boolean> {

	private final Boolean value;

	protected BooleanProperty(final Boolean value) {
		this.value = Boolean.TRUE.equals(value);
	}

	@Override
	public final Boolean value() {
		return this.value;
	}

	@Override
	public final boolean equals(final Object obj) {
		return obj instanceof BooleanProperty && Objects.equals(this.value, ((BooleanProperty) obj).value);
	}

	@Override
	public final int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
