package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Action;

/**
 * Declares an action property for components that support executing an action on submit.
 *
 * @author John McGuinness
 */
public abstract class ActionProperty implements Property<Action> {

	private final Action value;

	protected ActionProperty(final Action value) {
		this.value = value;
	}

	@Override
	public Action value() {
		return this.value;
	}
}
