package ru.reksoft.education.algorithms;

public class Lesson2 {

    /**
     * Реализовать сортировку выбором
     */
    public int[] exercise1(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * Реализовать сортировку пузырьком
     */
    public int[] exercise2(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Дан массив целых чисел и ещё одно целое число.
     * Удалите все вхождения этого числа из массива (пропусков быть не должно).
     * Пример:
     * {0,1,2,2,3,0,4,2} -> 2 -> {0,1,3,0,4}
     * Сложность времени алгоритма должна быть равна O(N).
     */
    public int[] exercise3(int[] arr, int num) {
        int notNumCount = 0;

        for (int element : arr) {
            if (element != num) {
                notNumCount++;
            }
        }

        int[] result = new int[notNumCount];
        int resultIndex = 0;

        for (int element : arr) {
            if (element != num) {
                result[resultIndex++] = element;
            }
        }

        return result;
    }

    /**
     * Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
     * Сложность времени алгоритма должна быть равна O(N).
     */
    public Aggregate exercise4(int[] arr) {
        assert arr.length > 0;

        int min = arr[0];
        int max = arr[0];
        int sum = arr[0];

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] < min) {
                min = arr[index];
            }
            if (arr[index] > max) {
                max = arr[index];
            }
            sum += arr[index];
        }

        return new Aggregate(min, max, (double) sum / arr.length);
    }

    public record Aggregate(int min, int max, double avg) {
    }

}
