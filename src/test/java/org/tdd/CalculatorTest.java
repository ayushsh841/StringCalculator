package org.tdd;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void SetUp() {
        calculator = new Calculator();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

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

    //Given: I provide string as null
    //When: I call the Add method
    //Then: I get the sum as -1
    @Test
    public void Add_GivenStringAs_Null_ReturnsSumAs_Neg1()
    {
        String input = null;
        int expectedSum = -1;

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
    //Then: I get the sum as 12
    @Test
    public void Add_GivenStringAs_11_1_ReturnsSumAs_12()
    {
        String input = "11,1";
        int expectedSum = 12;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 11,11
    //When: I call the Add method
    //Then: I get the sum as 22
    @Test
    public void Add_GivenStringAs_11_11_ReturnsSumAs_22()
    {
        String input = "11,11";
        int expectedSum = 22;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 123,456
    //When: I call the Add method
    //Then: I get the sum as 579
    @Test
    public void Add_GivenStringAs_123_456_ReturnsSumAs_579()
    {
        String input = "123,456";
        int expectedSum = 579;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as -1,-1
    //When: I call the Add method
    //Then: I get exception with listed negative numbers
    @Test
    public void Add_GivenStringAs_Neg_1_1_ThrowsException()
    {
        String input = "-1,-1";

        exception.expect(RuntimeException.class);
        exception.expectMessage("negatives not allowed - -1, -1");

        calculator.Add(input);
    }

    //Given: I provide string as 0,0
    //When: I call the Add method
    //Then: I get the sum as 0
    @Test
    public void Add_GivenStringAs_0_0_ReturnsSumAs_0()
    {
        String input = "0,0";
        int expectedSum = 0;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as -123,124
    //When: I call the Add method
    //Then: I get exception with listed negative numbers
    @Test
    public void Add_GivenStringAs_Neg123_Pos124_ThrowsException()
    {
        String input = "-123,124";

        exception.expect(RuntimeException.class);
        exception.expectMessage("negatives not allowed - -123");

        calculator.Add(input);
    }

    //Given: I provide string as 1,2,3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringAs_1_2_3_ReturnsSumAs_6()
    {
        String input = "1,2,3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 1,2,3,4,5
    //When: I call the Add method
    //Then: I get the sum as 15
    @Test
    public void Add_GivenStringAs_1_2_3_4_5_ReturnsSumAs_15()
    {
        String input = "1,2,3,4,5";
        int expectedSum = 15;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 1,\n2,3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringAs_1_2_3_WithNewLine_ReturnsSumAs_6()
    {
        String input = "1,\n2,3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 1\n2,3,4
    //When: I call the Add method
    //Then: I get the sum as 10
    @Test
    public void Add_GivenStringAs_1_2_3_4_WithNewLine_ReturnsSumAs_10()
    {
        String input = "1\n2,3,4";
        int expectedSum = 10;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as //;\n1;2;3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringWithNew_Delimiter_Semi_Colon_ReturnsSumAs_6()
    {
        String input = "//;\n1;2;3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as 1001, 1001
    //When: I call the Add method
    //Then: I get the sum as 0
    @Test
    public void Add_GivenStringAs_1001_1001_ReturnsSumAs_0()
    {
        String input = "1001,1001";
        int expectedSum = 0;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as //****\n1****2****3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringWithDelimiterLengthGreaterThan1_ReturnsSumAs_6()
    {
        String input = "//****\n1****2****3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as //[*][%]\n1*2%3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringWithMultipleDelimiterLengthAs1_ReturnsSumAs_6()
    {
        String input = "//[*][%]\n1*2%3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }

    //Given: I provide string as //[**][%%]\n1**2%%3
    //When: I call the Add method
    //Then: I get the sum as 6
    @Test
    public void Add_GivenStringWithMultipleDelimiterLengthGreaterThan1_ReturnsSumAs_6()
    {
        String input = "//[**][%%]\n1**2%%3";
        int expectedSum = 6;

        int result = calculator.Add(input);

        assertEquals(expectedSum, result);
    }
}
