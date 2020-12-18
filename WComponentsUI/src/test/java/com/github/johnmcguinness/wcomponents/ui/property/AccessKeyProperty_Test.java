package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.WPanel;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import static com.github.johnmcguinness.wcomponents.ui.component.Panel.panel;
import static com.github.johnmcguinness.wcomponents.ui.property.AccessKeyProperty.accessKey;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author john
 */
public class AccessKeyProperty_Test {
	
	private static final char NULL = '\0';
	
	private static final char C_CHAR = 'C';
	
	@Test
	public void testCreateAccessKey() {
		assertEquals(Character.valueOf(NULL), accessKey(NULL).value());
		assertEquals(Character.valueOf(C_CHAR), accessKey(C_CHAR).value());
	}
	
	@Test
	public void testApplyAccessKey() {
		
		WPanel panel = panel();
		
		assertNotNull(panel.getAccessKey());
		accessKey(C_CHAR).apply((Panel) panel);
		assertEquals(C_CHAR, panel.getAccessKey());
	}
	
	@Test
	public void testEquals() {

		final AccessKeyProperty c1 = accessKey(C_CHAR);
		final AccessKeyProperty c2 = accessKey(C_CHAR);
		final AccessKeyProperty nul = accessKey(NULL);
		
		assertEquals(c1, c2);
		assertNotEquals(c1, nul);
		assertNotEquals(c2, nul);
		assertEquals(nul, nul);
	}
}
