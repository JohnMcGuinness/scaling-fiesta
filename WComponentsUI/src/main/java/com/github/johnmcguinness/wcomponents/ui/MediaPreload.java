package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WAudio;
import com.github.bordertech.wcomponents.WVideo;

/**
 * This is used to indicate whether pre-loading of content should occur
 * before the media is played. If the media clip is a static, cacheable
 * resource then {@code Preload.AUTO} is highly recommended. If the media
 * is not cacheable and is streamed from the application's resources the
 * default value of {@code Preload.NONE} should usually be used.
 *
 * @author John McGuinness
 */
public enum MediaPreload {

	/**
	 * Do not pre-load any data. This is best for clips streamed from
	 * the application's resources or live feeds.
	 */
	NONE(WAudio.Preload.NONE, WVideo.Preload.NONE),

	/**
	 * Preload meta-data only.
	 */
	META_DATA(WAudio.Preload.META_DATA, WVideo.Preload.META_DATA),

	/**
	 * Let the client determine what to load. This is usually best for
	 * pre-recorded audio presented as cacheable
	 * static resources.
	 */
	AUTO(WAudio.Preload.AUTO, WVideo.Preload.AUTO);

	private final WAudio.Preload audio;

	private final WVideo.Preload video;

	MediaPreload(final WAudio.Preload audio, final WVideo.Preload video) {
		this.audio = audio;
		this.video = video;
	}

	/**
	 * Converts this {@link MediaPreload} to the equivalent
	 * {@link WAudio.Preload}.
	 *
	 * @return the equivalent {@link WAudio.Preload}
	 */
	public WAudio.Preload audioConvert() {
		return this.audio;
	}

	/**
	 * Converts this {@link MediaPreload} to the equivalent
	 * {@link WVideo.Preload}.
	 *
	 * @return the equivalent {@link WVideo.Preload}
	 */
	public WVideo.Preload videoConvert() {
		return this.video;
	}
}
