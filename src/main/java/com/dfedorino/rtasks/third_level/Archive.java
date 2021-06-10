package com.dfedorino.rtasks.third_level;

import java.util.Arrays;

public class Archive {
    /**
     * Системный администратор вспомнил, что давно не делал архива пользовательских файлов.
     * Однако, объем диска, куда он может поместить архив, может быть меньше чем суммарный
     * объем архивируемых файлов.
     * Известно, какой объем занимают файлы каждого пользователя.
     * <p>
     * Напишите программу, которая по заданной информации о пользователях и свободному
     * объему на архивном диске определит максимальное число пользователей, чьи данные можно
     * поместить в архив.
     * <p>
     * Входные данные
     * сначала вводится число S – размер свободного места на диске (натуральное, не превышает 10000),
     * затем следует число N – количество пользователей (натуральное, не превышает 100), после этого идет
     * N чисел - объем данных каждого пользователя (натуральное, не превышает 1000).
     * <p>
     * Выходные данные
     * выведите наибольшее количество пользователей, чьи данные могут быть помешены в архив.
     * <p>
     * Ход размышлений:
     * 0. Главное свойство жадного алгоритма - на каждом шаге выбирать наилучшее решение;
     * 1. Наилучшее решение на каждом шаге - выбирать наименьший объем данных пользователя;
     * 2. Чтобы каждый раз не проходить n - 1, n - 2 и тд, необходимо отсортировать данные в возрастающем порядке;
     * 3. После сортировки каждый из первых элементов массива является наименьшим среди тех, что левее;
     * 4. Отнимать от объема архива объем наименьших файлов, моделируя архивирование;
     * 5. Увеличить счетчик заархивированных пользователей, если объем архива >= 0;
     *
     * @param archiveVolume - размер свободного места на диске
     * @param userData - объемы данных каждого пользователя
     * @return наибольшее количество пользователей, чьи данные могут быть помешены в архив
     */
    public int countArchivedUsers(int archiveVolume, int[] userData) {
        int count = 0;
        Arrays.sort(userData);
        for (int datum : userData) {
            archiveVolume -= datum;
            if (archiveVolume < 0) {
                break;
            }
            count++;
        }
        return count;
    }
}
