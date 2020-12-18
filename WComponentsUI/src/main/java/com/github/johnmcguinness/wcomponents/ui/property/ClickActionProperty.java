package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Action;
import com.github.bordertech.wcomponents.ActionEvent;
import com.github.bordertech.wcomponents.WComponent;
import com.github.johnmcguinness.wcomponents.ui.component.Button;
import com.github.bordertech.wcomponents.validation.ValidatingAction;
import com.github.bordertech.wcomponents.validation.WValidationErrors;

/**
 *
 * @author John McGuinness
 */
public final class ClickActionProperty implements Property<Action>, Button.PropertySetter {

	private final Action value;

	public static ClickActionProperty onClick(final Action action) {
		return new ClickActionProperty(action);
	}

	public static ClickActionProperty onClick(final WValidationErrors errors, final WComponent validationTarget, final Action action) {
		
		return onClick(new ValidatingAction(errors, validationTarget) {
			@Override
			public void executeOnValid(final ActionEvent event) {
				action.execute(event);
			}
		});
	}
	
	public ClickActionProperty validating(final WComponent validationTarget, final WValidationErrors errors) {
		return onClick(new ValidatingAction(errors, validationTarget) {
			@Override
			public void executeOnValid(final ActionEvent event) {
				ClickActionProperty.this.value.execute(event);
			}
		});
	}
	
	private ClickActionProperty(final Action value) {
		this.value = value;
	}

	@Override
	public Action value() {
		return this.value;
	}

	@Override
	public void apply(final Button button) {
		button.setAction(value());
	}
}
