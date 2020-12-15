package com.github.johnmcguinness.wcomponents.ui.component;

import com.github.bordertech.wcomponents.WFieldSet;
import com.github.johnmcguinness.wcomponents.ui.Lazy;
import java.util.stream.Stream;

/**
 *
 * @author John McGuinness
 */
public final class FieldSet extends WFieldSet {
	
	private static final String MANDATORY_ATTRIBUTE = "FieldSet.mandatory";

	private static final String VISIBLE_ATTRIBUTE = "FieldSet.visible";
	
	private static final String HIDDEN_ATTRIBUTE = "FieldSet.hidden";

        /**
	 * Describes how the field set's frame is rendered.
	 */
	public enum FrameType {
		/**
		 * The field set frame will be rendered with a lined border and the title.
		 */
		NORMAL(WFieldSet.FrameType.NORMAL),
		/**
		 * The field set frame will be rendered with the title only.
		 */
		NO_BORDER(WFieldSet.FrameType.NO_BORDER),
		/**
		 * The field set frame will be rendered with a lined border only.
		 */
		NO_TEXT(WFieldSet.FrameType.NO_TEXT),
		/**
		 * The field set frame will not be rendered.
		 */
		NONE(WFieldSet.FrameType.NONE);
		
		private final WFieldSet.FrameType value;
		
		FrameType(final WFieldSet.FrameType value) {
			this.value = value;
		}
		
		public WFieldSet.FrameType convert() {
			return this.value;
		}
	}

	/**
	 * Creates a FieldSet and applies all of the provided properties.
	 *
	 * @param props the properties to be applied to this FieldSet.
	 * @return a FieldSet with properties applied.
	 */
	public static FieldSet fieldset(final FieldSet.PropertySetter... props) {

		final FieldSet fieldset = new FieldSet();

		Stream.of(props).forEach(prop -> prop.apply(fieldset));

		return fieldset;
	}

	private FieldSet() {
		super((String) null);
	}

	public void setMandatory(final Lazy<Boolean> visible) {
		setAttribute(MANDATORY_ATTRIBUTE, visible);
	}

	@Override
	public boolean isMandatory() {
		final Lazy<Boolean> isMandatory = (Lazy<Boolean>) getAttribute(MANDATORY_ATTRIBUTE);
		return isMandatory == null ? super.isMandatory() : Boolean.TRUE.equals(isMandatory.get());
	}	


	@Override
	public void setVisible(final boolean visible) {
		setVisible(() -> visible);
	}

	public void setVisible(final Lazy<Boolean> visible) {
		setAttribute(VISIBLE_ATTRIBUTE, visible);
	}
	
	@Override
	public boolean isVisible() {
		final Lazy<Boolean> isVisible = (Lazy<Boolean>) getAttribute(VISIBLE_ATTRIBUTE);
		return isVisible == null ? super.isVisible() : Boolean.TRUE.equals(isVisible.get());
	}

	@Override
	public void setHidden(final boolean hidden) {
		setHidden(() -> hidden);
	}

	public void setHidden(final Lazy<Boolean> hidden) {
		setAttribute(HIDDEN_ATTRIBUTE, hidden);
	}
	
	@Override
	public boolean isHidden() {
		final Lazy<Boolean> isHidden = (Lazy<Boolean>) getAttribute(HIDDEN_ATTRIBUTE);
		return isHidden == null ? super.isVisible() : Boolean.TRUE.equals(isHidden.get());
	}
        
	/**
	 * Sets a property for a {@link FieldSet}.
	 *
	 * @author John McGuinness
	 */
	public interface PropertySetter {

		/**
		 * Applies this property to a {@link FieldSet}.
		 *
		 * @param fieldset the field set to apply the property to.
		 */
		void apply(FieldSet fieldset);
	}
}
