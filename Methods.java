package ru.geek.homeworks.lesson14.utils;

import static java.lang.System.arraycopy;

public class Methods {

    // метод возвращает массив с числами, следующими за последней встреченной четверкой (или ошибку, если четверок нет)
    public static int[] afterFour(int[] array) {
        int x = 0;
        int MAGIC_NUMBER = 4;

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] == MAGIC_NUMBER) {
                x = array.length - i - 1;
                break;
            }
        }

        int[] newArray = new int[x];
        arraycopy(array, array.length - x, newArray, 0, newArray.length);

        try {
            x = 1 / x;
        } catch (RuntimeException exception) {
            throw new RuntimeException();
        }
        return newArray;
    }

    // метод возвращает true, если массив состоит строго из 1 и 4, и false - во всех прочих комбинациях
    public static boolean oneAndFour(int[] array) {
        int one = 0;
        int four = 0;
        boolean result = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1 && array[i] != 4) {
                result = false;
                break;
            } else if (array[i] == 1) {
                one++;
            } else if (array[i] == 4) {
                four++;
            }
        } if (one == 0 || four == 0) {
            result = false;
        }
        return result;

    }

}
