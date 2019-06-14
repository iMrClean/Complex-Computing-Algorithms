package ru.bmstu.lab2.common;

public class GaussExchange {
    /**
     * Вариант 2
     */
    public static double[][] gaussExchange(double[] X, double[][] Z, double[] Y, int N) {
        double[][] A = cloneArray(Z);
        double[] B = new double[N];
        System.arraycopy(Y, 0, B, 0, Y.length);

        //Часть 1 Считаем матрицу методом Гаусса
        for (int k = 0; k < N - 1; k++) {
            exchange(A, B, N, k);
            for (int i = k + 1; i < N; i++) {
                double D = A[k][k];
                double R = A[i][k] / D;     //D - ?
                for (int j = k; j < N; j++) {
                    A[i][j] -= A[k][j] * R;
                }
                B[i] -= B[k] * R;
            }
        }

        //Часть 2 Считаем корни
        X[N - 1] = B[N - 1] / A[N - 1][N - 1];
        for (int i = N - 2; i >= 0; i--) {
            double S = 0.0;
            for (int j = i + 1; j < N; j++) {
                S += A[i][j] * X[j];
            }
            X[i] = (B[i] - S) / A[i][i];
        }
        return A;
    }

    private static void exchange(double[][] A, double[] B, int N, int K) {
        if (A[K][K] != 0) {
            return;
        }

        int M = K + 1;

        while (M < N) {
            if (A[M][K] != 0.0) {
                break;
            }
            M++;
        }

        //поменяли строки
        for (int j = 0; j < N; j++) {
            double U = A[K][j];
            A[K][j] = A[M][j];
            A[M][j] = U;
        }

        double V = B[K];
        B[K] = B[M];
        B[M] = V;
    }

    private static double[][] cloneArray(double[][] source) {
        int length = source.length;
        double[][] cloneArray = new double[length][source[0].length];

        for (int i = 0; i < length; i++) {
            System.arraycopy(source[i], 0, cloneArray[i], 0, source[i].length);
        }

        return cloneArray;
    }
}
