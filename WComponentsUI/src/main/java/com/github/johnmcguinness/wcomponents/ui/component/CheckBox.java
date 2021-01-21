//  _ _ _  ___                                         _        _ _  _
// | | | ||  _] ___  _ _ _  ___  ___  _ _  ___  _ _  _| |_  ___| | || |
// | | | || [__/ . \| ' ' || . \/ . \| ' |/ ._]| ' |  | |  [_-[| | || |
// |__/_/ `___/\___/|_|_|_||  _/\___/|_|_|\___.|_|_|  |_|  /__/ \__||_|
//                         |_|
//
//  WComponentsUI provides a declarative API for creating WComponents web
//  applications.
//
package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WCheckBox;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 * A declarative API for creating a CheckBox.
 *
 * @author John McGuinness
 */
public final class CheckBox extends WCheckBox {

	/**
	 * The attribute name for storing the {@code disabled} {@link Lazy} value.
	 */
	private static final String DISABLED_ATTRIBUTE = "CheckBox.disabled";

	/**
	 * The attribute name for storing the {@code mandatory} {@link Lazy} value.
	 */
	private static final String MANDATORY_ATTRIBUTE = "CheckBox.mandatory";

	/**
	 * The attribute name for storing the {@code readonly} {@link Lazy} value.
	 */
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

	private CheckBox() {
	}

	/**
	 * A {@link Lazy} value that indicates whether this check box is disabled.
	 *
	 * @param disabled The {@link Lazy} value that is evaluated to determine if the check box is disabled.
	 */
	public void setDisabled(final Lazy<Boolean> disabled) {
		setAttribute(DISABLED_ATTRIBUTE, disabled);
	}

	@Override
	public boolean isDisabled() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(DISABLED_ATTRIBUTE);
		return lazy == null ? super.isDisabled() : Boolean.TRUE.equals(lazy.get());
	}

	@Override
	public void setMandatory(final boolean mandatory) {
		setMandatory(() -> mandatory);
	}

	/**
	 * A {@link Lazy} value that indicates whether this check box is mandatory.
	 *
	 * @param mandatory The {@link Lazy} value that is evaluated to determine if the check box is mandatory.
	 */
	public void setMandatory(final Lazy<Boolean> mandatory) {
		setAttribute(MANDATORY_ATTRIBUTE, mandatory);
	}

	@Override
	public boolean isMandatory() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(MANDATORY_ATTRIBUTE);
		return lazy == null ? super.isMandatory() : Boolean.TRUE.equals(lazy.get());
	}

	@Override
	public void setReadOnly(final boolean readonly) {
		setReadOnly(() -> readonly);
	}

	/**
	 * A {@link Lazy} value that indicates whether this check box is read only.
	 *
	 * @param readonly The {@link Lazy} value that is evaluated to determine if the check box is read only.
	 */
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
