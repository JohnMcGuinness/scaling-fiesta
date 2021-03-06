package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WPanel;
import com.github.bordertech.wcomponents.WPanel.PanelMode;
import com.github.bordertech.wcomponents.WSection;
import com.github.bordertech.wcomponents.WSection.SectionMode;

/**
 * The AJAX Mode of a component that uses AJAX to load its content.
 *
 * @author John McGuinness
 */
public enum Mode {

	/**
	 * A lazy panel will load its content via AJAX when it is made visible.
	 */
	LAZY(WPanel.PanelMode.LAZY, WSection.SectionMode.LAZY),
	/**
	 * An eager panel will load its content via AJAX immediately after
	 * the page is loaded.
	 */
	EAGER(WPanel.PanelMode.EAGER, WSection.SectionMode.EAGER),
	/**
	 * An panel with no mode does not load its content via AJAX.
	 */
	NONE(null, null);

	private final WPanel.PanelMode panelMode;

	private final WSection.SectionMode sectionMode;

	Mode(final PanelMode panelMode, final SectionMode sectionMode) {
		this.panelMode = panelMode;
		this.sectionMode = sectionMode;
	}

	/**
	 * Converts this {@link Mode} to a {@link WPanel.PanelMode}.
	 *
	 * @return the equivalent {@link WPanel.PanelMode}.
	 */
	public WPanel.PanelMode panelMode() {
		return this.panelMode;
	}

	/**
	 * Converts this {@link Mode} to a {@link WSection.SectionMode}.
	 *
	 * @return the equivalent {@link WSection.SectionMode}.
	 */
	public WSection.SectionMode sectionMode() {
		return this.sectionMode;
	}
};
