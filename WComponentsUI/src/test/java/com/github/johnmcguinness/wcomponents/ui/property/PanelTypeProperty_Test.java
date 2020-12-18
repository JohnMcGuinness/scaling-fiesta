package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WPanel;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import static com.github.johnmcguinness.wcomponents.ui.component.Panel.panel;
import static com.github.johnmcguinness.wcomponents.ui.property.PanelTypeProperty.panelType;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author John McGuinness
 */
public class PanelTypeProperty_Test {

	@Test
	public void testPanelTypeConversion() {
		assertEquals(WPanel.Type.BOX, Panel.Type.BOX.type());
		assertEquals(WPanel.Type.FEATURE, Panel.Type.FEATURE.type());
		assertEquals(WPanel.Type.FOOTER, Panel.Type.FOOTER.type());
		assertEquals(WPanel.Type.HEADER, Panel.Type.HEADER.type());
		assertEquals(WPanel.Type.PLAIN, Panel.Type.PLAIN.type());
	}
	
	@Test
	public void testCreatePanelType() {
		assertEquals(Panel.Type.BOX, panelType(Panel.Type.BOX).value());
		assertEquals(Panel.Type.FEATURE, panelType(Panel.Type.FEATURE).value());
		assertEquals(Panel.Type.FOOTER, panelType(Panel.Type.FOOTER).value());
		assertEquals(Panel.Type.HEADER, panelType(Panel.Type.HEADER).value());
		assertEquals(Panel.Type.PLAIN, panelType(Panel.Type.PLAIN).value());
	}
	
	@Test
	public void testApplyPanelType() {
		
		WPanel panel = panel();
		
		assertEquals(WPanel.Type.PLAIN, panel.getType());

		panelType(Panel.Type.FEATURE).apply((Panel) panel);
		assertEquals(WPanel.Type.FEATURE, panel.getType());
	}
	
	@Test
	public void testEquals() {

		final PanelTypeProperty box1 = panelType(Panel.Type.BOX);
		final PanelTypeProperty box2 = panelType(Panel.Type.BOX);
		final PanelTypeProperty feature = panelType(Panel.Type.FEATURE);
		
		assertEquals(box1, box2);
		assertNotEquals(box1, feature);
		assertNotEquals(box2, feature);
		assertEquals(feature, feature);
	}	
}
