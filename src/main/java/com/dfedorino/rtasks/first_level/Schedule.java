package com.dfedorino.rtasks.first_level;

public class Schedule {
    /**
     * В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут,
     * после 1-го, 3-го, 5-го и т.д. уроков перемена 5 минут,а
     * после 2-го, 4-го, 6-го и т.д. — 15 минут.
     *
     * Входные данные
     * Дан номер урока (число от 1 до 10). Определите, когда заканчивается указанный урок.
     *
     * Выходные данные
     * Выведите два целых числа: время окончания урока в часах и минутах.
     *
     * @param classes - кол-во уроков, после которых нужно знать время
     * @return строка со временем, которое прошло с начала уроков до конца данного урока
     */
    public String getEndTimeAfter(int classes) {
        int startHour = 9;
        int startMinute = 0;
        int lessonDurationMin = 45;
        int breakAfterOdd = 5;
        int breakAfterEven = 15;
        int evenClasses = classes / 2;
        int oddClasses = classes - evenClasses;
        int lastBreakDuration = classes % 2 == 0 ? 15 : 5;
        int minutesInTotal = oddClasses * (lessonDurationMin + breakAfterOdd) +
                            evenClasses * (lessonDurationMin + breakAfterEven) -
                            lastBreakDuration;
        int minutesPerHour = 60;
        startHour += minutesInTotal / minutesPerHour;
        startMinute += minutesInTotal % minutesPerHour;
        return (startHour / 10 + "" + startHour % 10) + " " + (startMinute / 10  + "" + startMinute % 10);
    }
}
