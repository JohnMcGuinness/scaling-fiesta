package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Button;

/**
 *
 * @author John McGuinness
 */
public final class RenderAsLinkProperty implements Property<Boolean>, Button.PropertySetter {

	private Boolean value;

	public static RenderAsLinkProperty renderAsLink() {
		return renderAsLink(true);
	}

	public static RenderAsLinkProperty renderAsLink(final boolean value) {
		return new RenderAsLinkProperty(value);
	}

	private RenderAsLinkProperty(final Boolean value) {
		this.value = value;
	}

	@Override
	public Boolean value() {
		return this.value;
	}

	@Override
	public void apply(final Button button) {
		button.setRenderAsLink(value());
	}
}
