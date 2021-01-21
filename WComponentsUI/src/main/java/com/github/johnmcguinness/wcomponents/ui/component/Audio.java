//  _ _ _  ___                                         _        _ _  _
// | | | ||  _] ___  _ _ _  ___  ___  _ _  ___  _ _  _| |_  ___| | || |
// | | | || [__/ . \| ' ' || . \/ . \| ' |/ ._]| ' |  | |  [_-[| | || |
// |__/_/ `___/\___/|_|_|_||  _/\___/|_|_|\___.|_|_|  |_|  /__/ \__||_|
//                         |_|
//
//  WComponentsUI provides a declarative API for creating WComponents web
//  applications.
//
package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WAudio;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 * A declarative API for embedding sound content in a document.
 *
 * @author John McGuinness
 */
public final class Audio extends WAudio {

	/**
	 * The attribute name for storing the {@code autoplay} {@link Lazy} value.
	 */
	private static final String AUTOPLAY_ATTRIBUTE = "Audio.autoplay";

	/**
	 * The attribute name for storing the {@code loop} {@link Lazy} value.
	 */
	private static final String LOOP_ATTRIBUTE = "Audio.loop";

	/**
	 * Creates a Audio and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a Audio.
	 * @return a Audio with the properties applied.
	 */
	public static Audio audio(final Audio.PropertySetter... props) {

		final Audio audio = new Audio();
		Stream.of(props).forEach(prop -> prop.apply(audio));
		return audio;
	}

	private Audio() {
		super();
	}

	/**
	 * Indicate using a {@link Lazy} value whether the clip should play automatically.
	 *
	 * @param autoplay The {@link Lazy} value that is evaluated to determine if the clip should play automatically.
	 */
	public void setAutoplay(final Lazy<Boolean> autoplay) {
		setAttribute(AUTOPLAY_ATTRIBUTE, autoplay);
	}

	@Override
	public boolean isAutoplay() {
		final Lazy<Boolean> autoplay = (Lazy<Boolean>) getAttribute(AUTOPLAY_ATTRIBUTE);
		return autoplay == null ? super.isAutoplay() : Boolean.TRUE.equals(autoplay.get());
	}

	/**
	 * Indicate using a {@link Lazy} value whether the audio clip playback should loop or stop at the end.
	 *
	 * @param loop The {@link Lazy} value that is evaluated to determine if the clip should loop.
	 */
	public void setLoop(final Lazy<Boolean> loop) {
		setAttribute(LOOP_ATTRIBUTE, loop);
	}

	@Override
	public boolean isLoop() {
		final Lazy<Boolean> loop = (Lazy<Boolean>) getAttribute(LOOP_ATTRIBUTE);
		return loop == null ? super.isLoop() : Boolean.TRUE.equals(loop.get());
	}

	/**
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link Audio}.
		 *
		 * @param audio the audio to apply the property to.
		 */
		void apply(Audio audio);
	}
}
