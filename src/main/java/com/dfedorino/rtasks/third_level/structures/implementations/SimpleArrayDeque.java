package com.dfedorino.rtasks.third_level.structures.implementations;

import lombok.Getter;

import java.util.Arrays;

public class SimpleArrayDeque<T> {
    private Object[] array;
    @Getter
    private int capacity;
    private int size = 0;
    @Getter
    private int indexOfFirst = -1;
    @Getter
    private int indexOfLast = -1;

    public SimpleArrayDeque() {
        this(16);
    }

    public SimpleArrayDeque(int customCapacity) {
        array = new Object[customCapacity];
        capacity = customCapacity;
    }

    public String pushFront(T element) {
        checkIfNeedToResize();
        if (indexOfFirst == -1 && indexOfLast == -1) {
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

    public String pushBack(T element) {
        checkIfNeedToResize();
        if (indexOfFirst == -1 && indexOfLast == -1) {
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

    public String popFront() {
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

    public String popBack() {
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

    public String front() {
        if (size == 0) {
            return "error";
        }
        return getElementAtIndex(indexOfFirst);
    }

    public String back() {
        if (size == 0) {
            return "error";
        }
        return getElementAtIndex(indexOfLast);
    }

    public String size() {
        return size + "";
    }

    public String clear() {
        if (size == 0) {
            return "error";
        }
        indexOfFirst = -1;
        indexOfLast = -1;
        size = 0;
        return "ok";
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

    private void checkIfNeedToResize() {
        if (size + 1 > capacity) {
            resize();
        }
    }

    private String getElementAtIndex(int index) {
        return array[index].toString();
    }
}
