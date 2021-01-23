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

import com.github.bordertech.wcomponents.WPasswordField;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class PasswordInput extends WPasswordField {

	private static final String READONLY_ATTRIBUTE = "PasswordInput.readOnly";

	private static final String MANDATORY_ATTRIBUTE = "PasswordInput.mandatory";

	/**
	 * Creates a {@link PasswordInput} and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this {@link PasswordInput}.
	 *
	 * @return a {@link PasswordInput} with properties applied.
	 */
	public static PasswordInput passwordInput(final PropertySetter... props) {

		final PasswordInput passwordInput = new PasswordInput();

		Stream.of(props).forEach(prop -> prop.apply(passwordInput));

		return passwordInput;
	}

	/**
	 * A {@link Lazy} value that indicates whether this check box group is read only.
	 *
	 * @param readonly The {@link Lazy} value that is evaluated to determine if the check box group is read only.
	 */
	public void setReadOnly(final Lazy<Boolean> readonly) {
		setAttribute(READONLY_ATTRIBUTE, readonly);
	}

	@Override
	public boolean isReadOnly() {
		final Lazy<Boolean> isReadOnly = (Lazy<Boolean>) getAttribute(READONLY_ATTRIBUTE);
		return isReadOnly == null ? super.isReadOnly() : Boolean.TRUE.equals(isReadOnly.get());
	}

	/**
	 * A {@link Lazy} value that indicates whether this password input is mandatory.
	 *
	 * @param mandatory The {@link Lazy} value that is evaluated to determine if the password input is mandatory.
	 */
	public void setMandatory(final Lazy<Boolean> mandatory) {
		setAttribute(MANDATORY_ATTRIBUTE, mandatory);
	}

	@Override
	public boolean isMandatory() {
		final Lazy<Boolean> isMandatory = (Lazy<Boolean>) getAttribute(MANDATORY_ATTRIBUTE);
		return isMandatory == null ? super.isMandatory() : Boolean.TRUE.equals(isMandatory.get());
	}

	/**
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link PasswordInput}.
		 *
		 * @param passwordInput the {@link PasswordInput} to apply the property to.
		 */
		void apply(PasswordInput passwordInput);
	}
}
