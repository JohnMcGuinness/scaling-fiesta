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

	/**
	 * Creates a {@link FieldLayout} with a label position of {@code position}.
	 *
	 * @param labelPosition the position of the {@link FieldLayout}s labels.
	 * @param props the properties to be applied to a {@link FieldLayout}.
	 *
	 * @return the new {@link FieldLayout} instance.
	 */
	public static FieldLayout fieldLayout(final LabelPosition labelPosition, final PropertySetter... props) {

		final FieldLayout fieldlayout = labelPosition == null ? new FieldLayout() : new FieldLayout(labelPosition);
		Stream.of(props).forEach(prop -> prop.apply(fieldlayout));
		return fieldlayout;
	}

	/**
	 * Creates a {@link FieldLayout} with the default label position of {@code LabelPosition.BESIDE}.
	 *
	 * @param props the properties to be applied to a {@link FieldLayout}.
	 *
	 * @return the new {@link FieldLayout} instance.
	 */
	public static FieldLayout fieldLayout(final PropertySetter... props) {
		final FieldLayout fieldlayout = new FieldLayout(LabelPosition.BESIDE);
		Stream.of(props).forEach(prop -> prop.apply(fieldlayout));
		return fieldlayout;
	}

	private FieldLayout(final LabelPosition labelPosition) {
		super(labelPosition.convert());
	}

	private FieldLayout() {
		this(LabelPosition.BESIDE);
	}

	/**
	 * Adds a {@link Field} to this {@link FieldLayout}.
	 *
	 * @param field the {@link Field} to be added.
	 */
	public void addField(final Field field) {
		addField(field.label(), field.labeled());
	}

	/**
	 * Retrieve all of the fields that are contained by this {@link FieldLayout}.
	 *
	 * @return an unmodifiable {@link List} of this {@link FieldLayout}s fields.
	 */
	public List<WField> getFields() {

		final List<WField> fields = new ArrayList<>();

		for (WComponent child : getChildren()) {
			if (child instanceof WField) {
				fields.add((WField) child);
			}
		}

		return Collections.unmodifiableList(fields);
	}

	/**
	 * Retrieve the {@link WField} in this {@link FieldLayout} with {@code label} as the text of its label.
	 *
	 * @param label
	 * @return the first {@link WField} that has {@code label} as the text of its label, or {@code Optional.empty()} if
	 * a label with that text is not present.
	 */
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

	/**
	 * A {@link Lazy} value that indicates whether this field layout is visible.
	 *
	 * @param visible The {@link Lazy} value that is evaluated to determine if the field layout is visible.
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
	 * A {@link Lazy} value that indicates whether this field layout is hidden.
	 *
	 * @param hidden The {@link Lazy} value that is evaluated to determine if the field layout is hidden.
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
