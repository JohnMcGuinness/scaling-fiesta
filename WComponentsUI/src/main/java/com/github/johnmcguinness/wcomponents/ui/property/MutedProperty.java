package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 *
 * @author John McGuinness
 */
public final class MutedProperty extends BooleanProperty implements Audio.PropertySetter {

	public MutedProperty muted() {
		return muted(true);
	}

	public MutedProperty muted(final boolean value) {
		return new MutedProperty(value);
	}
	
	private MutedProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setMuted(value());
	}
}
