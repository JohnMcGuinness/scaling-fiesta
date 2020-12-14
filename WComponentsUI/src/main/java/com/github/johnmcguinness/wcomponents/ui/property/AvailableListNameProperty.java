package com.github.johnmcguinness.wcomponents.ui.property;

/**
 * Declares the name property of an 'available' list for components that have an
 * 'available' list.
 * 
 * @author John McGuinness
 */
public final class AvailableListNameProperty extends StringProperty {
	
	public static AvailableListNameProperty availableListName(final String value) {
		return new AvailableListNameProperty(value);
	}
	
	private AvailableListNameProperty(final String value) {
		super(value);
	}
}
