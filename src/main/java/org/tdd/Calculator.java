package org.tdd;

import java.util.ArrayList;

public class Calculator {

    public int Add(String numbers) {

        int sum = -1;
        if (numbers != null) {
            if (numbers.isEmpty())
            {
                sum = 0;
            }
            else {
                String[] splitNums = GetSeparatedNumbers(numbers);
                sum = GetSum(splitNums);
            }
        }

        return sum;
    }

    public static int GetSum(String[] numbers) {
        int sum = 0;

        for(String number : numbers) {
            if (!number.isEmpty())
                sum += Integer.parseInt(number);
        }

        return sum;
    }

    public static String[] GetSeparatedNumbers(String numbers) {
        String[] splittedNums = numbers.split(",|\n");

        return splittedNums;
    }
}
