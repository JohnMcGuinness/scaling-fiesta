package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;
import com.github.johnmcguinness.wcomponents.ui.MediaPreload;

/**
 *
 * @author John McGuinness
 */
public final class PreloadProperty implements Property<MediaPreload>, Audio.PropertySetter {

	private final MediaPreload value;

	public static PreloadProperty preload(final MediaPreload value) {
		return new PreloadProperty(value);
	}

	private PreloadProperty(final MediaPreload value) {
		this.value = value;
	}

	@Override
	public MediaPreload value() {
		return this.value;
	}

	@Override
	public void apply(final Audio audio) {
		audio.setPreload(value().audioConvert());
	}
}
