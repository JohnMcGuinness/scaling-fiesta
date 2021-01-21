package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.ImagePosition;
import com.github.johnmcguinness.wcomponents.ui.component.Button;

/**
 *
 * @author John McGuinness
 */
public final class ImagePositionProperty implements Property<ImagePosition>, Button.PropertySetter {

	private final ImagePosition value;

	/**
	 * Position an image at the top.
	 */
	public static final ImagePositionProperty TOP = new ImagePositionProperty(ImagePosition.TOP);

	/**
	 * Position an image to the right.
	 */
	public static final ImagePositionProperty RIGHT = new ImagePositionProperty(ImagePosition.RIGHT);

	/**
	 * Position an image at the bottom.
	 */
	public static final ImagePositionProperty BOTTOM = new ImagePositionProperty(ImagePosition.BOTTOM);

	/**
	 * Position an image to the left.
	 */
	public static final ImagePositionProperty LEFT = new ImagePositionProperty(ImagePosition.LEFT);

	private ImagePositionProperty(final ImagePosition value) {
		this.value = value;
	}

	@Override
	public ImagePosition value() {
		return this.value;
	}

	@Override
	public void apply(final Button button) {
		button.setImagePosition(value().convertToButtonImagePosition());
	}
}
