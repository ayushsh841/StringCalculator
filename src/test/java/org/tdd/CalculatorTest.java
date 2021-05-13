package org.tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void SetUp() {
        calculator = new Calculator();
    }

    //Given: I provide an empty string
    //When: I call the Add method
    //Then: I get the sum as 0
    @Test
    public void Add_GivenEmptyString_ReturnsSumAs_0()
    {
        String input = "";
        int expectedSum = 0;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }
}
