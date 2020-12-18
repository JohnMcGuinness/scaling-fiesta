package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author John McGuinness
 */
public final class EnableFaceDetectionProperty extends BooleanProperty {

	public static EnableFaceDetectionProperty enableFaceDetection() {
		return enableFaceDetection(true);
	}

	public static EnableFaceDetectionProperty enableFaceDetection(final boolean value) {
		return new EnableFaceDetectionProperty(value);
	}

	private EnableFaceDetectionProperty(final Boolean value) {
		super(value);
	}
}
