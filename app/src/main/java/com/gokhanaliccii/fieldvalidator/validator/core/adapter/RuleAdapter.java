package com.gokhanaliccii.fieldvalidator.validator.core.adapter;

import com.gokhanaliccii.fieldvalidator.validator.annotation.ValidatePassword;
import com.gokhanaliccii.fieldvalidator.validator.core.model.BaseRule;
import com.gokhanaliccii.fieldvalidator.validator.core.model.PasswordRule;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gokhan on 17/11/17.
 */

public class RuleAdapter {

    private Object target;


    public RuleAdapter(Object o) {
        this.target = o;
    }

    public List<BaseRule> convert() {
        if (target == null) {
            return emptyList();
        }

        Field[] fields = target.getClass().getFields();
        if (fields == null)
            return emptyList();

        List<BaseRule> rules = new ArrayList<>();

        for (Field field : fields) {
            parseFieldForRule(rules, field);
        }

        return rules;
    }

    private void parseFieldForRule(List<BaseRule> rules, Field field) {

        if (field.isAnnotationPresent(ValidatePassword.class)) {
            BaseRule passwordRule = createPasswordRule(field);
            if (passwordRule != null) {
                rules.add(passwordRule);
            }
        }


    }

    private BaseRule createPasswordRule(Field field) {
        Annotation annotation = field.getAnnotation(ValidatePassword.class);

        ValidatePassword passwordAnnotation = (ValidatePassword) annotation;

        try {
            Object o = field.get(target);
            String value = (String) o;

            return new PasswordRule(value, passwordAnnotation);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<BaseRule> emptyList() {
        return Collections.emptyList();
    }

}