package com.github.johnmcguinness.wcomponents.ui.property;

import com.github.bordertech.wcomponents.Size;
import com.github.bordertech.wcomponents.layout.FlowLayout;
import com.github.bordertech.wcomponents.layout.LayoutManager;
import com.github.johnmcguinness.wcomponents.ui.HAlign;
import com.github.johnmcguinness.wcomponents.ui.VAlign;
import com.github.johnmcguinness.wcomponents.ui.component.Panel;

/**
 *
 * @author John McGuinness
 */
public final class LayoutProperty implements Property<LayoutManager>, Panel.PropertySetter {

	private final LayoutManager value;
	
	public static LayoutProperty flowLayout(final HAlign align) {
		return new LayoutProperty(new FlowLayout(align.toFlowLayoutAlignment()));
	}
	
	public static LayoutProperty flowLayout(final HAlign align, final Size space) {
		return new LayoutProperty(new FlowLayout(align.toFlowLayoutAlignment(), space));
	}
	
	public static LayoutProperty flowLayout(final HAlign halign, final VAlign valign, final Size space) {
		return new LayoutProperty(new FlowLayout(halign.toFlowLayoutAlignment(), space, valign.toFlowLayoutContentAlignment()));
	}
	
	public static LayoutProperty verticalLayout(final Size space) {
		return new LayoutProperty(new FlowLayout(FlowLayout.Alignment.VERTICAL, space));
	}
	
	private LayoutProperty(final LayoutManager value) {
		this.value = value;
	}

	@Override
	public LayoutManager value() {
		return this.value;
	}

	@Override
	public void apply(final Panel panel) {
		panel.setLayout(value());
	}
}
