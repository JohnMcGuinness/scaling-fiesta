package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class ClientSideProperty extends BooleanProperty {
	
	public static ClientSideProperty clientSide() {
		return clientSide(true);
	}
	
	public static ClientSideProperty clientSide(final boolean value) {
		return new ClientSideProperty(value);
	}
	
	private ClientSideProperty(final Boolean value) {
		super(value);
	}
}
