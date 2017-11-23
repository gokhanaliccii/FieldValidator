package com.gokhanaliccii.fieldvalidator;

import com.gokhanaliccii.fieldvalidator.validator.annotation.ValidatePassword;
import com.gokhanaliccii.fieldvalidator.validator.core.adapter.RuleAdapter;
import com.gokhanaliccii.fieldvalidator.validator.core.model.BaseRule;
import com.gokhanaliccii.fieldvalidator.validator.core.model.PasswordRule;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

/**
 * Created by gokhan on 23/11/17.
 */

public class PasswordAnnotationTest {

    @Test
    public void should_CreateSingleFromModel() {

        Model testModel = new Model("abc12");

        List<BaseRule> rules = new RuleAdapter(testModel).convert();
        Assert.assertTrue(rules.size() == 1);
    }

    @Test
    public void should_AccessToFieldOfModelCorrectly() {
        final String expectedInput = "abc12";
        Model testModel = new Model(expectedInput);

        List<BaseRule> rules = new RuleAdapter(testModel).convert();
        PasswordRule passwordRule = (PasswordRule) rules.get(0);

        String actualInput = passwordRule.getInput();

        Assert.assertEquals(expectedInput,actualInput);
    }

    public static class Model {

        @ValidatePassword(minNumberCount = 1)
        public String password;

        public Model(String password) {
            this.password = password;
        }
    }

}
