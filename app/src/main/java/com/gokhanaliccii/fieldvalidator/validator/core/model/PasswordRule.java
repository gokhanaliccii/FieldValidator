package com.gokhanaliccii.fieldvalidator.validator.core.model;

/**
 * Created by gokhan on 17/11/17.
 */

public class PasswordRule extends BaseRule {

    private String input;
    private String pattern;
    private int minCapitalCaseLetterCount;

    public PasswordRule(String input, String pattern, int minCapitalCaseLetterCout) {
        this.input = input;
        this.pattern = pattern;
        this.minCapitalCaseLetterCount = minCapitalCaseLetterCout;
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

}