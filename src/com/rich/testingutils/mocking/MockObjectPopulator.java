package com.rich.testingutils.mocking;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * User: rich
 * Date: 23/12/2011
 * Time: 18:40
 */
public class MockObjectPopulator {

    private DefaultValues defaultValues = new DefaultValues();

    public void populateMockObject(Object obj) {
        populateMockObjectWithCustomValues(obj);

    }

    public void populateMockObjectWithCustomValues(Object obj, Map<String, Object> fieldMap) {
        for (Method f : obj.getClass().getDeclaredMethods()) {
            if (f.getName().startsWith("set")) {
                Class type = f.getParameterTypes()[0];
                Object defaultValue;
                //get field name from mutator and lookup in map
                try {
                    defaultValue = getDefaultValueByType(type);
                if (defaultValue != null) {
                    f.invoke(obj, defaultValue);
                }
                } catch (Exception e) {
                    e.printStackTrace();
                    fail();
                }
            }
        }
    }

    private Object getDefaultValueByType(Class aClass) throws NoSuchMethodException {

        String typeName = aClass.getName();
        Map<String, Object> defaultValuesMap = defaultValues.getDefaultValuesMap();
        Object object = defaultValuesMap.get(typeName);
        return object;
    }

}
