package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.Objects;

/**
 *
 * @author John McGuinness
 */
public abstract class LazyBooleanProperty implements Property<Lazy<Boolean>> {

	private final Lazy<Boolean> value;

	protected LazyBooleanProperty(final Lazy<Boolean> value) {
		this.value = value;
	}

	@Override
	public final Lazy<Boolean> value() {
		return this.value;
	}

	@Override
	public final boolean equals(final Object obj) {
		return obj instanceof LazyBooleanProperty && this.value == ((LazyBooleanProperty) obj).value;
	}

	@Override
	public final int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
