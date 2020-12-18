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
public final class VisibleProperty extends LazyBooleanProperty
	implements Panel.PropertySetter, ProgressBar.PropertySetter,
        CheckBoxGroup.PropertySetter, Section.PropertySetter,
        FieldLayout.PropertySetter {

	public static VisibleProperty visible() {
		return visible(true);
	}

	public static VisibleProperty visible(final boolean value) {
		return visible(() -> value);
	}

	public static VisibleProperty visible(final Lazy<Boolean> value) {
		return new VisibleProperty(value);
	}

	private VisibleProperty(final Lazy<Boolean> value) {
		super(value);
	}

	@Override
	public void apply(final Panel panel) {
		panel.setVisible(value());
	}

	@Override
	public void apply(final ProgressBar progressBar) {
		progressBar.setVisible(value());
	}

	@Override
	public void apply(final CheckBoxGroup group) {
		group.setVisible(value());
	}

	@Override
	public void apply(final Section section) {
		section.setVisible(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setVisible(value());
	}
}
