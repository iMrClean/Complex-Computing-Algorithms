package ru.bmstu.lab6;

import static ru.bmstu.lab6.common.Faddeev.faddeev;
import static ru.bmstu.lab6.utils.Utils.printMatrix;

/**
 * Лабораторная работа №6.
 * <p>
 * Метод Фаддеева.
 */
public class Main {

    // Размер матрицы NxN
    public static int N = 4;

    // Произвольная матрица
    private static double[][] A = {
            {2.0, 4.0, 2.0, 4.0},
            {1.0, 1.0, 6.0, 3.0},
            {-1.0, -4.0, 1.0, 1.0},
            {4.0, 5.0, 9.0, 12.0}
    };

    public static void main(String[] args) {
        printMatrix("Matrix A", A);
        double[][] R = new double[N][N];
        faddeev(R,A,N);
    }
}
