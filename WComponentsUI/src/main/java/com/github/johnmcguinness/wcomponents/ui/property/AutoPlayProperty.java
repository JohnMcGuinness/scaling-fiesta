package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 * Declares the auto play property for components that can play automatically.
 * 
 * @author John McGuinness
 */
public final class AutoPlayProperty extends BooleanProperty implements Audio.PropertySetter {

	public static AutoPlayProperty autoPlay() {
		return autoPlay(true);
	}

	public static AutoPlayProperty autoPlay(final boolean value) {
		return new AutoPlayProperty(value);
	}

	private AutoPlayProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setAutoplay(value());
	}
}
