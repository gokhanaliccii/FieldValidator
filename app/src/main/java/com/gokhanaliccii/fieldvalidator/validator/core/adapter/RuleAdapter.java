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

    private Class clazz;

    public RuleAdapter(Class clazz) {
        this.clazz = clazz;
    }

    private List<BaseRule> convert() {
        if (clazz == null) {
            return emptyList();
        }

        Field[] fields = clazz.getFields();
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
            createPasswordRule(field);
        }


    }

    private BaseRule createPasswordRule(Field field) {
        Annotation annotation = field.getAnnotation(ValidatePassword.class);

        ValidatePassword passwordAnnotation = (ValidatePassword) annotation;

        try {
            Object o = field.get(clazz);
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