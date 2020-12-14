package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the options
 */
public final class SelectedOptionsProperty<T> implements Property<List<T>>, CheckBoxGroup.PropertySetter {

	private final List<T> value;

	public static <T> SelectedOptionsProperty selectedOptions(final T... options) {
		return selectedOptions(Arrays.asList(options));
	}

	public static <T> SelectedOptionsProperty selectedOptions(final List<T> options) {
		return new SelectedOptionsProperty(options);
	}
	
	private SelectedOptionsProperty(final List<T> value) {
		this.value = value;
	}
	
	@Override
	public List<T> value() {
		return this.value;
	}

	@Override
	public <U> void apply(final CheckBoxGroup<U> group) {
		group.setSelected(value());
	}
}
