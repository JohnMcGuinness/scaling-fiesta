package com.github.johnmcguinness.wcomponents.ui;

import com.github.bordertech.wcomponents.WColumn;
import com.github.bordertech.wcomponents.WTableColumn;
import com.github.bordertech.wcomponents.layout.FlowLayout;

/**
 * The horizontal alignment of a component's contents.
 * 
 * @author John McGuinness
 */
public enum HAlign {
	/**
	 * Left aligned.
	 */
	LEFT,
	/**
	 * Center aligned.
	 */
	CENTER,
	/**
	 * Right aligned.
	 */
	RIGHT;
	
	/**
	 * Converts this {@link HAlign} to a {@link FlowLayout.Alignment}.
	 * 
	 * @return the equivalent {@link FlowLayout.Alignment}.
	 */
	public FlowLayout.Alignment toFlowLayoutAlignment() {
		switch (this) {
			case LEFT: return FlowLayout.Alignment.LEFT;
			case CENTER: return FlowLayout.Alignment.CENTER;
			case RIGHT: return FlowLayout.Alignment.RIGHT;
			default: return FlowLayout.Alignment.LEFT;
		}
	}

	/**
	 * Converts this {@link HAlign} to a {@link WTableColumn.Alignment}.
	 * 
	 * @return the equivalent {@link WTableColumn.Alignment}.
	 */
	public WTableColumn.Alignment toTableColumnAlignment() {
		switch (this) {
			case LEFT: return WTableColumn.Alignment.LEFT;
			case CENTER: return WTableColumn.Alignment.CENTER;
			case RIGHT: return WTableColumn.Alignment.RIGHT;
			default: return WTableColumn.Alignment.LEFT;
		}
	}

	/**
	 * Converts this {@link HAlign} to a {@link WColumn.Alignment}.
	 * 
	 * @return the equivalent {@link WColumn.Alignment}.
	 */
	public WColumn.Alignment toColumnAlignment() {
		switch (this) {
			case LEFT: return WColumn.Alignment.LEFT;
			case CENTER: return WColumn.Alignment.CENTER;
			case RIGHT: return WColumn.Alignment.RIGHT;
			default: return WColumn.Alignment.LEFT;
		}
	}
}
