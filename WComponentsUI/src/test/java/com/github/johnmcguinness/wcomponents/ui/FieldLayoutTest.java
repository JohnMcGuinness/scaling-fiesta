package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.AbstractWComponentTestCase;
import com.github.bordertech.wcomponents.WField;
import com.github.bordertech.wcomponents.WFieldLayout;
import com.github.johnmcguinness.wcomponents.ui.component.FieldLayout;
import static com.github.johnmcguinness.wcomponents.ui.component.FieldLayout.fieldLayout;
import static com.github.johnmcguinness.wcomponents.ui.component.TextInput.textInput;
import static com.github.johnmcguinness.wcomponents.ui.component.Field.field;
import static com.github.johnmcguinness.wcomponents.ui.property.FieldsProperty.fields;
import static com.github.johnmcguinness.wcomponents.ui.property.VisibleProperty.visible;
import static com.github.johnmcguinness.wcomponents.ui.property.HiddenProperty.hidden;
import static com.github.johnmcguinness.wcomponents.ui.property.TitleProperty.title;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * @author John McGuinness
 */
public class FieldLayoutTest extends AbstractWComponentTestCase {

	@Test
	public void testLabelPosition() {
		assertEquals(WFieldLayout.LAYOUT_FLAT,
			fieldLayout((LabelPosition) null).getLayoutType());
		assertEquals(WFieldLayout.LAYOUT_FLAT,
			fieldLayout().getLayoutType());
		assertEquals(WFieldLayout.LAYOUT_FLAT,
			fieldLayout(LabelPosition.BESIDE).getLayoutType());
		assertEquals(WFieldLayout.LAYOUT_STACKED,
			fieldLayout(LabelPosition.ABOVE).getLayoutType());
	}

	@Test
	public void testVisibleProperty() {

		final FieldLayout fieldLayout = fieldLayout();

		fieldLayout.setVisible(false);
		assertFalse(fieldLayout.isVisible());

		assertTrue(fieldLayout().isVisible());
		assertTrue(fieldLayout(visible()).isVisible());
		assertTrue(fieldLayout(visible(true)).isVisible());
		assertFalse(fieldLayout(visible(false)).isVisible());
		assertFalse(fieldLayout(visible(() -> false)).isVisible());
	}

	@Test
	public void testHiddenProperty() {

		final FieldLayout fieldLayout = fieldLayout();

		fieldLayout.setHidden(false);
		assertFalse(fieldLayout.isHidden());

		assertFalse(fieldLayout().isHidden());
		assertTrue(fieldLayout(hidden()).isHidden());
		assertFalse(fieldLayout(hidden(false)).isHidden());
		assertTrue(fieldLayout(hidden(true)).isHidden());
		assertFalse(fieldLayout(hidden(() -> false)).isHidden());
	}

    @Test
    public void getFieldTest() {

		assertFalse(
			fieldLayout().getField("NonExistentField").isPresent());

		final String aFieldLabel = "field1";

		final FieldLayout fieldLayout
			= fieldLayout(
				fields(
					field(aFieldLabel, textInput())
				)
			);

		assertTrue(fieldLayout.getField(aFieldLabel).isPresent());
		assertEquals(aFieldLabel,
			fieldLayout.getField(aFieldLabel).get().getLabelText());
	}

    @Test
    public void getFieldsTest() {

		final String fieldLabel1 = "field1";
		final String fieldLabel2 = "field2";

		final FieldLayout fieldLayout
			= fieldLayout(
				fields(
					field(fieldLabel1, textInput()),
					field(fieldLabel2, textInput())
				)
			);

		final List<WField> fields = fieldLayout.getFields();

		assertEquals(2, fields.size());

		assertTrue(
			fields
				.stream()
				.map(f -> f.getLabelText())
				.collect(Collectors.toSet())
				.containsAll(
					Arrays.asList(fieldLabel1, fieldLabel2)
				)
		);
	}

    @Test
    public void testTitleProperty() {

        final String aTitle = "A Title";

        assertNull(fieldLayout().getTitle());
        assertEquals(aTitle, fieldLayout(title(aTitle)).getTitle());
    }
}
