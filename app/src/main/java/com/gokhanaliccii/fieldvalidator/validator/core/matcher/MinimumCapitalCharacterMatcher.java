package com.gokhanaliccii.fieldvalidator.validator.core.matcher;

/**
 * Created by gokhan on 23/11/17.
 */

public class MinimumCapitalCharacterMatcher implements Matcher<String> {

    private int minCapitalCharacterCount;

    public MinimumCapitalCharacterMatcher(int minCharacterCount) {
        this.minCapitalCharacterCount = minCharacterCount;
    }

    @Override
    public boolean matches(String s) {
        if (isEmpty(s))
            return false;

        int numericCounter = 0;

        char[] chars = s.toCharArray();
        for (char currentChar : chars) {
            if (Character.isUpperCase(currentChar)) {
                numericCounter++;
            }
        }

        return numericCounter >= minCapitalCharacterCount;
    }

    private boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }


}
