package ru.bmstu.lab5.utils;

import static ru.bmstu.lab5.Main.N;

public class Utils {

    public static void printMatrixVector(String text, double[][] matrix, double[] vector) {
        if (matrix.length != vector.length) {
            System.err.println("Matrix and vector has wrong sizes!");
            System.exit(-1);
        }
        System.out.println(text.replace(",", "\t\t\t\t\t\t\t"));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    System.out.print("(");
                }
                System.out.format("%8.2f", matrix[i][j]);
                if (j == (N - 1)) {
                    System.out.print(" )");
                }
            }
            System.out.format("(%8.2f   )\n", vector[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void printVector(String text, double[] vector) {
        System.out.println(text);

        for (int i = 0; i < N; i++) {
            System.out.format("(   %1.2f   )\n", vector[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void printMatrix(String text, double[][] matrix) {
        System.out.println(text);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    System.out.print("(");
                }
                System.out.format("%8.2f", matrix[i][j]);
                if (j == (N - 1)) {
                    System.out.print(" )\n");
                }
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }
}