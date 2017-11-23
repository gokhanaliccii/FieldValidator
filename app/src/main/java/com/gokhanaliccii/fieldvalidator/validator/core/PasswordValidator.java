package com.gokhanaliccii.fieldvalidator.validator.core;

import com.gokhanaliccii.fieldvalidator.validator.core.matcher.Matcher;
import com.gokhanaliccii.fieldvalidator.validator.core.model.PasswordRule;

import java.util.List;

/**
 * Created by gokhan on 17/11/17.
 */

public class PasswordValidator implements Validatable<PasswordRule> {

    @Override
    public boolean isValid(PasswordRule passwordRule) {
        List<Matcher<String>> matchers = passwordRule.toMatcher();

        boolean isValid = true;
        for (Matcher<String> matcher : matchers) {
            isValid = isValid && matcher.matches(passwordRule.getInput());
        }

        return isValid;
    }
}