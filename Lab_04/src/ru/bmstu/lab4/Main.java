package ru.bmstu.lab4;

import ru.bmstu.lab4.common.Gauss;

import static ru.bmstu.lab4.utils.Utils.printMatrixVector;

/**
 * Лабораторная работа №4.
 * <p>
 * HM-44
 * Метод Гаусса. Модифицированный верхний\нижний треугольник.
 * {1.0, x, x, x}, {x}
 * {0.0, 1.0, x, x}, {x}
 * {0.0, 0.0, 1.0, x}, {x}
 * {0.0, 0.0, 0.0, 1.0}, {x}
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

        Gauss gauss = new Gauss();
        double[][] matrix = gauss.gauss(X, A, B, N);
        printMatrixVector("Gauss Matrix A, Vector B", matrix, X);
    }
}
