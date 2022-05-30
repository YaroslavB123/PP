package com.company;

public class Calculator {
    public double operations(final CustomDouble a, final char symbol, final CustomDouble b) {
        switch (symbol) {
            case '+':
                return a.add(b).toDouble();
            case '-':
                return a.subtraction(b).toDouble();
            case '*':
                return a.multiplication(b).toDouble();
            case '/':
                return a.divide(b).toDouble();
            default:
                throw new RuntimeException("Такої дії не існує!!!");
        }
    }
}
