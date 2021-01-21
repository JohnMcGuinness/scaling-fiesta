package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class LazyStringProperty implements Property<Lazy<String>> {

	private final Lazy<String> value;

	protected LazyStringProperty(final Lazy<String> value) {
		this.value = value;
	}

	@Override
	public Lazy<String> value() {
		return this.value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof LazyStringProperty && this.value.equals(((LazyStringProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
