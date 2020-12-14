package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 *
 * @author John McGuinness
 */
public final class LoopProperty extends BooleanProperty implements Audio.PropertySetter {

	public LoopProperty loop() {
		return loop(true);
	}

	public LoopProperty loop(final boolean value) {
		return new LoopProperty(value);
	}

	private LoopProperty(final Boolean value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setLoop(value());
	}
}
