package com.company;

public class Task9 {
    public static void main(final String[] args) {
        try {
            final Calculator calculator = new Calculator();
            final CustomDouble task1 = new CustomDouble(-2, 0.8);
            final CustomDouble task2 = new CustomDouble(4, 0.5);

            System.out.println(calculator.operations(task1,'+',task2));
            System.out.println(calculator.operations(task1,'-',task2));
            System.out.println(calculator.operations(task1, '*',task2));
            System.out.println(calculator.operations(task1, '/',task2));

        }
        catch (final ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
