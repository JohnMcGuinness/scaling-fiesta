package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WAudio;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class Audio extends WAudio {

	/**
	 * The attribute name for storing the {@code autoplay}
	 * {@link Lazy} value.
	 */
	private static final String AUTOPLAY_ATTRIBUTE = "Audio.autoplay";

	/**
	 * The attribute name for storing the {@code loop} {@link Lazy} value.
	 */
	private static final String LOOP_ATTRIBUTE = "Audio.loop";

	/**
	 * The attribute name for storing the {@code muted} {@link Lazy} value.
	 */
	private static final String MUTED_ATTRIBUTE = "Audio.muted";

	/**
	 * The attribute name for storing the {@code renderControls}
	 * {@link Lazy} value.
	 */
	private static final String RENDER_CONTROLS_ATTRIBUTE
		= "Audio.render_controls";

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

	public void setAutoplay(final Lazy<Boolean> autoplay) {
		setAttribute(AUTOPLAY_ATTRIBUTE, autoplay);
	}

	@Override
	public boolean isAutoplay() {
		final Lazy<Boolean> autoplay = (Lazy<Boolean>) getAttribute(AUTOPLAY_ATTRIBUTE);
		return autoplay == null ? super.isAutoplay() : Boolean.TRUE.equals(autoplay.get());
	}

	public void setLoop(final Lazy<Boolean> loop) {
		setAttribute(LOOP_ATTRIBUTE, loop);
	}

	@Override
	public boolean isLoop() {
		final Lazy<Boolean> loop = (Lazy<Boolean>) getAttribute(LOOP_ATTRIBUTE);
		return loop == null ? super.isLoop() : Boolean.TRUE.equals(loop.get());
	}

	public void setMuted(final Lazy<Boolean> muted) {
		setAttribute(MUTED_ATTRIBUTE, muted);
	}

	@Override
	public boolean isMuted() {
		final Lazy<Boolean> muted = (Lazy<Boolean>) getAttribute(MUTED_ATTRIBUTE);
		return muted == null ? super.isMuted() : Boolean.TRUE.equals(muted.get());
	}

	public void setRenderControls(final Lazy<Boolean> renderControls) {
		setAttribute(RENDER_CONTROLS_ATTRIBUTE, renderControls);
	}

	@Override
	public boolean isRenderControls() {
		final Lazy<Boolean> renderControls = (Lazy<Boolean>) getAttribute(RENDER_CONTROLS_ATTRIBUTE);
		return renderControls == null ? super.isRenderControls() : Boolean.TRUE.equals(renderControls.get());
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
