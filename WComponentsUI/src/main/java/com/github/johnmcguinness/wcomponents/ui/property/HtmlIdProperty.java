package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class HtmlIdProperty
	extends StringProperty
	implements CheckBoxGroup.PropertySetter, Panel.PropertySetter,
		Section.PropertySetter, FieldSet.PropertySetter, FieldLayout.PropertySetter {

	public static HtmlIdProperty htmlId(final String value) {
		return new HtmlIdProperty(value);
	}

	private HtmlIdProperty(final String value) {
		super(value);
	}

	@Override
	public <T> void apply(final CheckBoxGroup<T> group) {
		group.setHtmlId(value());
	}

	@Override
	public void apply(final Panel panel) {
		panel.setIdName(value());
	}

	@Override
	public void apply(final Section section) {
		section.setIdName(value());
	}

	@Override
	public void apply(final FieldSet fieldset) {
		fieldset.setIdName(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setIdName(value());
	}
}
