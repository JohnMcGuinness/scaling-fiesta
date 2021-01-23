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
		final Section section = new Section();
		Stream.of(props).forEach(prop -> prop.apply(section));
		return section;
	}

	private Section() {
		super("This section requires a heading");
	}

	@Override
	public void setVisible(final boolean visible) {
		setVisible(() -> visible);
	}

	/**
	 * A {@link Lazy} value that indicates whether this section is visible.
	 *
	 * @param visible The {@link Lazy} value that is evaluated to determine if the section is visible.
	 */
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

	/**
	 * A {@link Lazy} value that indicates whether this section is hidden.
	 *
	 * @param hidden The {@link Lazy} value that is evaluated to determine if the section is hidden.
	 */
	public void setHidden(final Lazy<Boolean> hidden) {
		setAttribute(HIDDEN_ATTRIBUTE, hidden);
	}

	@Override
	public boolean isHidden() {
		final Lazy<Boolean> isHidden = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return isHidden == null ? super.isHidden() : Boolean.TRUE.equals(isHidden.get());
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
