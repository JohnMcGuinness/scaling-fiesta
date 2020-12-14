package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;

/**
 *
 * @author john
 */
public final class ImageUrlProperty extends StringProperty implements Button.PropertySetter {

	public static ImageUrlProperty imageUrl(final String value) {
		return new ImageUrlProperty(value);
	}

	private ImageUrlProperty(final String value) {
		super(value);
	}

	@Override
	public void apply(final Button button) {
		button.setImageUrl(value());
	}
}
