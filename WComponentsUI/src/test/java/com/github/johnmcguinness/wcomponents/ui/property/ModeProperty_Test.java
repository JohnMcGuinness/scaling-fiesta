package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WPanel;
import com.github.bordertech.wcomponents.WSection;
import com.github.johnmcguinness.wcomponents.ui.Mode;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import static com.github.johnmcguinness.wcomponents.ui.component.Panel.panel;
import static com.github.johnmcguinness.wcomponents.ui.property.ModeProperty.mode;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author john
 */
public class ModeProperty_Test {
	
	@Test
	public void testPanelModeConversion() {
		assertEquals(WPanel.PanelMode.LAZY, Mode.LAZY.panelMode());
		assertEquals(WPanel.PanelMode.EAGER, Mode.EAGER.panelMode());
		assertNull(Mode.NONE.panelMode());
	}
	
	@Test
	public void testSectionModeConversion() {
		assertEquals(WSection.SectionMode.LAZY, Mode.LAZY.sectionMode());
		assertEquals(WSection.SectionMode.EAGER, Mode.EAGER.sectionMode());
		assertNull(Mode.NONE.sectionMode());
	}
	
	@Test
	public void testCreatePanelMode() {
		assertEquals(Mode.EAGER, mode(Mode.EAGER).value());
		assertEquals(Mode.LAZY, mode(Mode.LAZY).value());
		assertEquals(Mode.NONE, mode(Mode.NONE).value());
	}
	
	@Test
	public void testApplyPanelMode() {
		
		WPanel panel = panel();
		
		assertNull(panel.getMode());
		mode(Mode.EAGER).apply((Panel) panel);
		assertEquals(WPanel.PanelMode.EAGER, panel.getMode());
		
		mode(Mode.NONE).apply((Panel) panel);
		assertNull(panel.getMode());
	}
	
	@Test
	public void testEquals() {

		final ModeProperty eager1 = mode(Mode.EAGER);
		final ModeProperty eager2 = mode(Mode.EAGER);
		final ModeProperty lazy = mode(Mode.LAZY);
		final ModeProperty none = mode(Mode.NONE);
		
		assertEquals(eager1, eager2);
		assertNotEquals(eager1, lazy);
		assertNotEquals(eager2, lazy);
		assertNotEquals(eager1, none);
		assertNotEquals(eager2, none);
		assertNotEquals(lazy, none);
	}
}
