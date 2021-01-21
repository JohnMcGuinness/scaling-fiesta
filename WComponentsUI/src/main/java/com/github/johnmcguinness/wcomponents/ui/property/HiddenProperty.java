package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.Lazy;
import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.ProgressBar;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class HiddenProperty
		extends LazyBooleanProperty
		implements CheckBoxGroup.PropertySetter, ProgressBar.PropertySetter,
		Section.PropertySetter, FieldLayout.PropertySetter, Panel.PropertySetter {

	public static HiddenProperty hidden() {
		return hidden(true);
	}

	public static HiddenProperty hidden(final boolean value) {
		return hidden(() -> value);
	}

	public static HiddenProperty hidden(final Lazy<Boolean> value) {
		return new HiddenProperty(value);
	}

	private HiddenProperty(final Lazy<Boolean> value) {
		super(value);
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setHidden(value());
	}

	@Override
	public void apply(final ProgressBar progressBar) {
		progressBar.setHidden(value());
	}

	@Override
	public void apply(final Section section) {
		section.setHidden(value());
	}

	@Override
	public void apply(final Panel panel) {
		panel.setHidden(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setHidden(value());
	}
}
