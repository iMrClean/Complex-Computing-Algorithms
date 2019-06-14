package ru.bmstu.lab3;

import ru.bmstu.lab3.common.GaussModify;

import static ru.bmstu.lab3.util.Utils.printMatrixVector;

/**
 * Лабораторная работа №3
 * <p>
 * HM43.
 * Модифицированный метод Гаусса.
 * {1.0, x, x, x},
 * {0.0, 1.0, x, x},
 * {0.0, 0.0, 1.0, x},
 * {0.0, 0.0, 0.0, 1.0},
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

    // Вектор свободных членов
    private static double[] B = {22.0, 19.0, -10.0, 49.0};

    public static void main(String[] args) {
        printMatrixVector("Matrix A, Vector B", A, B);

        double[] X = new double[N];
        GaussModify gaussModify = new GaussModify();
        double[][] matrix = gaussModify.gaussModify(X, A, B, N);
        printMatrixVector("Matrix A, Vector B", matrix, X);
    }
}
