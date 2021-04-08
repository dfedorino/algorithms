package com.dfedorino.rtasks.first_level;

public class ArrayShifter {
    /**
     * Напишите программу, которая циклически сдвигает элементы массива вправо (например, если элементы
     * нумеруются, начиная с нуля, то 0-й элемент становится 1-м, 1-й становится 2-м, ..., последний
     * становится 0-м, то есть массив {3, 5, 7, 9} превращается в массив {9, 3, 5, 7}).
     *
     * @param array - массив, в котором делается сдвиг
     */
    public void rightShift(int[] array) {
        int previous = array[array.length - 1];
        for (int elementIndex = 0; elementIndex < array.length; elementIndex++) {
            int temp = array[elementIndex];
            array[elementIndex] = previous;
            previous = temp;
        }
    }
}
