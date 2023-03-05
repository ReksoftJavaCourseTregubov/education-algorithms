package ru.reksoft.education.algorithms;

public class Lesson1 {

    /**
     * Задача: реализовать алгоритм линейного поиска для массива.
     */
    public int exercise1(int[] arr, int elementToSearch) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == elementToSearch) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Задача: реализовать алгоритм бинарного поиска для массива.
     */
    public int exercise2(int[] arr, int elementToSearch) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        //  условие прекращения (элемент не представлен)
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // если средний элемент - целевой элемент, вернуть его индекс
            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            }

            // если средний элемент меньше
            // направляем наш индекс в middle+1, убирая первую часть из рассмотрения
            else if (arr[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            }

            // если средний элемент больше
            // направляем наш индекс в middle-1, убирая вторую часть из рассмотрения
            else if (arr[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    /**
     * Условие: есть 2 сортированных последовательности целых чисел.
     * Необходимо напечатать те элементы из первой последовательности, которых нет во второй последовательности.
     * Пример: [3, 4, 5, 11, 32] и [2, 3, 5, 11] -> 4, 32
     * Алгоритм должен работать за время O(N).
     */
    public int[] exercise3(int[] first, int[] second) {
        int firstIndex = 0;
        int secondIndex = 0;

        boolean[] skip = new boolean[first.length];
        int skipCount = 0;

        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] <= second[secondIndex]) {
                if (first[firstIndex] == second[secondIndex]) {
                    skip[firstIndex] = true;
                    skipCount++;
                }
                firstIndex++;
            } else {
                secondIndex++;
            }
        }

        int[] result = new int[first.length - skipCount];
        int resultIndex = 0;

        for (int index = 0; index < first.length; index++) {
            if (!skip[index]) {
                result[resultIndex++] = first[index];
            }
        }

        return result;
    }

}
