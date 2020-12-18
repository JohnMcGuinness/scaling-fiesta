package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.CheckBoxGroup;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the options
 */
public final class OptionsProperty<T> implements Property<List<T>>, CheckBoxGroup.PropertySetter {

	private final List<T> value;

	public static <T> OptionsProperty options(final T... options) {
		return options(Arrays.asList(options));
	}

	public static <T> OptionsProperty options(final List<T> options) {
		return new OptionsProperty(options);
	}
	
	private OptionsProperty(final List<T> value) {
		this.value = value;
	}
	
	@Override
	public List<T> value() {
		return this.value;
	}

	@Override
	public <U> void apply(final CheckBoxGroup<U> group) {
		group.setOptions(value());
	}
}
