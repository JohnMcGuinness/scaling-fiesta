package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Margin;
import com.github.bordertech.wcomponents.Size;
import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;

/**
 *
 * @author John McGuinness
 */
public final class MarginProperty
	implements Property<Margin>, Panel.PropertySetter, FieldSet.PropertySetter,
	Section.PropertySetter, FieldLayout.PropertySetter {

	private final Margin value;

	public static MarginProperty margin(final Size all) {
		return new MarginProperty(new Margin(all));
	}

	public static MarginProperty margin(final Size topBottom, final Size leftRight) {
		return new MarginProperty(new Margin(topBottom, leftRight, topBottom, leftRight));
	}

	public static MarginProperty margin(final Size left, final Size topBottom, final Size right) {
		return new MarginProperty(new Margin(topBottom, right, topBottom, left));
	}

	public static MarginProperty margin(final Size top, final Size left, final Size bottom, final Size right) {
		return new MarginProperty(new Margin(top, right, bottom, left));
	}
	
	private MarginProperty(final Margin value) {
		this.value = value;
	}

	@Override
	public Margin value() {
		return this.value;
	}

	@Override
	public void apply(final Panel panel) {
		panel.setMargin(value());
	}

	@Override
	public void apply(final Section section) {
		section.setMargin(value());
	}

	@Override
	public void apply(final FieldSet fieldset) {
		fieldset.setMargin(value());
	}

	@Override
	public void apply(final FieldLayout fieldlayout) {
		fieldlayout.setMargin(value());
	}
}
