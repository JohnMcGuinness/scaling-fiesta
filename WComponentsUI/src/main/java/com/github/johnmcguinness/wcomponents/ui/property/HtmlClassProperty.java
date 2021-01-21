package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.johnmcguinness.wcomponents.ui.component.Panel;
import com.github.johnmcguinness.wcomponents.ui.component.ProgressBar;

/**
 *
 * @author John McGuinness
 */
public final class HtmlClassProperty
		extends StringProperty
		implements ProgressBar.PropertySetter, Panel.PropertySetter {

	public static HtmlClassProperty htmlClass(final String value) {
		return new HtmlClassProperty(value);
	}

	private HtmlClassProperty(final String value) {
		super(value);
	}

	@Override
	public void apply(final ProgressBar progressBar) {
		progressBar.setHtmlClass(value());
	}

	@Override
	public void apply(final Panel panel) {
		panel.setHtmlClass(value());
	}
}
