package com.gokhanaliccii.fieldvalidator.validator.core.matcher;

/**
 * Created by gokhan on 23/11/17.
 */

public interface Matcher<T> {
    boolean matches(T t);
}
