package com.rich.testingutils.mocking;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class FootballerTest {

    @Test
    public void testGetGameGoalsRatio() {
        Footballer footballer = new Footballer();
        MockObjectPopulator populator = new MockObjectPopulator();
        populator.populateMockObject(footballer);
        assertEquals(footballer.getGameGoalsRatio(), Double.valueOf(0.0));
    }

    @Test
    public void testGetGameGoalsRatioWithCustomValues() {
        Map<String, Object> customValuesMap = new HashMap<String, Object>();
        customValuesMap.pu

    }
}
