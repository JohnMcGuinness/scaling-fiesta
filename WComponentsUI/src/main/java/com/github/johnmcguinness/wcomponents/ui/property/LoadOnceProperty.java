package com.github.johnmcguinness.wcomponents.ui.property;

/**
 *
 * @author JOhn McGuinness
 */
public final class LoadOnceProperty
    extends BooleanProperty {

    public static LoadOnceProperty loadOnce() {
            return loadOnce(true);
    }

    public static LoadOnceProperty loadOnce(final boolean value) {
            return new LoadOnceProperty(value);
    }

    private LoadOnceProperty(final Boolean value) {
            super(value);
    }
}
