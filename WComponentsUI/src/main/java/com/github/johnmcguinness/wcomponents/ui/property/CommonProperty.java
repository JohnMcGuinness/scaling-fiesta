package com.github.bordertech.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WComponent;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the component
 */
public interface CommonProperty<T extends WComponent> {
	
	void apply(T component);
}
