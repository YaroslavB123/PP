package com.company;

import java.util.Arrays;

public class Task1 {
    private String[] arrayStr;

    public Task1(final String[] arrayStr) {
        this.arrayStr = arrayStr;
    }

    public String[] getArrayStr() {
        return arrayStr;
    }

    public void sortBubble() {
        for (int i = 0; i < arrayStr.length; i++) {
            for (int j = 1; j < arrayStr.length; j++) {
                if (arrayStr[j - 1].length() < arrayStr[j].length()) {
                    String tmp = arrayStr[j - 1];
                    arrayStr[j - 1] = arrayStr[j];
                    arrayStr[j] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Task1{" +
                "arrayStr=" + Arrays.toString(arrayStr) +
                '}';
    }

    public static void main(final String[] args) {
        final Task1 task = new Task1(new String[]{"12", "1", "1234", "123"});

        System.out.println(task.toString());
        task.sortBubble();
        System.out.println(task.toString());

    }
}
