package com.richashworth.testingutils.mocking;

import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.fail;

public class MockObjectPopulator {

    private DefaultValues defaultValues = new DefaultValues();

    public void populateMockObject(Object obj) {
        populateMockObjectWithCustomValues(obj, null);

    }

    public void populateMockObjectWithCustomValues(Object obj, Map<String, Object> fieldMap) {
        try {
            for (Method f : obj.getClass().getDeclaredMethods()) {
                String methodName = f.getName();
                if (methodName.startsWith("set")) {
                    Class type = f.getParameterTypes()[0];
                    Object value;
                    String fieldName = methodName.replace("set", "");
                    fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);

                    if (fieldMap.containsKey(fieldName)) {
                        value = fieldMap.get(fieldName);
                    } else {
                        value = getDefaultValueByType(type);
                    }

                    if (value != null) {
                        f.invoke(obj, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


    private Object getDefaultValueByType(Class aClass) throws NoSuchMethodException {

        String typeName = aClass.getName();
        Map<String, Object> defaultValuesMap = defaultValues.getDefaultValuesMap();
        Object object = defaultValuesMap.get(typeName);
        return object;
    }

}
