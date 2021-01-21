package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class LazyCharProperty implements Property<Lazy<Character>> {

	private final Lazy<Character> value;

	protected LazyCharProperty(final Lazy<Character> value) {
		this.value = value;
	}

	@Override
	public final Lazy<Character> value() {
		return this.value;
	}

	@Override
	public final boolean equals(final Object obj) {
		return obj instanceof LazyCharProperty && this.value == ((LazyCharProperty) obj).value;
	}

	@Override
	public final int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
