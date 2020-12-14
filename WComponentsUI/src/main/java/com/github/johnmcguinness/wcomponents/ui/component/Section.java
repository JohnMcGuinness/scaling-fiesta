package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WSection;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class Section extends WSection {

	private static final String VISIBLE_ATTRIBUTE = "Section.visible";

	private static final String HIDDEN_ATTRIBUTE = "Section.hidden";

	/**
	 * The available types of section mode.
	 */
	public enum Mode {
		/**
		 * A lazy section will load its content via AJAX when it is made visible.
		 */
		LAZY(WSection.SectionMode.LAZY),
		/**
		 * An eager section will load its content via AJAX immediately after the
		 * page is loaded.
		 */
		EAGER(WSection.SectionMode.EAGER),
		/**
		 * An section with no mode does not load its content via AJAX.
		 */
		NONE(null);

		private final WSection.SectionMode mode;

		Mode(final WSection.SectionMode mode) {
			this.mode = mode;
		}

		public WSection.SectionMode mode() {
			return this.mode;
		}
	};

	/**
	 * Creates a WPanel and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this Panel.
	 * @return a WPanel with properties applied.
	 */
	public static Section section(final Section.PropertySetter... props) {
		final Section panel = new Section();
		Stream.of(props).forEach(prop -> prop.apply(panel));
		return panel;
	}

	private Section() {
		super("This section requires a heading");
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
		final Lazy<Boolean> isVisible = (Lazy<Boolean>) getAttribute(VISIBLE_ATTRIBUTE);
		return isVisible == null ? super.isVisible() : Boolean.TRUE.equals(isVisible.get());
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
		final Lazy<Boolean> isHidden = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return isHidden == null ? super.isVisible() : Boolean.TRUE.equals(isHidden.get());
	}

	/**
	 * A property for a {@link Panel}.
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link Section}.
		 *
		 * @param section the section to apply the property to.
		 */
		void apply(Section section);
	}
}
