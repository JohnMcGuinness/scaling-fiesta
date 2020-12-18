package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Image;
import com.github.bordertech.wcomponents.ImageResource;
import com.github.johnmcguinness.wcomponents.ui.component.Button;
import java.awt.Dimension;

/**
 *
 * @author John McGuinness
 */
public final class ImageProperty implements Property<Image>, Button.PropertySetter {

	private final Image value;
	
	public ImageProperty image(final String imageResource) {
		return new ImageProperty(new ImageResource(imageResource));
	}
	
	public ImageProperty image(final String imageResource, final String description) {
		return new ImageProperty(new ImageResource(imageResource, description));
	}
	
	public ImageProperty image(final String imageResource, final String description, final Dimension size) {
		return new ImageProperty(new ImageResource(imageResource, description, size));
	}
	
	private ImageProperty(final Image value) {
		this.value = value;
	}
	
	@Override
	public Image value() {
		return this.value;
	}

	@Override
	public void apply(final Button button) {
		button.setImage(value());
	}
}
