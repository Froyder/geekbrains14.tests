package ru.geek.homeworks.lesson14.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodsTest {

    // параметризированный тест для проверки первого метода
    @ParameterizedTest
    @MethodSource("arrayProvider")
    public void massTest(int[] array, int [] expected) {
            Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(Methods.afterFour(array)));
    }

    // параметризированный тест для проверки первого метода на исключения
    @ParameterizedTest
    @MethodSource("arrayProviderRTE")
    public void massTest_RTE(int[] array, int [] expected) {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(Methods.afterFour(array)));
        });
    }

    //набор данных для проверки первого метода
    public static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3, 2, 1, 7, 14, 4, 90, 15}, new int[]{90,15}),
                Arguments.of(new int[]{4, 14, 90, 4, 155, 3, 2, 1}, new int[]{155, 3, 2, 1}),
                Arguments.of(new int[]{23, 11, 4, 67, 488, 36, 50}, new int[]{67, 488, 36, 50}),
                Arguments.of(new int[]{20, 52, 4, 11, 21, 345, 18, 69}, new int[]{11, 21, 345, 18, 69}));
    }

    //набор данных для проверки первого метода с обработкой исключений
    public static Stream<Arguments> arrayProviderRTE() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 2, 1, 7, 14, 90, 15}, null),
                Arguments.of(new int[]{14, 90, 155, 3, 2, 1}, null),
                Arguments.of(new int[]{23, 11, 67, 488, 36, 50}, null),
                Arguments.of(new int[]{20, 52, 11, 21, 345, 18, 69}, null));
    }

    //параметризированный тест для проверки второго метода
    @ParameterizedTest
    @MethodSource("arrayProviderTwo")
    public void massTest_2(int[] array, boolean result) throws RuntimeException {
        try {
            Assertions.assertEquals(result, Methods.oneAndFour(array));
        } catch (RuntimeException ignored) {
        }
    }

    //набор данных для проверки второго метода
    public static Stream<Arguments> arrayProviderTwo() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 4, 1, 1, 4}, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, false),
                Arguments.of(new int[]{4, 4, 4, 4, 4, 4, 4}, false),
                Arguments.of(new int[]{1, 4, 5, 1, 4, 3, 2}, false));

    }

    /*
    бонусный раунд
     */

    //одиночный тест для проверки первого метода на исключение
    @org.junit.Test(expected = RuntimeException.class)
    public void afterFourTest_3() {
        int[] array3 = new int[]{23, 11, 67, 488, 36, 50};
        int[] expected = new int [0];
        int[] actual = Methods.afterFour(array3);
        Assertions.assertEquals(Arrays.toString(expected),Arrays.toString(actual));
    }

    //одиночный тест для проверки второго метода на true
    @org.junit.Test
    public void oneAndFourTest_1() {
        int[] array5 = new int[] {1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertEquals(true, Methods.oneAndFour(array5));
    }

    //одиночный тест для проверки второго метода на false
    @org.junit.Test
    public void oneAndFourTest_2() {
        int[] array6 = new int[]{1, 1, 1, 1, 1};
        Assertions.assertEquals(false, Methods.oneAndFour(array6));
    }


}
