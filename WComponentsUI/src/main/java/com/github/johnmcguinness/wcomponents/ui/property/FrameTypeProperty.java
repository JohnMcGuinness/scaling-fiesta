package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;

/**
 *
 * @author John McGuinness
 */
public final class FrameTypeProperty
	implements Property<FieldSet.FrameType>, FieldSet.PropertySetter {

	private final FieldSet.FrameType value;

	public static FrameTypeProperty frameType(final FieldSet.FrameType value) {
		return new FrameTypeProperty(value);
	}
	
	private FrameTypeProperty(final FieldSet.FrameType value) {
		this.value = value;
	}
	
	@Override
	public FieldSet.FrameType value() {
		return this.value;
	}

	@Override
	public void apply(final FieldSet fieldset) {
		fieldset.setFrameType(value().convert());
	}
}
