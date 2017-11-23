package com.gokhanaliccii.fieldvalidator.validator.core.matcher;

/**
 * Created by gokhan on 23/11/17.
 */

public class NumericCharacterMatcher implements Matcher<String> {

    private int minNumericCharacterCount;

    public NumericCharacterMatcher(int minCharacterCount) {
        this.minNumericCharacterCount = minCharacterCount;
    }

    @Override
    public boolean matches(String s) {
        if (isEmpty(s))
            return false;

        int numericCounter = 0;

        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            if (Character.isDigit(currentChar)) {
                numericCounter++;
            }
        }

        return numericCounter >= minNumericCharacterCount;
    }

    private boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }


}
