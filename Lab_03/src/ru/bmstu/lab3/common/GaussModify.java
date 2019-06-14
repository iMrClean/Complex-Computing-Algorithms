package ru.bmstu.lab3.common;

import static ru.bmstu.lab3.util.Utils.printMatrixVector;
import static ru.bmstu.lab3.util.Utils.printVector;

public class GaussModify {

    public double[][] gaussModify(double[] X, double[][] Z, double[] Y, int N) {
        double[][] A = cloneArray(Z);
        double[] B = new double[N];
        System.arraycopy(Y, 0, B, 0, Y.length);

        // Часть 1
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

        // Часть 2
        X[N - 1] = B[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            double S = 0.0;
            for (int j = i + 1; j < N; j++) {
                S += A[i][j] * X[j];
            }
            X[i] = B[i] - S;
        }

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
