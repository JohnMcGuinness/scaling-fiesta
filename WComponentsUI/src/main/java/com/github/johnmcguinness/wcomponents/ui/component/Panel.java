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

import com.github.bordertech.wcomponents.WPanel;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 * A Panel is used to group components together. Layouts can be used to arrange components within the panel.
 *
 * @author John McGuinness
 */
public final class Panel extends WPanel {

	/**
	 * The attribute name for storing the {@code visible} {@link Lazy} value.
	 */
	private static final String VISIBLE_ATTRIBUTE = "Panel.visible";

	/**
	 * The attribute name for storing the {@code hidden} {@link Lazy} value.
	 */
	private static final String HIDDEN_ATTRIBUTE = "Panel.hidden";

	/**
	 * The available panel types.
	 */
	public enum Type {
		/**
		 * A plain panel.
		 */
		PLAIN(WPanel.Type.PLAIN),
		/**
		 * A box panel has a border.
		 */
		BOX(WPanel.Type.BOX),
		/**
		 * The feature panel is highlighted by a background colour and border.
		 */
		FEATURE(WPanel.Type.FEATURE),
		/**
		 * The footer panel is only intended for use at the very bottom of an application.
		 */
		FOOTER(WPanel.Type.FOOTER),
		/**
		 * The header panel is only intended for use at the very top of an application.
		 */
		HEADER(WPanel.Type.HEADER);

		private final WPanel.Type type;

		Type(final WPanel.Type type) {
			this.type = type;
		}

		/**
		 * Converts this {@link Panel.Type} to a {@link WPanel.Type}.
		 *
		 * @return the converted value.
		 */
		public WPanel.Type type() {
			return type;
		}
	};

	/**
	 * Creates a WPanel and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this Panel.
	 * @return a Panel with properties applied.
	 */
	public static Panel panel(final Panel.PropertySetter... props) {
		final Panel panel = new Panel();
		Stream.of(props).forEach(prop -> prop.apply(panel));
		return panel;
	}

	private Panel() {
	}

	@Override
	public void setVisible(final boolean visible) {
		setVisible(() -> visible);
	}

	/**
	 * A {@link Lazy} value that indicates whether this panel is visible.
	 *
	 * @param visible The {@link Lazy} value that is evaluated to determine if the panel is visible.
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
	 * A {@link Lazy} value that indicates whether this panel is hidden.
	 *
	 * @param hidden The {@link Lazy} value that is evaluated to determine if the panel is hidden.
	 */
	public void setHidden(final Lazy<Boolean> hidden) {
		setAttribute(HIDDEN_ATTRIBUTE, hidden);
	}

	@Override
	public boolean isHidden() {
		final Lazy<Boolean> isHidden = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return isHidden == null ? super.isHidden(): Boolean.TRUE.equals(isHidden.get());
	}

	/**
	 * A property for a {@link Panel}.
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link Panel}.
		 *
		 * @param panel the panel to apply the property to.
		 */
		void apply(Panel panel);
	}
}
