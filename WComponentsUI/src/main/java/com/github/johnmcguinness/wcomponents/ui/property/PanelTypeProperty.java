package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import java.util.Objects;

/**
 * Declares the type of a {@link Panel}.
 * 
 * @author John McGuinness
 */
public final class PanelTypeProperty implements Property<Panel.Type>, Panel.PropertySetter {

	/** The value of this property. */
	private final Panel.Type value;

	/**
	 * Creates an instance of a {@link PanelTypeProperty}.
	 * @param value the value of this {@link Panel.Type}.
	 * @return an new instance of {@link PanelTypeProperty}.
	 */
	public static PanelTypeProperty panelType(final Panel.Type value) {
		return new PanelTypeProperty(Objects.requireNonNull(value, "value is null"));
	}

	private PanelTypeProperty(final Panel.Type value) {
		this.value = value;
	}

	@Override
	public void apply(final Panel panel) {
		panel.setType(value().type());
	}

	@Override
	public Panel.Type value() {
		return value;
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof PanelTypeProperty && Objects.equals(this.value, ((PanelTypeProperty) obj).value);
	}	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
