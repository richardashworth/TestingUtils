package com.rich.testingutils.mocking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FootballerTest {

    @Test
    public void testGetGameGoalsRatio() {
        Footballer footballer = new Footballer();
        MockObjectPopulator populator = new MockObjectPopulator();
        populator.populateMockObject(footballer);
        assertEquals(footballer.getGameGoalsRatio(), Double.valueOf(0.0));
    }

}
