package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WCheckBox;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 * A declarative API for declaring a CheckBox.
 * 
 * @author John McGuinness
 */
public final class CheckBox extends WCheckBox {

	private static final String DISABLED_ATTRIBUTE = "CheckBox.disabled";	

	private static final String MANDATORY_ATTRIBUTE = "CheckBox.mandatory";	

	private static final String READONLY_ATTRIBUTE = "CheckBox.readonly";	

	/**
	 * Creates a CheckBox and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a CheckBox.
	 * @return a CheckBox with the properties applied.
	 */
	public static CheckBox checkbox(final CheckBox.PropertySetter... props) {
		final CheckBox checkbox = new CheckBox();
		Stream.of(props).forEach(prop -> prop.apply(checkbox));
		return checkbox;
	}
	
	private CheckBox() { }
	
	public void setDisabled() {
		setDisabled(true);
	}
	
	public void setDisabled(final Lazy<Boolean> disabled) {
		setAttribute(DISABLED_ATTRIBUTE, disabled);
	}

	@Override
	public boolean isDisabled() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(DISABLED_ATTRIBUTE);
		return lazy == null ? super.isDisabled() : Boolean.TRUE.equals(lazy.get());
	}
	
	public void setMandatory(final Lazy<Boolean> mandatory) {
		setAttribute(MANDATORY_ATTRIBUTE, mandatory);
	}

	@Override
	public boolean isMandatory() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(MANDATORY_ATTRIBUTE);
		return lazy == null ? super.isMandatory() : Boolean.TRUE.equals(lazy.get());
	}
	
	public void setReadOnly(final Lazy<Boolean> readonly) {
		setAttribute(READONLY_ATTRIBUTE, readonly);
	}

	@Override
	public boolean isReadOnly() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(READONLY_ATTRIBUTE);
		return lazy == null ? super.isReadOnly() : Boolean.TRUE.equals(lazy.get());
	}

	/**
	 * Applies a property to a {@link CheckBox}.
	 * 
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link CheckBox}.
		 *
		 * @param checkbox the checkbox to apply the property to.
		 */
		void apply(CheckBox checkbox);
	}
}
