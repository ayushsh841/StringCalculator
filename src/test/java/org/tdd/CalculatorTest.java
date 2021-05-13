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

    //Given: I provide string as 1
    //When: I call the Add method
    //Then: I get the sum as 1
    @Test
    public void Add_GivenStringAs_1_ReturnsSumAs_1()
    {
        String input = "1";
        int expectedSum = 1;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 1,2
    //When: I call the Add method
    //Then: I get the sum as 3
    @Test
    public void Add_GivenStringAs_1_2_ReturnsSumAs_3()
    {
        String input = "1,2";
        int expectedSum = 3;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 11,1
    //When: I call the Add method
    //Then: I get the sum as 13
    @Test
    public void Add_GivenStringAs_11_1_ReturnsSumAs_13()
    {
        String input = "11,1";
        int expectedSum = 13;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }
}
