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

	private static final String VALIDATE_ATTRIBUTE = "ProgressBar.validate";

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
		
		public WProgressBar.ProgressBarType convert() {
			return this.value;
		}
		
		public static Type lookup(final WProgressBar.ProgressBarType type) {
			
			if (NORMAL.value == type) {
				return Type.NORMAL;
			} else if (SMALL.value == type) {
				return Type.SMALL;
			} else {
				return null;
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

	private ProgressBar() { }

	public void setHtmlId(final String id) {
		super.setIdName(id);
	}

	public String getHtmlId() {
		return super.getIdName();
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

	@Override
	public int getMax() {
		return super.getMax();
	}	

	public void setType(final ProgressBar.Type type) {
		super.setProgressBarType(type.convert());
	}

	public ProgressBar.Type getType() {
		return ProgressBar.Type.lookup(super.getProgressBarType());
	}

	@Override
	public void setValidate(final boolean validate) {
		setValidate(() -> validate);
	}

	public void setValidate(final Lazy<Boolean> validate) {
		setAttribute(VALIDATE_ATTRIBUTE, validate);
	}

	@Override
	public boolean isValidate() {
		final Lazy<Boolean> lazyValue = (Lazy<Boolean>) getAttribute(VALIDATE_ATTRIBUTE);
		return lazyValue == null ? super.isVisible() : Boolean.TRUE.equals(lazyValue.get());
	}

	@Override
	public void setValue(final int value) {
		setValue(() -> value);
	}

	public void setValue(final Lazy<Integer> value) {
		setAttribute(VALUE_ATTRIBUTE, value);
	}

	@Override
	public int getValue() {
		final Lazy<Integer> lazyValue = (Lazy<Integer>) getAttribute(VALUE_ATTRIBUTE);
		return lazyValue == null ? super.getValue() : lazyValue.get();
	}

	@Override
	public void setHtmlClass(final String htmlClass) {
		super.setHtmlClass(htmlClass);
	}

	public String getHtmlClass() {
		return super.getHtmlClass();
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
