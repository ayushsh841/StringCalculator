package org.tdd;

public class Calculator {

    public int Add(String numbers) {

        int sum = -1;
        if (numbers.isEmpty()) {
            sum = 0;
        }
        else if (numbers.contains(",")) {
            sum = Integer.parseInt(String.valueOf(numbers.charAt(0)))
                    + Integer.parseInt(String.valueOf(numbers.charAt(2)));
        }
        else {
            sum = Integer.parseInt(numbers);
        }

        return sum;
    }
}
