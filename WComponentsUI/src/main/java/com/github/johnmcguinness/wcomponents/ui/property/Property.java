package com.github.johnmcguinness.wcomponents.ui.property;

/**
 * All properties must implement this interface.
 * 
 * @param <T> the type of this property.
 * 
 * @author John McGuinness
 */
public interface Property<T> {

	/**
	 * The value of this property.
	 * 
	 * @return the value of this property.
	 */
	T value();
}
