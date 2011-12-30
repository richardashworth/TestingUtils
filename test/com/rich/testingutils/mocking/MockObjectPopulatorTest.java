package com.rich.testingutils.mocking;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;

public class MockObjectPopulatorTest {

    private  MockObjectPopulator populator = new MockObjectPopulator();

    @Test
    public void testPopulateMockObject() throws Exception {
        Footballer footballer = new Footballer();
        populator.populateMockObject(footballer);
        for(Field field : footballer.getClass().getDeclaredFields()){
            field.setAccessible(true);
            assertNotNull(field.get(footballer));
        }
    }

}

