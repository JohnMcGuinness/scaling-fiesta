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

import com.github.bordertech.wcomponents.WComponent;
import com.github.bordertech.wcomponents.WField;
import com.github.bordertech.wcomponents.WFieldLayout;
import com.github.johnmcguinness.wcomponents.ui.LabelPosition;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class FieldLayout extends WFieldLayout {

	/**
	 * The attribute name for storing the {@code visible} {@link Lazy} value.
	 */
	private static final String VISIBLE_ATTRIBUTE = "FieldLayout.visible";

	/**
	 * The attribute name for storing the {@code hidden} {@link Lazy} value.
	 */
	private static final String HIDDEN_ATTRIBUTE = "FieldLayout.hidden";

	public static FieldLayout fieldLayout(final LabelPosition position, final PropertySetter... props) {

		final FieldLayout fieldlayout
			= position == null
				? new FieldLayout()
				: new FieldLayout(position);

		Stream.of(props).forEach(prop -> prop.apply(fieldlayout));
		return fieldlayout;
	}

	public static FieldLayout fieldLayout(final PropertySetter... props) {
		final FieldLayout fieldlayout = new FieldLayout();
		Stream.of(props).forEach(prop -> prop.apply(fieldlayout));
		return fieldlayout;
	}

	private FieldLayout(final LabelPosition pos) {
		super(pos.convert());
	}

	private FieldLayout() {
		super();
	}

	public void addField(final Field field) {
		addField(field.label(), field.labelled());
	}

	public List<WField> getFields() {

		final List<WField> fields = new ArrayList<>();

		for (WComponent child : getChildren()) {
			if (child instanceof WField) {
				fields.add((WField) child);
			}
		}

		return Collections.unmodifiableList(fields);
	}

	public Optional<WField> getField(final String label) {

		return getFields()
			.stream()
			.filter(f -> f.getLabelText().equalsIgnoreCase(label))
			.findFirst();
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
		return isHidden == null ? super.isHidden() : Boolean.TRUE.equals(isHidden.get());
	}

	/**
	 * A property for a {@link FieldLayout}.
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies the property to a {@link FieldLayout}.
		 *
		 * @param fieldlayout the {@link FieldLayout} to apply the
		 * property to.
		 */
		void apply(FieldLayout fieldlayout);
	}
}
