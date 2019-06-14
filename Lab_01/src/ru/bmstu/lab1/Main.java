package ru.bmstu.lab1;

import static ru.bmstu.lab1.commons.Gauss.gauss;
import static ru.bmstu.lab1.utils.Utils.*;

/**
 * Лабораторная работа №1.
 * <p>
 * Метод Гаусса
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
        // Выводим исходную матрицу и вектор
        printMatrixVector("Matrix A, Vector B", A, B);
        // Создаем вектор содержащий корни
        double[] X = new double[N];

        // Считаем методом Гаусса
        double[][] matrix = gauss(X, A, B, N);
        printMatrix("Gauss Matrix", matrix);
        printVector("Roots", X);
    }
}