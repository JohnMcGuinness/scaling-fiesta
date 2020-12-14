package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Audio;

/**
 *
 * @author John McGuinness
 */
public final class CacheKeyProperty extends StringProperty implements Audio.PropertySetter {

	public static CacheKeyProperty cacheKey(final String value) {
		return new CacheKeyProperty(value);
	}

	private CacheKeyProperty(final String value) {
		super(value);
	}

	@Override
	public void apply(final Audio audio) {
		audio.setCacheKey(value());
	}
}
