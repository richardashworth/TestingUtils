package com.richashworth.testingutils.mocking;

import java.util.HashMap;
import java.util.Map;

public class DefaultValues {

    private Map<String, Object> defaultValuesMap;

    public DefaultValues() {
        this.defaultValuesMap = new HashMap<String, Object>();
        initMapWithPresets();
    }

    public DefaultValues(Map<String, Object> defaultValuesMap) {
        this.defaultValuesMap = defaultValuesMap;
        initMapWithPresets();
    }

    private void initMapWithPresets() {
        if (defaultValuesMap == null) {
            defaultValuesMap = new HashMap<String, Object>();
        }
        for(PresetDefaultValue pdv : PresetDefaultValue.values()){
            defaultValuesMap.put(pdv.typeName, pdv.defaultValue);
        }
    }

    public Map<String, Object> getDefaultValuesMap() {
        return defaultValuesMap;
    }

    public void setDefaultValuesMap(Map<String, Object> defaultValuesMap) {
        this.defaultValuesMap = defaultValuesMap;
    }

    private enum PresetDefaultValue {
        DOUBLE(Double.class.getName(), 0.0),
        STRING(String.class.getName(), ""),
        FLOAT(Float.class.getName(), Float.MIN_VALUE),
        LONG(Long.class.getName(), Long.MIN_VALUE),
        SHORT(Short.class.getName(), Short.MIN_VALUE),
        INTEGER(Integer.class.getName(), 0),
        BOOLEAN(Boolean.class.getName(), false),
        BYTE(Byte.class.getName(), Byte.MIN_VALUE),
        CHARACTER(Character.class.getName(), ' ');
        
        private String typeName;
        private Object defaultValue;

        private PresetDefaultValue(String typeName, Object defaultValue) {
            this.typeName = typeName;
            this.defaultValue = defaultValue;
        }
    }

}
