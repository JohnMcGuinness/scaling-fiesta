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

import com.github.bordertech.wcomponents.WProgressBar;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class ProgressBar extends WProgressBar {

	private static final String HIDDEN_ATTRIBUTE = "ProgressBar.hidden";

	private static final String VISIBLE_ATTRIBUTE = "ProgressBar.visible";

	private static final String VALUE_ATTRIBUTE = "ProgressBar.value";

	/**
	 * Progress bar types.
	 */
	public enum Type {

		/**
		 * A normal progress bar.
		 */
		NORMAL(WProgressBar.ProgressBarType.NORMAL),
		/**
		 * A smaller progress bar.
		 */
		SMALL(WProgressBar.ProgressBarType.SMALL);

		private final ProgressBarType value;

		Type(final WProgressBar.ProgressBarType type) {
			this.value = type;
		}

		/**
		 * Convert from the {@link ProgressBar.Type} to the equivalent {@link WProgressBar.ProgressBarType} value.
		 *
		 * @return the converted {@link WProgressBar.ProgressBarType} value.
		 */
		public WProgressBar.ProgressBarType convert() {
			return this.value;
		}

		/**
		 * Converts a {@link WProgressBar.ProgressBarType} to a {@link ProgressBar.Type}.
		 *
		 * @param type the {@link WProgressBar.ProgressBarType} to convert from.
		 *
		 * @return the converted {@link ProgressBar.Type}.
		 */
		public static Type lookup(final WProgressBar.ProgressBarType type) {

			if (SMALL.value == type) {
				return Type.SMALL;
			} else {
				return Type.NORMAL;
			}
		}
	}

	/**
	 * Creates a ProgressBar and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to a ProgressBar.
	 * @return a ProgressBar with the properties applied.
	 */
	public static ProgressBar progressBar(final ProgressBar.PropertySetter... props) {

		final ProgressBar button = new ProgressBar();
		Stream.of(props).forEach(prop -> prop.apply(button));
		return button;
	}

	private ProgressBar() {
	}

	@Override
	public void setVisible(final boolean visible) {
		setVisible(() -> visible);
	}

	/**
	 * A {@link Lazy} value that indicates whether this progress bar is visible.
	 *
	 * @param visible The {@link Lazy} value that is evaluated to determine if the progress bar is visible.
	 */
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

	/**
	 * A {@link Lazy} value that indicates whether this progress bar is hidden.
	 *
	 * @param hidden The {@link Lazy} value that is evaluated to determine if the progress bar is hidden.
	 */
	public void setHidden(final Lazy<Boolean> hidden) {
		setAttribute(HIDDEN_ATTRIBUTE, hidden);
	}

	@Override
	public boolean isHidden() {
		final Lazy<Boolean> lazyValue = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return lazyValue == null ? super.isHidden(): Boolean.TRUE.equals(lazyValue.get());
	}

	@Override
	public int getMax() {
		return super.getMax();
	}

	/**
	 * Sets the type of this {@link ProgressBar}.
	 *
	 * @param type the type of this {@link ProgressBar}.
	 */
	public void setType(final ProgressBar.Type type) {
		super.setProgressBarType(type.convert());
	}

	/**
	 * Retrieves the type of this {@link ProgressBar}.
	 *
	 * @return the type of this {@link ProgressBar}.
	 */
	public ProgressBar.Type getType() {
		return ProgressBar.Type.lookup(super.getProgressBarType());
	}

	@Override
	public void setValue(final int value) {
		setValue(() -> value);
	}

	/**
	 * A {@link Lazy} value that sets the current value of this {@link ProgressBar}.
	 *
	 * @param value The {@link Lazy} value that is evaluated to determine the current value of this {@link ProgressBar}.
	 */
	public void setValue(final Lazy<Integer> value) {
		setAttribute(VALUE_ATTRIBUTE, value);
	}

	@Override
	public int getValue() {
		final Lazy<Integer> lazyValue = (Lazy<Integer>) getAttribute(VALUE_ATTRIBUTE);
		return lazyValue == null ? super.getValue() : lazyValue.get();
	}

	/**
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link ProgressBar}.
		 *
		 * @param progressBar the progressBar to apply the property to.
		 */
		void apply(ProgressBar progressBar);
	}
}
