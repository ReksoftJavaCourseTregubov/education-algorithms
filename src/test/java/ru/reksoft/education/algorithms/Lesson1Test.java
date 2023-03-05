package ru.reksoft.education.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Lesson1Test {

    private static final Lesson1 lesson1 = new Lesson1();
    private static final Random random = new Random();

    @Test
    void exercise1Test1() {
        int[] arr = {3, 4, 5, 11, 32};
        int result = lesson1.exercise1(arr, 5);
        assertEquals(2, result);
    }

    @Test
    void exercise1Test2() {
        int[] arr = {3, 4, 5, 11, 32};
        int result = lesson1.exercise1(arr, 17);
        assertEquals(-1, result);
    }

    @Test
    void exercise1Test3() {
        int[] arr = generateSortedArray(false);
        int index = random.nextInt(arr.length);
        int result = lesson1.exercise1(arr, arr[index]);
        assertEquals(index, result);
    }

    @Test
    void exercise1Test4() {
        for (int i = 0; i < 10000; i++) {
            exercise1Test3();
        }
    }


    @Test
    void exercise2Test1() {
        int[] arr = {3, 4, 5, 11, 32};
        int result = lesson1.exercise2(arr, 5);
        assertEquals(2, result);
    }

    @Test
    void exercise2Test2() {
        int[] arr = {3, 4, 5, 11, 32};
        int result = lesson1.exercise2(arr, 17);
        assertEquals(-1, result);
    }

    @Test
    void exercise2Test3() {
        int[] arr = generateSortedArray(false);
        int index = random.nextInt(arr.length);
        int result = lesson1.exercise2(arr, arr[index]);
        assertEquals(index, result);
    }

    @Test
    void exercise2Test4() {
        for (int i = 0; i < 10000; i++) {
            exercise2Test3();
        }
    }


    @Test
    void exercise3Test1() {
        int[] first = {3, 4, 5, 11, 32};
        int[] second = {2, 3, 5, 11};
        int[] correctResult = {4, 32};

        int[] result = lesson1.exercise3(first, second);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test2() {
        int[] first = {3, 4, 5, 11, 32};
        int[] second = {3, 4, 5, 11, 32};
        int[] correctResult = {};

        int[] result = lesson1.exercise3(first, second);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test3() {
        int[] first = {3, 4, 5, 5, 11, 32};
        int[] second = {2, 3, 5, 11};
        int[] correctResult = {4, 32};

        int[] result = lesson1.exercise3(first, second);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test4() {
        int[] first = generateSortedArray(true);
        int[] second = generateSortedArray(true);
        int[] correctResult = Arrays.stream(first).filter(i -> Arrays.stream(second).noneMatch(j -> i == j)).toArray();

        int[] result = lesson1.exercise3(first, second);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test5() {
        for (int i = 0; i < 10000; i++) {
            exercise3Test4();
        }
    }


    private int[] generateSortedArray(boolean withDuplicates) {
        int[] arr = new int[random.nextInt(1, 100)];

        arr[0] = random.nextInt(-100, 100);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + random.nextInt(withDuplicates ? 0 : 1, 100);
        }

        return arr;
    }

}
