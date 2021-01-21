package com.github.johnmcguinness.wcomponents.ui.property;

/**
 * Declares the active index property for components that have an active index.
 *
 * @author John McGuinness
 */
public final class ActiveIndexProperty extends IntProperty {

	/**
	 * Creates an {@link ActiveIndexProperty} using the provided value.
	 *
	 * @param value the {@code int} to use as the active index.
	 *
	 * @return a new {@link ActiveIndexProperty}.
	 */
	public ActiveIndexProperty activeIndex(final int value) {
		return new ActiveIndexProperty(value);
	}

	private ActiveIndexProperty(final int value) {
		super(value);
	}
}
