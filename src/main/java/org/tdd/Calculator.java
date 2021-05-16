package org.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

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

        splittedNums = Arrays.asList(SplitByDelimiter(numbers));

        return splittedNums;
    }

    private static String[] SplitByDelimiter(String numbers) {
        String pattern = GetPattern(numbers);

        numbers = numbers.substring(numbers.indexOf("\n") + 1);
        String compiledPattern = Pattern.compile("\\|")
                                        .splitAsStream(pattern)
                                        .map(Pattern::quote)
                                        .collect(Collectors.joining("|"));

        return numbers.split(compiledPattern);
    }

    private static String GetPattern(String numbers) {

        String pattern = ",|\n";

        if (numbers.charAt(2) == '[') {
            while (numbers != "") {
                if (numbers.startsWith("\n")) {
                    numbers = "";
                }
                 else {
                    String delimiter = numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']'));
                    pattern += "|" + delimiter;
                    numbers = numbers.substring(numbers.indexOf(']') + 1);
                }
            }
        }

        return pattern;
    }
}
