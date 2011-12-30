package com.rich.testingutils.mocking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FootballerNaiveTest {

    @Test
    public void testGetGameGoalsRatioNaive() {
        Footballer footballer = new Footballer();
        footballer.setGamesPlayed(14);
        footballer.setGoalsScored(7);
        assertEquals(Double.valueOf(0.5), footballer.getAvgGoalsPerGame());
    }

}
