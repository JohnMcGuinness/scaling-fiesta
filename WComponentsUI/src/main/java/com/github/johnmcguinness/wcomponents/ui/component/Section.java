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
	 * Creates a Section and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this Section.
	 * @return a Section with properties applied.
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
	 * A property for a {@link Section}.
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
