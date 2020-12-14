package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 *
 * @author John McGuinness
 */
public final class ShowControlsProperty extends BooleanProperty implements Audio.PropertySetter {

	public ShowControlsProperty showControls() {
		return showControls(true);
	}

	public ShowControlsProperty showControls(final boolean value) {
		return new ShowControlsProperty(value);
	}
	
	private ShowControlsProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setRenderControls(value());
	}
}
