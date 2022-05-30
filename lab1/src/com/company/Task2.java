package com.company;

public class Task2 {
    private String[] arrayStr;

    public Task2(final String[] arrayStr) {
        this.arrayStr = arrayStr;

    }

    public int countChar(final char symbol) {
        int amount = 0;

        for (int i = 0; i < arrayStr.length; i++) {
            for (int j = 0; j < arrayStr[i].length(); j++) {
                if (arrayStr[i].charAt(j) == symbol) {
                    amount++;
                }
            }
        }
        return amount;
    }

    public static void main(final String[] args) {
        Task2 task = new Task2(new String[]{"12", "1", "12134", "121"});
        System.out.println(task.countChar('1'));

    }
}
