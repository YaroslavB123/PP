package com.company;

public class Task3 {
    private char[] symbol;
    private int[] figure;
    private String string;

    public Task3(final char[] symbol, final int[] figure, final String string) {
        this.symbol = symbol;
        this.figure = figure;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void mergeFigureSymbol() {
        for (int i = 0; i < Math.max(figure.length, symbol.length); i++) {
            if (i < figure.length)
                this.string = this.string + figure[i];
            if (i < symbol.length)
                this.string = this.string + symbol[i];
        }
    }

    public static void main(final String[] args) {
        final Task3 task = new Task3(new char[]{'a', 'b', 'c', 'd', 'e'}, new int[]{1, 2, 3}, "");

        task.mergeFigureSymbol();
        System.out.println(task.getString());
    }
}