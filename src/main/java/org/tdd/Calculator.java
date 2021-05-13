package org.tdd;

public class Calculator {

    public int Add(String numbers) {

        int sum = -1;
        if (numbers.isEmpty()) {
            sum = 0;
        }
        else {
            sum = Integer.parseInt(numbers);
        }

        return sum;
    }
}
