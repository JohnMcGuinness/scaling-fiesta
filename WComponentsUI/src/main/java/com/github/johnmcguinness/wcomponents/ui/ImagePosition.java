package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WButton;
import com.github.bordertech.wcomponents.WLink;

/**
 * The position of an image for components that display an image.
 */
public enum ImagePosition {
		
	/** Position at the top. */
	TOP(WButton.ImagePosition.NORTH, WLink.ImagePosition.NORTH), 

	/** Position at the left. */
	LEFT(WButton.ImagePosition.WEST, WLink.ImagePosition.WEST),

	/** Position at the bottom. */
	BOTTOM(WButton.ImagePosition.SOUTH, WLink.ImagePosition.SOUTH),

	/** Position at the right. */
	RIGHT(WButton.ImagePosition.EAST, WLink.ImagePosition.EAST);

	private final WButton.ImagePosition buttonImagePosition;

	private final WLink.ImagePosition linkImagePosition;

	ImagePosition(final WButton.ImagePosition buttonImagePosition, final WLink.ImagePosition linkImagePosition) {
		this.buttonImagePosition = buttonImagePosition;
		this.linkImagePosition = linkImagePosition;
	}

	/**
	 * Converts this {@link ImagePosition} to a {@link WButton.ImagePosition}.
	 * 
	 * @return the equivalent {@link WButton.ImagePosition}.
	 */
	public WButton.ImagePosition convertToButtonImagePosition() {
		return this.buttonImagePosition;
	}


	/**
	 * Converts this {@link ImagePosition} to a {@link WLink.ImagePosition}.
	 * 
	 * @return the equivalent {@link WLink.ImagePosition}.
	 */
	public WLink.ImagePosition convertToLinkImagePosition() {
		return this.linkImagePosition;
	}
}
