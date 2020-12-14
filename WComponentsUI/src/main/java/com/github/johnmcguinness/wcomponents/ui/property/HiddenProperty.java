package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import com.github.johnmcguinness.wcomponents.ui.component.ProgressBar;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class HiddenProperty
	extends BooleanProperty
	implements CheckBoxGroup.PropertySetter, ProgressBar.PropertySetter, Section.PropertySetter {

	public static HiddenProperty hidden(final boolean value) {
		return new HiddenProperty(value);
	}

	private HiddenProperty(final Boolean value) {
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
}
