package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Mode;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;
import java.util.Objects;

/**
 * Declares the mode of a {@link Panel}.
 * 
 * @author John McGuinness
 */
public final class ModeProperty implements Property<Mode>, Panel.PropertySetter, Section.PropertySetter {

	/** The value of this property. */
	private final Mode value;

	/**
	 * Creates an instance of a {@link ModeProperty}.
	 * @param value the value of this {@link Mode}.
	 * @return an newly constructed {@link ModeProperty}.
	 */
	public static ModeProperty mode(final Mode value) {
		return new ModeProperty(Objects.requireNonNull(value, "value is null"));
	}

	private ModeProperty(final Mode value) {
		this.value = value;
	}

	@Override
	public void apply(final Panel panel) {
		panel.setMode(value().panelMode());
	}

	@Override
	public void apply(final Section section) {
		section.setMode(value().sectionMode());
	}

	@Override
	public Mode value() {
		return value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof ModeProperty && Objects.equals(this.value, ((ModeProperty) obj).value);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 23 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
