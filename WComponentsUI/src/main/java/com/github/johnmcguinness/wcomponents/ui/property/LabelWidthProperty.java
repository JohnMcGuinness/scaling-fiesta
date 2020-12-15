package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;

/**
 *
 * @author John McGuinness
 */
public final class LabelWidthProperty
	extends IntProperty
	implements FieldLayout.PropertySetter {

	public static LabelWidthProperty labelWidth(final int value) {
		return new LabelWidthProperty(value);
	}
	
	private LabelWidthProperty(final int value) {
		super(value);
	}

	@Override
	public void apply(FieldLayout fieldlayout) {
		fieldlayout.setLabelWidth(value());
	}
}
