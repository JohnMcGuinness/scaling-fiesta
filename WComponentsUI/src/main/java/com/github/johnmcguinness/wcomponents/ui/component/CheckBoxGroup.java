package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WCheckBoxSelect;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the options in the group
 */
public final class CheckBoxGroup<T> extends WCheckBoxSelect {

	private static final String DISABLED_ATTRIBUTE = "CheckBoxGroup.disabled";	

	private static final String MANDATORY_ATTRIBUTE = "CheckBoxGroup.mandatory";	

	private static final String READONLY_ATTRIBUTE = "CheckBoxGroup.readonly";	

	private static final String VISIBLE_ATTRIBUTE = "CheckBoxGroup.visible";	

	private static final String HIDDEN_ATTRIBUTE = "CheckBoxGroup.hidden";	
	
	/**
	 * Creates a CheckBoxGroup and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a CheckBoxGroup.
	 * @return a CheckBoxGroup with the properties applied.
	 */
	public static CheckBoxGroup checkboxGroup(final CheckBoxGroup.PropertySetter... props) {
		final CheckBoxGroup checkbox = new CheckBoxGroup();
		Stream.of(props).forEach(prop -> prop.apply(checkbox));
		return checkbox;
	}

	private CheckBoxGroup() { }
	
	@Override
	public void setDisabled(final boolean disabled) {
		setDisabled(() -> disabled);
	}

	public void setDisabled(final Lazy<Boolean> disabled) {
		setAttribute(DISABLED_ATTRIBUTE, disabled);
	}

	@Override
	public boolean isDisabled() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(DISABLED_ATTRIBUTE);
		return lazy == null ? super.isDisabled() : Boolean.TRUE.equals(lazy.get());
	}
	
	@Override
	public void setMandatory(final boolean mandatory) {
		setMandatory(() -> mandatory);
	}
	
	public void setMandatory(final Lazy<Boolean> mandatory) {
		setAttribute(MANDATORY_ATTRIBUTE, mandatory);
	}

	@Override
	public boolean isMandatory() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(MANDATORY_ATTRIBUTE);
		return lazy == null ? super.isMandatory() : Boolean.TRUE.equals(lazy.get());
	}
	
	@Override
	public void setReadOnly(final boolean readonly) {
		setReadOnly(() -> readonly);
	}

	public void setReadOnly(final Lazy<Boolean> readonly) {
		setAttribute(READONLY_ATTRIBUTE, readonly);
	}

	@Override
	public boolean isReadOnly() {
		final Lazy<Boolean> lazy = (Lazy<Boolean>) getAttribute(READONLY_ATTRIBUTE);
		return lazy == null ? super.isReadOnly() : Boolean.TRUE.equals(lazy.get());
	}

	public void setHtmlId(final String id) {
		super.setIdName(id);
	}

	public String getHtmlId() {
		return super.getIdName();
	}

	@Override
	public List<T> getSelected() {
		return (List<T>) super.getSelected();
	}

	@Override
	public void setVisible(final boolean visible) {
		setVisible(() -> visible);
	}

	public void setVisible(final Lazy<Boolean> visible) {
		setAttribute(VISIBLE_ATTRIBUTE, visible);
	}

	@Override
	public boolean isVisible() {
		final Lazy<Boolean> lazyValue = (Lazy<Boolean>) getAttribute(VISIBLE_ATTRIBUTE);
		return lazyValue == null ? super.isVisible() : Boolean.TRUE.equals(lazyValue.get());
	}

	@Override
	public void setHidden(final boolean hidden) {
		setHidden(() -> hidden);
	}

	public void setHidden(final Lazy<Boolean> hidden) {
		setAttribute(HIDDEN_ATTRIBUTE, hidden);
	}

	@Override
	public boolean isHidden() {
		final Lazy<Boolean> lazyValue = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return lazyValue == null ? super.isVisible() : Boolean.TRUE.equals(lazyValue.get());
	}

	/**
	 * Applies a property to a {@link CheckBoxGroup}.
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link CheckBoxGroup}.
		 *
		 * @param <T> the type of the options in the group
		 * @param group the CheckBoxGroup to apply the property to.
		 */
		<T> void apply(CheckBoxGroup<T> group);
	}
}
