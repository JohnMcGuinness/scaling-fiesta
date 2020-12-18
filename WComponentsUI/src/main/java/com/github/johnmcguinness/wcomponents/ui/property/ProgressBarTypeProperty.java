package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.ProgressBar;
import java.util.Objects;

/**
 * Declares the type of a {@link ProgressBar}.
 * 
 * @author John McGuinness
 */
public final class ProgressBarTypeProperty implements Property<ProgressBar.Type>, ProgressBar.PropertySetter {

	/** The value of this property. */
	private final ProgressBar.Type value;

	/**
	 * Creates an instance of a {@link ProgressBarTypeProperty}.
	 * @param value the value of this {@link ProgressBar.Type}.
	 * @return an new instance of {@link ProgressBarTypeProperty}.
	 */
	public static ProgressBarTypeProperty panelType(final ProgressBar.Type value) {
		return new ProgressBarTypeProperty(Objects.requireNonNull(value, "value is null"));
	}

	private ProgressBarTypeProperty(final ProgressBar.Type value) {
		this.value = value;
	}

	@Override
	public void apply(final ProgressBar progressBar) {
		progressBar.setType(value());
	}

	@Override
	public ProgressBar.Type value() {
		return value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof ProgressBarTypeProperty && Objects.equals(this.value, ((ProgressBarTypeProperty) obj).value);
	}	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
