package com.company;

public class Task6 {
    private final int[][] matrixA;
    private final int[][] matrixB;

    public Task6(final int rolA, final int col, final int colB) {
        this.matrixA = creatingMatrix(rolA, col);
        this.matrixB = creatingMatrix(col, colB);
    }

    public int[][] creatingMatrix(final int rol, final int col) {
        final int[][] matrix = new int[rol][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public int[][] multiplicationMatrix() {

        final int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    public static void print(final int[][] matrix) {
        for (int i = 0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(final String[] args) {
            final Task6 task = new Task6(4, 2, 5);
            final int[][] multiMatrix = task.multiplicationMatrix();

            System.out.println("Multi A");
            print(task.matrixA);
            System.out.println("Multi B");
            print(task.matrixB);
            System.out.println("Multi A*B");
            print(multiMatrix);

    }
}