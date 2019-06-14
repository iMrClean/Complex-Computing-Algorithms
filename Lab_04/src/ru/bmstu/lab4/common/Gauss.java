package ru.bmstu.lab4.common;

public class Gauss {

    public double[][] gauss(double[] X, double[][] Z, double[] Y, int N) {
        double[][] A = cloneArray(Z);
        double[] B = new double[N];
        System.arraycopy(Y, 0, B, 0, Y.length);

        // Часть 1. Верхнее треугольное преобразование.
        for (int k = 0; k < N; k++) {
            double D = A[k][k];
            for (int j = k; j < N; j++) {
                A[k][j] /= D;
            }
            B[k] /= D;
            for (int i = k + 1; i < N; i++) {
                double R = A[i][k];
                for (int j = k; j < N; j++) {
                    A[i][j] -= A[k][j] * R;
                }
                B[i] -= B[k] * R;
            }
        }

        // Часть 2. Нижнее преобразование.
        for (int k = N - 1; k > 0; k--) {
            for (int i = k - 1; i >= 0; i--) {
                B[i] -= B[k] * A[i][k];
                A[i][k] = 0.0;
            }
        }

        System.arraycopy(B, 0, X, 0, N);
        return A;
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
