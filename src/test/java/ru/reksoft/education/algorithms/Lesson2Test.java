package ru.reksoft.education.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Lesson2Test {

    private static final Lesson2 lesson2 = new Lesson2();
    private static final Random random = new Random();

    @Test
    void exercise1Test1() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] correctResult = {0, 0, 1, 2, 2, 2, 3, 4};

        int[] result = lesson2.exercise1(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise1Test2() {
        int[] arr = {};
        int[] correctResult = {};

        int[] result = lesson2.exercise1(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise1Test3() {
        int[] arr = generateArray();
        int[] correctResult = Arrays.stream(arr).sorted().toArray();

        int[] result = lesson2.exercise1(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise1Test4() {
        for (int i = 0; i < 10000; i++) {
            exercise1Test3();
        }
    }


    @Test
    void exercise2Test1() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] correctResult = {0, 0, 1, 2, 2, 2, 3, 4};

        int[] result = lesson2.exercise2(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise2Test2() {
        int[] arr = {};
        int[] correctResult = {};

        int[] result = lesson2.exercise2(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise2Test3() {
        int[] arr = generateArray();
        int[] correctResult = Arrays.stream(arr).sorted().toArray();

        int[] result = lesson2.exercise2(arr);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise2Test4() {
        for (int i = 0; i < 10000; i++) {
            exercise2Test3();
        }
    }


    @Test
    void exercise3Test1() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int num = 2;
        int[] correctResult = {0, 1, 3, 0, 4};

        int[] result = lesson2.exercise3(arr, num);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test2() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        int num = 9;
        int[] correctResult = {0, 1, 2, 2, 3, 0, 4, 2};

        int[] result = lesson2.exercise3(arr, num);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test3() {
        int[] arr = {};
        int num = 2;
        int[] correctResult = {};

        int[] result = lesson2.exercise3(arr, num);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test4() {
        int[] arr = generateArray();
        int num = random.nextInt();
        int[] correctResult = Arrays.stream(arr).filter(i -> i != num).toArray();

        int[] result = lesson2.exercise3(arr, num);

        assertArrayEquals(correctResult, result);
    }

    @Test
    void exercise3Test5() {
        for (int i = 0; i < 10000; i++) {
            exercise3Test4();
        }
    }


    @Test
    void exercise4Test1() {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        Lesson2.Aggregate correctResult = new Lesson2.Aggregate(0, 4, 1.75);

        Lesson2.Aggregate result = lesson2.exercise4(arr);

        assertEquals(correctResult, result);
    }

    @Test
    void exercise4Test2() {
        int[] arr = {};

        assertThrows(AssertionError.class, () -> lesson2.exercise4(arr));
    }

    @Test
    void exercise4Test3() {
        int[] arr = generateArray();
        Lesson2.Aggregate correctResult = new Lesson2.Aggregate(
                Arrays.stream(arr).min().orElseThrow(),
                Arrays.stream(arr).max().orElseThrow(),
                Arrays.stream(arr).average().orElseThrow()
        );

        Lesson2.Aggregate result = lesson2.exercise4(arr);

        assertEquals(correctResult, result);
    }

    @Test
    void exercise4Test4() {
        for (int i = 0; i < 10000; i++) {
            exercise4Test3();
        }
    }


    private int[] generateArray() {
        int[] arr = new int[random.nextInt(1, 100)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(-100, 100);
        }

        return arr;
    }

}
