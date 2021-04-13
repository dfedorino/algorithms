package com.dfedorino.rtasks.first_level;

public class CalculusTasks {
    /**
     * N школьников делят K яблок поровну, неделящийся остаток остается в корзинке.
     * Сколько яблок достанется каждому школьнику?
     * Входные данные
     * Программа получает на вход числа N и K.
     *
     * @param students - число студентов
     * @param apples   - число яблок
     * @return - кол-во яблок для каждого студента
     */
    public static int divideApples(int students, int apples) {
        numberBoundCheck(0, Integer.MAX_VALUE, apples, students);
        return students == 0 ? 0 : apples / students;
    }

    /**
     * N школьников делят K яблок поровну, неделящийся остаток остается в корзинке.
     * Сколько яблок останется в корзинке?
     *
     * @param students - число студентов
     * @param apples   - число яблок
     * @return - кол-во оставшихся яблок
     */
    public static int applesRemainder(int students, int apples) {
        numberBoundCheck(0, Integer.MAX_VALUE, apples, students);
        return students == 0 ? 0 : apples % students;
    }

    /**
     * Напишите программу, которая считывает целое число и выводит текст, аналогичный приведенному в примере.
     * Пробелы, знаки препинания, заглавные и строчные буквы важны!
     * <p>
     * Пример:
     * The next number for the number 179 is 180.
     * The previous number for the number 179 is 178.
     *
     * @param number - число, по модулю не превышающее 10_000
     * @return строку по заданному примеру.
     */
    public static String nextAndPrevious(int number) {
        numberBoundCheck(number, -10_000, 10_000);
        return String.format("The next number for the number " + number + " is %s.", number + 1)
                .concat(System.lineSeparator()).concat(
                        String.format("The previous number for the number " + number + " is %s.", number - 1));
    }

    /**
     * Дано два числа a и b. Найдите гипотенузу треугольника с заданными катетами.
     *
     * @param a - неотрицательное число, которое 0 <= a <= 1000, представляющее катет треугольника
     * @param b - неотрицательное число, которое 0 <= a <= 1000, представляющее катет треугольника
     * @return гипотенузу треугольника по заданным катетам
     */
    public static int calculateHypotenuse(int a, int b) {
        numberBoundCheck(0, 1000, a, b);
        return (int) Math.sqrt(a * a + b * b);
    }

    /**
     * Дано натуральное число. Выведите его последнюю цифру.
     *
     * @param number - любое натуральное число
     * @return последняя цифра данного числа
     */
    public static int getLastDigit(int number) {
        return Math.abs(number % 10);
    }

    /**
     * Дано натуральное число. Найдите число десятков в нем.
     * Решение подходит для задач "Число десятков двузначного числа" и "Число десятков"
     *
     * @param number - любое натуральное число
     * @return кол-во десятков
     */
    public static int getTens(int number) {
        int absolute = Math.abs(number);
        numberBoundCheck(absolute, 0, Integer.MAX_VALUE);
        return absolute / 10 % 10;
    }

    /**
     * Дано трехзначное число. Найдите сумму его цифр.
     *
     * @param number - любое число в промежутке от -999 до 999
     * @return сумма цифр числа
     */
    public static int getDigitsSum(int number) {
        int absolute = Math.abs(number);
        numberBoundCheck(absolute, -999, 999);
        return absolute % 10 +
                absolute / 10 % 10 +
                absolute / 100 % 10;
    }

    /**
     * Дано число n. С начала суток прошло n минут. Определите, сколько часов и минут будут показывать электронные часы
     * в этот момент. Программа должна вывести два числа: количество часов (от 0 до 23) и количество минут (от 0 до 59).
     * Учтите, что число n может быть больше, чем количество минут в сутках.
     *
     * @param minutesSinceMidnight - кол-во минут, прошедших с полуночи
     * @return часы и минуты, разделенные пробелом
     */
    public static String getCurrentTime(int minutesSinceMidnight) {
        int hours = minutesSinceMidnight / 60 == 12 ? 0 : minutesSinceMidnight / 60;
        int minutes = minutesSinceMidnight % 60;
        return hours + " " + minutes;
    }

    /**
     * Пирожок в столовой стоит rubblesPerBuying рублей и penniesPerBuying копеек.
     * Определите, сколько рублей и копеек нужно заплатить за quantity пирожков.
     *
     * @param rubblesPerBuying - рублевая часть стоимости одного пирожка
     * @param penniesPerBuying - копеечная часть стоимости одного пирожка
     * @param quantity         - кол-во пирожков к покупке
     * @return - общая стоимость всех пирожков к покупке
     */
    public static String getOverallPrice(int rubblesPerBuying, int penniesPerBuying, int quantity) {
        numberBoundCheck(0, Integer.MAX_VALUE, rubblesPerBuying, penniesPerBuying, quantity);
        long penniesOverall = (long) penniesPerBuying * quantity;
        long rubblesOverall = (long) rubblesPerBuying * quantity + penniesOverall / 100;
        return rubblesOverall + " " + penniesOverall % 100;
    }

    /**
     * Даны значения двух моментов времени, принадлежащих одним и тем же суткам: часы, минуты и секунды для каждого из
     * моментов времени. Известно, что второй момент времени наступил не раньше первого.
     * <p>
     * Определите, сколько секунд прошло между двумя моментами времени.
     *
     * @param startHour   - порядковый час первого момента времени от 0 до 11
     * @param startMinute - порядковая минута первого момента времени от 0 до 59
     * @param startSecond - порядковая секунда первого момента времени от 0 до 59
     * @param endHour     - порядковый час второго момента времени от 0 до 11
     * @param endMinute   - порядковая минута второго момента времени от 0 до 59
     * @param endSecond   - порядковая секунда второго момента времени от 0 до 59
     * @return кол-во секунд прошедших между первым и вторым моментами времени
     */
    public static int getTimeDifference(int startHour, int startMinute, int startSecond,
                                        int endHour, int endMinute, int endSecond) {
        numberBoundCheck(0, 11, startHour, endHour);
        numberBoundCheck(0, 59, startMinute, endMinute, startSecond, endSecond);
        int secondsPassedSinceMidnightUntilStartTime = startHour * 3600 + startMinute * 60 + startSecond;
        int secondsPassedSinceMidnightUntilEndTime = endHour * 3600 + endMinute * 60 + endSecond;
        numberBoundCheck(secondsPassedSinceMidnightUntilStartTime, 0, secondsPassedSinceMidnightUntilEndTime);
        return secondsPassedSinceMidnightUntilEndTime - secondsPassedSinceMidnightUntilStartTime;
    }

    /**
     * Checks that the given numbers belong to the range of values from lowerBound to upperBound inclusively.
     *
     * @param lowerBound - an integer representing lower bound
     * @param upperBound - an integer representing upper bound
     * @param numbers    - numbers to check
     * @throws IllegalArgumentException if at least one number does not belong to the specified range
     */
    private static void numberBoundCheck(int lowerBound, int upperBound, int... numbers) {
        for (int number : numbers) {
            numberBoundCheck(number, lowerBound, upperBound);
        }
    }

    /**
     * Checks that the given number belongs to the range of values from lowerBound to upperBound inclusively.
     *
     * @param number     - any integer
     * @param lowerBound - an integer representing lower bound
     * @param upperBound - an integer representing upper bound
     * @throws IllegalArgumentException if the number does not belong to the specified range
     */
    private static void numberBoundCheck(int number, int lowerBound, int upperBound) {
        if (number < lowerBound || number > upperBound) {
            throw new IllegalArgumentException("The number is not within " + lowerBound + " and " + upperBound);
        }
    }
}
