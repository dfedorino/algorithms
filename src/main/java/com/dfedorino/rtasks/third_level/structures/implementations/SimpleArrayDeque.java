package com.dfedorino.rtasks.third_level.structures.implementations;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SimpleArrayDeque<T> {
    protected Object[] array;
    protected int capacity;
    private int size = 0;
    protected int indexOfFirst = -1;
    protected int indexOfLast = -1;

    public SimpleArrayDeque() {
        array = new Object[16];
        capacity = 16;
    }

    public SimpleArrayDeque(int customCapacity) {
        array = new Object[customCapacity];
        capacity = customCapacity;
    }

    public String addLast(T element) {
        if (size + 1 > capacity) {
            resize();
        }
        if (indexOfFirst == -1 & indexOfLast == -1) {
            indexOfFirst = indexOfLast = 0;
        } else if (indexOfLast == capacity - 1) {
            indexOfLast = 0;
        } else {
            indexOfLast++;
        }
        array[indexOfLast] = element;
        size++;
        return "ok";
    }


    public String addFirst(T element) {
        if (size + 1 > capacity) {
            resize();
        }
        if (indexOfFirst == -1 & indexOfLast == -1) {
            indexOfFirst = indexOfLast = 0;
        } else if (indexOfFirst == 0) {
            indexOfFirst = capacity - 1;
        } else {
            indexOfFirst--;
        }
        array[indexOfFirst] = element;
        size++;
        return "ok";
    }

    public String popFirst() {
        if (size == 0) {
            return "error";
        }
        String deleted = array[indexOfFirst].toString();
        if (indexOfLast == indexOfFirst) {
            indexOfFirst = -1;
            indexOfLast = -1;
        } else if (indexOfFirst == capacity - 1) {
            indexOfFirst = 0;
        } else {
            indexOfFirst++;
        }
        size--;
        return deleted;
    }

    public String popLast() {
        if (size == 0) {
            return "error";
        }
        String deleted = array[indexOfLast].toString();
        if (indexOfLast == indexOfFirst) {
            indexOfFirst = -1;
            indexOfLast = -1;
        } else if (indexOfLast == 0) {
            indexOfLast = capacity - 1;
        } else {
            indexOfLast--;
        }
        size--;
        return deleted;
    }

    public String getSize() {
        return size + "";
    }

    protected void resize() {
        Object[] newArray = new Object[capacity * 2];
        if (indexOfLast >= indexOfFirst) {
            int elementsToCopy = indexOfLast - indexOfFirst + 1;
            System.arraycopy(array, indexOfFirst, newArray, 0, elementsToCopy);
        } else {
            int elementsToCopyFromIndexOfFirstToEnd = capacity - indexOfFirst;
            int elementsToCopyFromZeroToIndexOfLast = indexOfLast + 1;
            System.arraycopy(array, indexOfFirst, newArray, 0, elementsToCopyFromIndexOfFirstToEnd);
            System.arraycopy(array, 0, newArray, elementsToCopyFromIndexOfFirstToEnd, elementsToCopyFromZeroToIndexOfLast);
            indexOfFirst = 0;
            indexOfLast = size - 1;
        }
        Arrays.fill(array, null);
        array = newArray;
        capacity = array.length;
    }

    public String front() {
        if (size == 0) {
            return "error";
        }
        return array[indexOfFirst].toString();
    }
}
