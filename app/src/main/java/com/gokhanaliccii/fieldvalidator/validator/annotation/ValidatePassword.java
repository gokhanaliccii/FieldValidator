package com.gokhanaliccii.fieldvalidator.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by gokhan on 17/11/17.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePassword {

    String pattern();

    int minNumberCount();

    int minUpperCaseCharCount();
}
