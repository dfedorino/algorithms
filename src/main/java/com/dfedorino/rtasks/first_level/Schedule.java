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
     * @param lesson - порядковый номер урока
     * @return строка со временем, которое прошло с начала уроков до конца данного урока
     */
    public String getEndTime(int lesson) {
        int hours = 9;
        int minutes = 0;
        int lessonDurationMin = 45;
        int breakAfterOddOrdinal = 5;
        int breakAfterEvenOrdinal = 15;
        int minutesPassed = lessonDurationMin;
        for (int lessonOrdinal = 1; lessonOrdinal < lesson; lessonOrdinal++) {
            if (lessonOrdinal % 2 != 0) {
                minutesPassed += lessonDurationMin + breakAfterOddOrdinal;
            } else {
                minutesPassed += lessonDurationMin + breakAfterEvenOrdinal;
            }
        }
        int minutesPerHour = 60;
        hours += minutesPassed / minutesPerHour;
        minutes += minutesPassed % minutesPerHour;
        return (hours / 10 + "" + hours % 10) + " " + (minutes / 10  + "" + minutes % 10);
    }
}
