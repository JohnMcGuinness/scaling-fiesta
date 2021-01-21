package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.AbstractWComponentTestCase;
import com.github.bordertech.wcomponents.WSection;
import com.github.johnmcguinness.wcomponents.ui.component.Section;
import static com.github.bordertech.wcomponents.WSection.SectionMode;
import static com.github.johnmcguinness.wcomponents.ui.component.Section.section;
import static com.github.johnmcguinness.wcomponents.ui.component.Text.textContent;
import static com.github.johnmcguinness.wcomponents.ui.property.ModeProperty.mode;
import static com.github.johnmcguinness.wcomponents.ui.property.ChildrenProperty.children;
import static com.github.johnmcguinness.wcomponents.ui.property.HiddenProperty.hidden;
import static com.github.johnmcguinness.wcomponents.ui.property.VisibleProperty.visible;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author John McGuinness
 */
public class SectionTest extends AbstractWComponentTestCase {

	@Test
	public void testSectionMode() {
		// There is no default Mode.
		assertNull(section().getMode());
		assertNull(section(mode(Mode.NONE)).getMode());
		assertEquals(
			SectionMode.LAZY, section(mode(Mode.LAZY)).getMode());
		assertEquals(
			SectionMode.EAGER, section(mode(Mode.EAGER)).getMode()
		);
	}

	@Test
	public void testVisibleProperty() {

		final Section section = section();

		section.setVisible(false);
		assertFalse(section.isVisible());

		assertTrue(section().isVisible());
		assertTrue(section(visible()).isVisible());
		assertTrue(section(visible(true)).isVisible());
		assertFalse(section(visible(false)).isVisible());
		assertFalse(section(visible(() -> false)).isVisible());
		assertTrue(section(visible(() -> true)).isVisible());
		assertFalse(section(visible(() -> null)).isVisible());
	}

	@Test
	public void testHiddenProperty() {

		final Section section = section();

		section.setHidden(false);
		assertFalse(section.isHidden());

		assertFalse(section().isHidden());
		assertTrue(section(hidden()).isHidden());
		assertFalse(section(hidden(false)).isHidden());
		assertTrue(section(hidden(true)).isHidden());
		assertFalse(section(hidden(() -> false)).isHidden());
		assertTrue(section(hidden(() -> true)).isHidden());
		assertFalse(section(hidden(() -> null)).isHidden());
	}

	@Test
	public void testManyProperties() {

		WSection section =
			section(
				visible(false),
                hidden(true),
				children(
					textContent("Hello"),
					textContent("Good bye")
				)
			);

		assertFalse(section.isVisible());
		assertTrue(section.isHidden());
        assertEquals(2, section.getContent().getChildCount());
	}
}
