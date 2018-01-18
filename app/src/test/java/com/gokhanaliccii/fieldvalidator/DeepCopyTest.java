package com.gokhanaliccii.fieldvalidator;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by gokhan on 18/01/18.
 */

public class DeepCopyTest {
    @Test
    public void whenObjectClonedShouldKeepVariableValues() throws CloneNotSupportedException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        ClonableUser user = new ClonableUser("gokhan", new ClonableUser("gok"));
        ClonableUser clonedUser = deepCopy(user);

        assertThat(clonedUser.getName(), equalTo(user.getName()));
    }

    @Test
    public void whenClonedObjectShouldNotEffectedByParentObjectChanges() throws CloneNotSupportedException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {
        ClonableUser user = new ClonableUser();
        user.setName("name");
        ClonableUser clonedUser = deepCopy(user);
        user.setName("gokhan2");

        assertThat(clonedUser.getName(), not(equalTo(user.getName())));
    }

    private static class ClonableUser implements Cloneable{

        private ClonableUser user;
        private String mName;
        private int mAge;

        public ClonableUser() {
        }

        public ClonableUser(String mName, ClonableUser user) {
            this.mName = mName;
            this.user = user;
        }

        public ClonableUser(String mName) {
            this.mName = mName;
        }

        public ClonableUser(int mAge) {
            this.mAge = mAge;
        }

        public void setName(String mName) {
            this.mName = mName;
        }

        public String getName() {
            return mName;
        }

        public int getAge() {
            return mAge;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    private <T> T deepCopy(T a) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        if (a == null) {
            return null;
        }

        Class willCopyClass = a.getClass();
        if (shouldNotClone(willCopyClass)) {
            return a;
        }

        try {
            Method clone = findAccessibleCloneMethod(a);
            T cloned = (T) clone.invoke(a);

            Field[] fields = willCopyClass.getDeclaredFields();
            for (Field field : fields) {
                enableField(field);

                Field targetField = cloned.getClass().getDeclaredField(field.getName());
                if (targetField == null)
                    continue;

                enableField(targetField);

                Object value = targetField.get(cloned);
                if (value == null)
                    continue;

                if (field.getType().isPrimitive()) {
                    putValue(a, targetField, value);
                    continue;
                }

                targetField.set(a, deepCopy(value));
            }

            return cloned;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();

            return a;
        }
    }

    private void enableField(Field field) {
        if (!field.isAccessible())
            field.setAccessible(true);
    }

    private <T> void putValue(T targetObject, Field targetField, Object value) throws IllegalAccessException {
        targetField.set(targetObject, value);
    }

    private boolean shouldNotClone(Class<?> willCopyClass) {
        return !Cloneable.class.isAssignableFrom(willCopyClass);
    }

    private <T> Method findAccessibleCloneMethod(T target) throws NoSuchMethodException {
        Method clone = target.getClass().getDeclaredMethod("clone", null);
        clone.setAccessible(true);
        return clone;
    }

}
