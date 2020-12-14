package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.AbstractWComponentTestCase;
import com.github.bordertech.wcomponents.WSection;
import static com.github.johnmcguinness.wcomponents.ui.component.Section.section;
import static com.github.johnmcguinness.wcomponents.ui.component.Text.text;
import static com.github.johnmcguinness.wcomponents.ui.property.ModeProperty.mode;
import static com.github.johnmcguinness.wcomponents.ui.property.VisibleProperty.visible;
import static com.github.johnmcguinness.wcomponents.ui.property.HiddenProperty.hidden;
import static com.github.johnmcguinness.wcomponents.ui.property.ChildrenProperty.children;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author John McGuinness
 */
public class Section_Test extends AbstractWComponentTestCase {

	@Test
	public void testSectionMode() {
		// There is no default Mode.
		assertNull(section().getMode());
		assertNull(section(mode(Mode.NONE)).getMode());
		assertEquals(WSection.SectionMode.LAZY, section(mode(Mode.LAZY)).getMode());
		assertEquals(WSection.SectionMode.EAGER, section(mode(Mode.EAGER)).getMode());
	}

	@Test
	public void testManyProperties() {

		WSection section =
			section(
				visible(false),
                                hidden(true),
				children(
					text("Hello"),
					text("Good bye")
				)
			);

		assertFalse(section.isVisible());
		assertTrue(section.isHidden());
                assertEquals(2, section.getContent().getChildCount());
	}
}
