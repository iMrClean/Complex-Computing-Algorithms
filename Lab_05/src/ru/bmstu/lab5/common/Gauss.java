package ru.bmstu.lab5.common;

public class Gauss {

    public static double[][] gaussReverse(double[][] R, final double[][] Z, int N) {
        double[][] A = cloneArray(Z);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = 0.0;
            }
            R[i][i] = 1.0;
        }

        // Часть 1.
        for (int k = 0; k < N; k++) {
            double D = A[k][k];
            for (int j = k; j < N; j++) {
                A[k][j] /= D;
            }
            for (int j = 0; j < N; j++) {
                R[k][j] /= D;
            }
            for (int i = k + 1; i < N; i++) {
                double r = A[i][k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= A[k][j] * r;
                }
                for (int j = 0; j < N; j++) {
                    R[i][j] -= R[k][j] * r;
                }
            }
        }

        // Часть 2.
        for (int k = N - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                double r = A[i][k];
                A[i][k] = 0.0;
                for (int j = 0; j < N; j++) {
                    R[i][j] -= R[k][j] * r;
                }
            }
        }

        return R;
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