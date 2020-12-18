package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;

/**
 *
 * @author John McGuinness
 */
public final class ClientCommandOnlyProperty extends BooleanProperty implements Button.PropertySetter {

	public static ClientCommandOnlyProperty clientCommandOnly(final boolean value) {
		return new ClientCommandOnlyProperty(value);
	}
	
	private ClientCommandOnlyProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Button button) {
		button.setClientCommandOnly(value());
	}
}
