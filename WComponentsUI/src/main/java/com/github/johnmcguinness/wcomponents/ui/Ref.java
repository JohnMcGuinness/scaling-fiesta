package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WComponent;
import java.io.Serializable;

/**
 *
 * @author John McGuinness
 * @param <T> the type of component which this references.
 */
public final class Ref<T extends WComponent> implements Serializable {

	public static <T extends WComponent> Ref<T> create() {
		return new Ref<>();
	}
	
	private T current;
	
	private Ref() { }
	
	public T current() {
		checkInitialised();
		return this.current;
	}

	public void current(final T component) {
		checkNotInitialised();
		this.current = component;	
	}

	private void checkInitialised() {
		if (this.current == null) { 
			throw new IllegalStateException("This ref has not been initialised.");
		}
	}

	private void checkNotInitialised() {
		if (this.current != null) { 
			throw new IllegalStateException("Attempting to reinitialise a ref.");
		}
	}
}
