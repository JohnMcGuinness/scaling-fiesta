package com.github.johnmcguinness.wcomponents.ui;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 *
 * @author John McGuinness
 * @param <T> the type of the value returned.
 * 
 */
@FunctionalInterface
public interface Lazy<T extends Serializable> extends Supplier<T>, Serializable { }
