package com.company;

import java.util.Arrays;

public class Task5 {
    private int[][] matrix;

    public Task5(final int rol, final int col) {
        this.matrix = creatingMatrix(rol, col);
    }

    public int[][] creatingMatrix(final int rol, final int col) {
        int[][] matrix = new int[rol][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public int[][] transpose() {
        final int[][] array = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                array[i][j] = matrix[j][i];
            }
        }
        return array;
    }
    public void print() {
        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(final String[] args) {
        final Task5 task = new Task5(3, 2);
        final Task5 task1 = new Task5(0, 0);

        task1.matrix = task.transpose();
        task.print();
        System.out.println();
        task1.print();

    }
}
