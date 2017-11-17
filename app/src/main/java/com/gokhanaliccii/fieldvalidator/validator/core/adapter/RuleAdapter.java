package com.gokhanaliccii.fieldvalidator.validator.core.adapter;

import com.gokhanaliccii.fieldvalidator.validator.core.model.BaseRule;

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
            return Collections.emptyList();
        }

        return null;
    }

}
