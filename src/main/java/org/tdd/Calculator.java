package org.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    private static final String customDelimiterRegex = "//(.*)\n(.*)";
    private static final int maxValue = 1000;

    public int Add(String numbers) {

        int sum = -1;
        if (numbers != null) {
            if (numbers.isEmpty())
            {
                sum = 0;
            }
            else {
                List<String> splitNums = GetSeparatedNumbers(numbers);
                List<Integer> values = Convert(splitNums);
                List<Integer> negValues = Filter(values);

                if (negValues.size() > 0) {
                    String numberString = negValues.stream().map(String::valueOf)
                                          .collect(Collectors.joining(", "));

                    throw new RuntimeException("negatives not allowed - " + numberString);
                }
                sum = GetSum(values);
            }
        }

        return sum;
    }

    public static int GetSum(List<Integer> numbers) {
        int total = 0;

        for (Integer value : numbers)
            if (value < maxValue)
                total += value;

        return total;
    }

    public static List<Integer> Filter(List<Integer> numbers) {
        List<Integer> negativeValues = new ArrayList<Integer>();

        for (Integer value : numbers) {
            if(value < 0)
                negativeValues.add(value);
        }

        return negativeValues;
    }

    private static List<Integer> Convert(List<String> numbers) {
        List<Integer> values = new ArrayList<Integer>();

        for(String number : numbers) {
            if (!number.isEmpty())
                values.add(Integer.parseInt(number));
        }

        return values;
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

        return values.split(Pattern.quote(delimiter));
    }

    private static String[] SplitWithDefinedDelimiter(String numbers) {

        return numbers.split(",|\n");
    }
}
