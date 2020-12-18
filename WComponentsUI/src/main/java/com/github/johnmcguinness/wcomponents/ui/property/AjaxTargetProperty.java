package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.AjaxTarget;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import com.github.johnmcguinness.wcomponents.ui.component.Button;

/**
 * Declares an ajax target property for components that have an ajax target.
 * 
 * @author John McGuinness
 */
public final class AjaxTargetProperty implements Property<Lazy<AjaxTarget>>, Button.PropertySetter {

	private final Lazy<AjaxTarget> value;
	
	public static AjaxTargetProperty ajaxTarget(final AjaxTarget value) {
		return ajaxTarget(() -> value);
	}
	
	public static AjaxTargetProperty ajaxTarget(final Lazy<AjaxTarget> value) {
		return new AjaxTargetProperty(value);
	}
	
	private AjaxTargetProperty(final Lazy<AjaxTarget> value) {
		this.value = value;
	}
	
	@Override
	public Lazy<AjaxTarget> value() {
		return value;
	}

	@Override
	public void apply(final Button button) {
		button.setAjaxTarget(value());
	}
}
