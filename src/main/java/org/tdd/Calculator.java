package org.tdd;

public class Calculator {

    public int Add(String numbers) {

        int sum = -1;
        if (numbers != null) {
            if (numbers.isEmpty())
            {
                sum = 0;
            }
            else if (numbers.contains(",")) {
                String[] splitNums = numbers.split(",");
                sum = GetSum(splitNums);
            }
            else {
                sum = Integer.parseInt(numbers);
            }
        }

        return sum;
    }

    public static int GetSum(String[] numbers) {
        int sum = 0;

        for(String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
