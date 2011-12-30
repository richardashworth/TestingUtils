package com.rich.testingutils.mocking;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class FootballerTest {

    private MockObjectPopulator mockObjectPopulator = new MockObjectPopulator();

    @Test
    public void testGetGameGoalsRatioNaive() {
        Footballer footballer = new Footballer();
        Map<String, Object> customValuesMap = new HashMap<String, Object>();
        customValuesMap.put("gamesPlayed", 14);
        customValuesMap.put("goalsScored", 7);
        mockObjectPopulator.populateMockObjectWithCustomValues(footballer, customValuesMap);
        assertEquals(Double.valueOf(0.5), footballer.getAvgGoalsPerGame());
    }

}
