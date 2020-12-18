package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WTextField;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class PasswordInput extends WTextField {

	private static final String READONLY_ATTRIBUTE = "PasswordInput.readOnly";
	
	private static final String MANDATORY_ATTRIBUTE = "PasswordInput.mandatory";
	
	public static PasswordInput passwordInput(final PasswordInput.PropertySetter... props) {
		
		final PasswordInput passwordInput = new PasswordInput();
		
		Stream.of(props).forEach(prop -> prop.apply(passwordInput));
		
		return passwordInput;
	}

	public void setReadOnly(final Lazy<Boolean> visible) {
		setAttribute(READONLY_ATTRIBUTE, visible);
	}

	@Override
	public boolean isReadOnly() {
		final Lazy<Boolean> isReadOnly = (Lazy<Boolean>) getAttribute(READONLY_ATTRIBUTE);
		return isReadOnly == null ? super.isReadOnly() : Boolean.TRUE.equals(isReadOnly.get());
	}

	public void setMandatory(final Lazy<Boolean> visible) {
		setAttribute(MANDATORY_ATTRIBUTE, visible);
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

		void apply(PasswordInput textInput);
	}
}
