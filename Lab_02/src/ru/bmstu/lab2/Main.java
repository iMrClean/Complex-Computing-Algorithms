package ru.bmstu.lab2;

import static ru.bmstu.lab2.common.GaussExchange.gaussExchange;
import static ru.bmstu.lab2.util.Utils.printMatrix;
import static ru.bmstu.lab2.util.Utils.printMatrixVector;
import static ru.bmstu.lab2.util.Utils.printVector;

/**
 * Лабораторная работа №2.
 * HM42.
 * Метод Гаусса.
 * {x, x, x, x},
 * {0.0, x, x, x},
 * {0.0, 0.0, x, x},
 * {0.0, 0.0, 0.0, x},
 */
public class Main {

    // Размер матрицы NxN
    public static int N = 4;

    // Произвольная матрица
    private static double[][] A = {
            {0.0, 0.0, 2.0, 0.0},
            {0.0, 0.0, 6.0, 1.0},
            {0.0, 3.0, 0.0, 1.0},
            {4.0, 2.0, 0.0, 0.0},
    };

    // Вектор свободных членов
    private static double[] B = {8.0, 27.0, 6.0, 22.0};

    public static void main(String[] args) {
        // Выводим исходную матрицу и вектор
        printMatrixVector("Matrix A, Vector B", A, B);
        // Создаем вектор содержащий корни
        double[] X = new double[N];

        double[][] gaussExchange = gaussExchange(X, A, B, N);
        printMatrix("Gauss Matrix Exchange", gaussExchange);
        printVector("Roots", X);

    }
}
