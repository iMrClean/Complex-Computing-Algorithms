package ru.bmstu.lab6.common;

import static ru.bmstu.lab6.utils.Utils.printMatrix;

public class Faddeev {

    public static boolean faddeev(double[][] R, double[][] A, int N) {

        double[][] B = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j] = 0.0;
            }
            B[i][i] = 1.0;
        }

        printMatrix("Matrix E", B);
        double[][] U = new double[N][N];
        // Коэффициенты характеристического уравнения
        double P = 0.0;
        for (int k = 1; k <= N; k++) {
            System.out.println("k = " + k);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double Z = 0.0;
                    for (int m = 0; m < N; m++) {
                        Z += A[i][m] * B[m][j];
                    }
                    U[i][j] = Z;
                }
            }

            printMatrix("Matrix U", U);

            double S = 0.0;
            for (int i = 0; i < N; i++) {
                S += U[i][i];
            }
            P = S / k;

            System.out.println("S = " + S);
            System.out.println("P = " + P);

            if (k == N) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    B[i][j] = U[i][j];
                }
                B[i][i] -= P;
            }
            printMatrix("Matrix B", B);
        }

        if (P == 0) {
            return false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = B[i][j] / P;
            }
        }

        printMatrix("Matrix R", R);
        return true;
    }
}
