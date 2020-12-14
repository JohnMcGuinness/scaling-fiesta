package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WText;

/**
 *
 * @author John McGuinness
 */
public final class Text {
	
	public static WText text(final String value) {
		return new WText(value);
	} 
	
	public static Button.PropertySetter buttonText(final String value) {
		return (button) -> button.setText(value);
	}
	
	public static TextInput.PropertySetter textInputText(final String value) {
		return (textInput) -> textInput.setText(value);
	}

	public static TextInput.PropertySetter altText(final String value) { // Video and Audio
		return (textInput) -> textInput.setText(value);
	}
	
	private Text() { }
}
