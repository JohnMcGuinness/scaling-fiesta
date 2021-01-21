//  _ _ _  ___                                         _        _ _  _
// | | | ||  _] ___  _ _ _  ___  ___  _ _  ___  _ _  _| |_  ___| | || |
// | | | || [__/ . \| ' ' || . \/ . \| ' |/ ._]| ' |  | |  [_-[| | || |
// |__/_/ `___/\___/|_|_|_||  _/\___/|_|_|\___.|_|_|  |_|  /__/ \__||_|
//                         |_|
//
//  WComponentsUI provides a declarative API for creating WComponents web
//  applications.
//
package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.AjaxTarget;
import com.github.bordertech.wcomponents.WButton;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 * A declarative API for creating a Button.
 *
 * @author John McGuinness
 */
public final class Button extends WButton {

	/**
	 * The attribute name for storing the {@code ajaxTarget} {@link Lazy} value.
	 */
	private static final String AJAX_TARGET_ATTRIBUTE = "Button.ajaxTarget";

	/**
	 * The attribute name for storing the {@code disabled} {@link Lazy} value.
	 */
	private static final String DISABLED_ATTRIBUTE = "Button.disabled";

	/**
	 * Creates a Button and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a Button.
	 * @return a Button with the properties applied.
	 */
	public static Button button(final Button.PropertySetter... props) {

		final Button button = new Button();
		Stream.of(props).forEach(prop -> prop.apply(button));
		return button;
	}

	/**
	 * Creates a Button and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a Button.
	 * @return a WButton with the properties applied.
	 */
	public static Button cancelButton(final Button.PropertySetter... props) {

		final Button button = button(props);
		button.setCancel(true);
		return button;
	}

	private Button() {
	}

	@Override
	public void setAjaxTarget(final AjaxTarget ajaxTarget) {
		setAjaxTarget(() -> ajaxTarget);
	}

	/**
	 * Indicate using a {@link Lazy} value the AJAX target for the button.
	 *
	 * @param ajaxTarget The {@link Lazy} value that is evaluated to retrieve the ajaxTarget.
	 */
	public void setAjaxTarget(final Lazy<AjaxTarget> ajaxTarget) {
		setAttribute(AJAX_TARGET_ATTRIBUTE, ajaxTarget);
	}

	@Override
	public AjaxTarget getAjaxTarget() {
		final Lazy<AjaxTarget> ajaxTarget = (Lazy<AjaxTarget>) getAttribute(AJAX_TARGET_ATTRIBUTE);
		return ajaxTarget == null ? super.getAjaxTarget() : ajaxTarget.get();
	}

	/**
	 * A {@link Lazy} value that indicates whether this button is disabled.
	 *
	 * @param disabled The {@link Lazy} value that is evaluated to determine if the button is disabled.
	 */
	public void setDisabled(final Lazy<Boolean> disabled) {
		setAttribute(DISABLED_ATTRIBUTE, disabled);
	}

	@Override
	public void setDisabled(final boolean disabled) {
		setDisabled(() -> disabled);
	}

	@Override
	public boolean isDisabled() {
		final Lazy<Boolean> disabled = (Lazy<Boolean>) getAttribute(DISABLED_ATTRIBUTE);
		return disabled == null ? super.isDisabled() : Boolean.TRUE.equals(disabled.get());
	}

	/**
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link Button}.
		 *
		 * @param button the button to apply the property to.
		 */
		void apply(Button button);
	}
}
