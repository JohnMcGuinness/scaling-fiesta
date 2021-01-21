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

import com.github.bordertech.wcomponents.WTextField;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class TextInput extends WTextField {

	private static final String READONLY_ATTRIBUTE = "TextInput.readOnly";

	private static final String MANDATORY_ATTRIBUTE = "TextInput.mandatory";

	/**
	 * Creates a {@link TextInput} and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this {@link TextInput}.
	 *
	 * @return a {@link TextInput} with properties applied.
	 */
	public static TextInput textInput(final TextInput.PropertySetter... props) {

		final TextInput textInput = new TextInput();

		Stream.of(props).forEach(prop -> prop.apply(textInput));

		return textInput;
	}

	/**
	 * A {@link Lazy} value that indicates whether this text input is read only.
	 *
	 * @param readonly The {@link Lazy} value that is evaluated to determine if the text input is read only.
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
	 * A {@link Lazy} value that indicates whether this text input is mandatory.
	 *
	 * @param mandatory The {@link Lazy} value that is evaluated to determine if the text input is mandatory.
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
		 * Applies the property to a {@link TextInput}.
		 *
		 * @param textInput the {@link TextInput} to apply the property to.
		 */
		void apply(TextInput textInput);
	}
}
