package com.dfedorino.rtasks.first_level;

public class AppleDivider {
    /**
     * n школьников делят k яблок “поровну”, то есть так, чтобы количество яблок, доставшихся любым двум
     * школьникам, отличалось бы не более, чем на 1.
     *
     * Входные данные
     * Программа получает на вход числа n и k.
     *
     * Выходные данные
     * Программа должна вывести количество школьников, которым достанется яблок меньше, чем некоторым из
     * их товарищей.
     *
     * @param students - кол-во школьников
     * @param apples - кол-во яблок
     * @return - кол-во школьников, которым достанется меньше яблок
     */
    public int getLosers(int students, int apples) {
        return apples % students == 0 ? 0 : students - apples % students;
    }
}
