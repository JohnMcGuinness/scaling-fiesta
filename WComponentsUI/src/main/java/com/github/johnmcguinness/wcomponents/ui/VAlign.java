package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.layout.FlowLayout;

/**
 * The vertical alignment of a component's contents.
 * 
 * @author John McGuinness
 */
public enum VAlign {
	/**
	 * The item should align to the top.
	 */
	TOP,
	/**
	 * The item should align to the middle.
	 */
	MIDDLE,
	/**
	 * The item should align to the baseline.
	 */
	BASELINE,
	/**
	 * The item should align to the bottom.
	 */
	BOTTOM;
	
	/**
	 * Converts this {@link VAlign} to a {@link FlowLayout.ContentAlignment}.
	 * 
	 * @return the equivalent {@link FlowLayout.ContentAlignment}.
	 */
	public FlowLayout.ContentAlignment toFlowLayoutContentAlignment() {
		switch (this) {
			case TOP: return FlowLayout.ContentAlignment.TOP;
			case MIDDLE: return FlowLayout.ContentAlignment.MIDDLE;
			case BASELINE: return FlowLayout.ContentAlignment.BASELINE;
			case BOTTOM: return FlowLayout.ContentAlignment.BOTTOM;
			default: return FlowLayout.ContentAlignment.MIDDLE;
		}
	}	
}
