package ru.bmstu.lab5;

import static ru.bmstu.lab5.common.Gauss.gaussReverse;
import static ru.bmstu.lab5.utils.Utils.printMatrix;

/**
 * Лабораторная работа №5.
 * <p>
 * Обратная матрица Гаусса.
 */
public class Main {

    // Размер матрицы NxN
    public static int N = 4;

    // Произвольная матрица
    private static final double[][] A = {
            {2.0, 4.0, 2.0, 4.0},
            {1.0, 1.0, 6.0, 3.0},
            {-1.0, -4.0, 1.0, 1.0},
            {4.0, 5.0, 9.0, 12.0}
    };

    public static void main(String[] args) {
        printMatrix("Matrix A", A);
        double[][] R = new double[N][N];
        double[][] gaussReverse = gaussReverse(R, A, N);
        printMatrix("Gauss Reverse", gaussReverse);

        //Проверять будем что E = R * A.
        double[][] E = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double s = 0.0;
                for (int m = 0; m < N; m++) {
                    s += R[i][m] * A[m][j];
                }
                E[i][j] = s;
            }
        }
        printMatrix("E=R*A:", E);
    }
}