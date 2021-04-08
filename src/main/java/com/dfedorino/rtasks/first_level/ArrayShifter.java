package com.dfedorino.rtasks.first_level;

public class ArrayShifter {
    public void rightShift(int[] array) {
        int previous = array[array.length - 1];
        for (int elementIndex = 0; elementIndex < array.length; elementIndex++) {
            int temp = array[elementIndex];
            array[elementIndex] = previous;
            previous = temp;
        }
    }
}
