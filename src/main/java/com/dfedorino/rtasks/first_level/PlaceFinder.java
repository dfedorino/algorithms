package com.dfedorino.rtasks.first_level;

public class PlaceFinder {
    /**
     * Петя впервые пришел на урок физкультуры в новой школе. Перед началом урока ученики выстраиваются по
     * росту, в порядке невозрастания. Напишите программу, которая определит на какое место в шеренге Пете
     * нужно встать, чтобы не нарушить традицию, если заранее известен рост каждого ученика и эти данные
     * уже расположены по невозрастанию (то есть каждое следующее число не больше предыдущего). Если в
     * классе есть несколько учеников с таким же ростом, как у Пети, то программа должна расположить его
     * после них.
     *
     * Входные данные
     * Массив состоит из натуральных чисел, не превосходящих 200 (рост учеников в сантиметрах). Затем, на
     * новой строке, вводится рост самого Пети (тоже натуральное число не больше 200).
     *
     * Выходные данные
     * Необходимо вывести единственное число - номер Пети в шеренге учеников
     *
     * @param numbers - рост учеников в сантиметрах в порядке невозрастания
     * @param number - рост Пети
     * @return место Пети в шеренге (индекс начинается с 1)
     */
    public int findPlace(int[] numbers, int number) {
        int leftBorder = 0;
        if (number > numbers[leftBorder]) return 1;
        int rightBorder = numbers.length - 1;
        if (number < numbers[rightBorder]) return numbers.length + 1;
        while (true) {
            int middleIndex = leftBorder + (rightBorder - leftBorder) / 2;
            int currentNumber = numbers[middleIndex];
            if (rightBorder - leftBorder == 1) {
                return middleIndex + 2;
            }
            if (currentNumber >= number) {
                leftBorder = middleIndex;
            } else {
                rightBorder = middleIndex;
            }
        }
    }
}
