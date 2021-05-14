package org.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String customDelimiterRegex = "//(.)\n(.*)";

    public int Add(String numbers) {

        int sum = -1;
        if (numbers != null) {
            if (numbers.isEmpty())
            {
                sum = 0;
            }
            else {
                List<String> splitNums = GetSeparatedNumbers(numbers);
                sum = GetSum(splitNums);
            }
        }

        return sum;
    }

    public static int GetSum(List<String> numbers) {
        int sum = 0;

        for(String number : numbers) {
            if (!number.isEmpty())
                sum += Integer.parseInt(number);
        }

        return sum;
    }

    public static List<String> GetSeparatedNumbers(String numbers) {
        List<String> splittedNums;

        if(numbers.startsWith("//")) {
            splittedNums = Arrays.asList(SplitWithCustomDelimiter(numbers));
        } else {
            splittedNums = Arrays.asList(SplitWithDefinedDelimiter(numbers));
        }

        return splittedNums;
    }

    private static String[] SplitWithCustomDelimiter(String numbers) {
        Matcher matcher = Pattern.compile(customDelimiterRegex).matcher(numbers);
        matcher.matches();

        String delimiter = matcher.group(1);
        String values = matcher.group(2);

        return values.split(delimiter);
    }

    private static String[] SplitWithDefinedDelimiter(String numbers) {

        return numbers.split(",|\n");
    }
}
