package com.dfedorino.rtasks.first_level;

public class ShoeFactory {
    /**
     * Обувная фабрика собирается начать выпуск элитной модели ботинок. Дырочки для шнуровки будут
     * расположены в два ряда, расстояние между рядами равно a, а расстояние между дырочками в ряду
     * b. Количество дырочек в каждом ряду равно N. Шнуровка должна происходить элитным способом
     * “наверх, по горизонтали в другой ряд, наверх, по горизонтали и т.д.” (см. рисунок). Кроме того,
     * чтобы шнурки можно было завязать элитным бантиком, длина свободного конца шнурка должна быть l.
     * Какова должна быть длина шнурка для этих ботинок?
     *
     * |   |
     * o===o
     * |   |
     * o===o
     * |   |
     * o___o
     *
     * @param a - расстояние между рядами
     * @param b - расстояние между дырочками в ряду
     * @param l - длина свободного конца шнурка
     * @param N - количество дырочек в одном ряду
     * @return длина шнурка
     */
    public int getShoelaceLength(int a, int b, int l, int N) {
        int numberOfRows = 2;
        int lengthOfShoelaceBetweenRows = a * numberOfRows * (N - 1) + a;
        int lengthOfShoelaceBetweenHoles = b * numberOfRows * (N - 1);
        int shoelaceRemainderLength = l * numberOfRows;
        return lengthOfShoelaceBetweenHoles +
                lengthOfShoelaceBetweenRows +
                shoelaceRemainderLength;
    }
}
