package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WComponent;
import com.github.johnmcguinness.wcomponents.ui.component.Field;
import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.Label;
import java.util.Arrays;
import java.util.List;

public final class FieldsProperty
	implements Property<List<Field>>, FieldLayout.PropertySetter {

	public static FieldsProperty fields(final Field... fields) {
		return new FieldsProperty(Arrays.asList(fields));
	}

	public static FieldsProperty fields(final List<Field> fields) {
		return new FieldsProperty(fields);
	}

	public static Field field(final String label, final WComponent labelled) {
		return field(Label.label(label), labelled);
	}

	public static Field field(final Label label, final WComponent labelled) {
		return new Field(label, labelled);
	}

	private final List<Field> value;

	private FieldsProperty(final List<Field> value) {
		this.value = value;
	}

	@Override
	public List<Field> value() {
		return this.value;
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		value().forEach(field -> fieldlayout.addField(field));
	}
}
