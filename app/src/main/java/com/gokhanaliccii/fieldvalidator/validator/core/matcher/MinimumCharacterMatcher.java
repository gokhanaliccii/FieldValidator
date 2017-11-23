package com.gokhanaliccii.fieldvalidator.validator.core.matcher;

/**
 * Created by gokhan on 23/11/17.
 */

public class MinimumCharacterMatcher implements Matcher<String> {

    private int minCharacterCount;

    public MinimumCharacterMatcher(int minCharacterCount) {
        this.minCharacterCount = minCharacterCount;
    }

    @Override
    public boolean matches(String s) {
        int len = s == null ? 0 : s.length();

        return len >= minCharacterCount;
    }
}
