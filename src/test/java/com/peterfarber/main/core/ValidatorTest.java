package com.peterfarber.main.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void withinMinMax() {
        int min = 5, max = 10;
        String testString = "1";
        assertFalse(Validator.withinMinMax(min,max,testString));
        testString = "5";
        assertTrue(Validator.withinMinMax(min,max,testString));
        testString = "10";
        assertTrue(Validator.withinMinMax(min,max,testString));
        testString = "11";
        assertFalse(Validator.withinMinMax(min,max,testString));
    }

    @Test
    public void noCharacter() {

        String testString = "123456789";
        assertTrue(Validator.noCharacter(testString));
        testString = "abcdefghi";
        assertFalse(Validator.noCharacter(testString));
        testString = "1234ABCD";
        assertFalse(Validator.noCharacter(testString));

    }

    @Test
    public void notNull() {
        String testString = null;
        assertFalse(Validator.notNull(testString));
        testString = "";
        assertFalse(Validator.notNull(testString));
        testString = "abc";
        assertTrue(Validator.notNull(testString));
    }

    @Test
    public void singleLength() {

        String testString = "1";
        assertTrue(Validator.singleLength(testString));
        testString = "";
        assertFalse(Validator.singleLength(testString));
        testString = "abc";
        assertFalse(Validator.singleLength(testString));

    }
}