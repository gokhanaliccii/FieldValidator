package com.gokhanaliccii.fieldvalidator.validator.core;

/**
 * Created by gokhan on 17/11/17.
 */

public interface Validatable<T> {

    boolean isValid(T t);
}