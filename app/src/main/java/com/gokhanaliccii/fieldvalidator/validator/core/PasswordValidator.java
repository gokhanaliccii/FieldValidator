package com.gokhanaliccii.fieldvalidator.validator.core;

import com.gokhanaliccii.fieldvalidator.validator.core.model.PasswordRule;

/**
 * Created by gokhan on 17/11/17.
 */

public class PasswordValidator implements Validatable<PasswordRule> {

    @Override
    public boolean isValid(PasswordRule passwordRule) {
        return false;
    }
}