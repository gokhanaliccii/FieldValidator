package com.gokhanaliccii.fieldvalidator.validator.core.model;

import com.gokhanaliccii.fieldvalidator.validator.annotation.ValidatePassword;
import com.gokhanaliccii.fieldvalidator.validator.core.matcher.Matcher;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gokhan on 17/11/17.
 */

public class PasswordRule extends BaseRule {

    private String input;
    private String pattern;
    private int minCapitalCaseLetterCount;
    private int minNumberCount;

    public PasswordRule(String input, String pattern,
                        int minCapitalCaseLetterCount,
                        int minNumberCount) {
        this.input = input;
        this.pattern = pattern;
        this.minCapitalCaseLetterCount = minCapitalCaseLetterCount;
        this.minNumberCount = minNumberCount;
    }

    public PasswordRule(String input, ValidatePassword validatePassword) {
        this.input = input;
        this.pattern = validatePassword.pattern();
        this.minCapitalCaseLetterCount = validatePassword.minUpperCaseCharCount();
        this.minNumberCount = validatePassword.minNumberCount();
    }

    public String getInput() {
        return input;
    }

    public String getPattern() {
        return pattern;
    }

    public int getMinCapitalCaseLetterCount() {
        return minCapitalCaseLetterCount;
    }

    public int getMinNumberCount() {
        return minNumberCount;
    }

    public List<Matcher> toMatcher() {
        List<Matcher> matchers = new LinkedList<>();


    }
}