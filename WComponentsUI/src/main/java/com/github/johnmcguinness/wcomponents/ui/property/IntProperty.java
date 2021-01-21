package com.github.johnmcguinness.wcomponents.ui.property;

import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class IntProperty implements Property<Integer> {

	private final Integer value;

	protected IntProperty(final Integer value) {
		this.value = value;
	}

	@Override
	public final Integer value() {
		return this.value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof IntProperty && Objects.equals(this.value, ((IntProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
