package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.AbstractWComponentTestCase;
import com.github.bordertech.wcomponents.WPanel;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import static com.github.johnmcguinness.wcomponents.ui.component.Panel.panel;
import static com.github.johnmcguinness.wcomponents.ui.property.AccessKeyProperty.accessKey;
import static com.github.johnmcguinness.wcomponents.ui.property.HiddenProperty.hidden;
import static com.github.johnmcguinness.wcomponents.ui.property.ModeProperty.mode;
import static com.github.johnmcguinness.wcomponents.ui.property.PanelTypeProperty.panelType;
import static com.github.johnmcguinness.wcomponents.ui.property.VisibleProperty.visible;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author John McGuinness
 */
public class PanelTest extends AbstractWComponentTestCase {

	@Test
	public void testPanelType() {
		// The default type is PLAIN.
		assertEquals(WPanel.Type.PLAIN, panel().getType());
        assertEquals(WPanel.Type.BOX, panel(panelType(Panel.Type.BOX)).getType());
	}

	@Test
	public void testPanelMode() {
		// There is no default Mode.
		assertNull(panel().getMode());
        assertEquals(WPanel.PanelMode.LAZY, panel(mode(Mode.LAZY)).getMode());
	}

	@Test
	public void testAccessKey() {
		// The default accessKey is the NULL CHAR.
		assertEquals('\0', panel().getAccessKey());
		assertEquals('c', panel(accessKey('c')).getAccessKey());
	}


	@Test
	public void testVisibleProperty() {

		final Panel fieldLayout = panel();

		fieldLayout.setVisible(false);
		assertFalse(fieldLayout.isVisible());

		assertTrue(panel().isVisible());
		assertTrue(panel(visible()).isVisible());
		assertTrue(panel(visible(true)).isVisible());
		assertFalse(panel(visible(false)).isVisible());
		assertFalse(panel(visible(() -> false)).isVisible());
	}

	@Test
	public void testHiddenProperty() {

		final Panel panel = panel();

		panel.setHidden(false);
		assertFalse(panel.isHidden());

		assertTrue(panel().isHidden());
		assertTrue(panel(hidden()).isHidden());
		assertFalse(panel(hidden(false)).isHidden());
		assertTrue(panel(hidden(true)).isHidden());
		assertFalse(panel(hidden(() -> false)).isHidden());
	}

	@Test
	public void testManyProperties() {

		WPanel panel =
			panel(
				panelType(Panel.Type.BOX),
				mode(Mode.LAZY),
				accessKey('c')
			);

		assertEquals(WPanel.Type.BOX, panel.getType());
		assertEquals(WPanel.PanelMode.LAZY, panel.getMode());
		assertEquals('c', panel.getAccessKey());
	}
}
