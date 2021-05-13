package org.tdd;

public class Calculator {

    public int Add(String numbers) {

        int sum = -1;
        if (numbers.isEmpty()) {
            sum = 0;
        }
        else if (numbers.contains(",")) {
            int separatorIndex = numbers.indexOf(",");
            String num1 = numbers.substring(0, separatorIndex);
            sum = Integer.parseInt(num1) +
                    Integer.parseInt(String.valueOf(numbers.charAt(separatorIndex + 1)));
        }
        else {
            sum = Integer.parseInt(numbers);
        }

        return sum;
    }
}
