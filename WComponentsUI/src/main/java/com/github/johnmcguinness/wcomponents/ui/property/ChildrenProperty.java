package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WComponent;
import com.github.bordertech.wcomponents.WPanel;
import com.github.johnmcguinness.wcomponents.ui.component.FieldSet;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.Section;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author john
 */
public final class ChildrenProperty
		implements Property<List<WComponent>>,
		Panel.PropertySetter, FieldSet.PropertySetter, Section.PropertySetter {

	private final List<WComponent> value;

	public static ChildrenProperty children(final WComponent... children) {
		return new ChildrenProperty(Arrays.asList(children));
	}

	public static ChildrenProperty children(final List<WComponent> children) {
		return new ChildrenProperty(children);
	}

	private ChildrenProperty(final List<WComponent> value) {
		this.value = value;
	}

	@Override
	public List<WComponent> value() {
		return this.value;
	}

	@Override
	public void apply(final Panel panel) {
		
		for(WComponent child : value()) {
			panel.add(child);
		}
		
//		value().forEach(panel::add);
	}

	@Override
	public void apply(final FieldSet fieldset) {
		value().forEach(fieldset::add);
	}

	@Override
	public void apply(final Section section) {
		final WPanel content = section.getContent();
		value().forEach(child -> content.add(child));
	}
}
