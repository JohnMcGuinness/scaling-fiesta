package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 *
 * @author John McGuinness
 */
public final class MediaGroupProperty extends StringProperty implements Audio.PropertySetter {

	public static MediaGroupProperty mediaGroup(final String value) {
		return new MediaGroupProperty(value);
	}

	private MediaGroupProperty(final String value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setMediaGroup(value());
	}
}
