package com.dfedorino.rtasks.first_level;

import lombok.Value;

public class Watch {
    /**
     * Электронные часы показывают время в формате h:mm:ss, то есть сначала записывается количество часов в
     * диапазоне от 0 до 23, потом обязательно двузначное количество минут, затем обязательно двузначное
     * количество секунд. Количество минут и секунд при необходимости дополняются до двузначного числа
     * нулями.
     * <p>
     * С начала некоторых суток прошло n секунд. Выведите, что покажут часы. Задачу необходимо решить без
     * использования условных операторов (в том числе без тернарного оператора ?: в С++), без циклов,
     * массивов и строк, и без хитрого форматированного вывода (типа %02d).
     *
     * @param seconds - кол-во секунд
     * @return строка с временем в 24-часовом формате
     */
    // Does not pass tests
    public Time showTime(int seconds) {
        int maxSeconds = 60;
        int maxMinutes = 60 * 60;
        int maxHours = 24 * 60 * 60;
        int sec = seconds % maxSeconds;
        int minutes = seconds % maxMinutes;
        int hours = seconds % maxHours;

        String hoursString = hours / 10 + "" + hours % 10;
        String minutesString = minutes / 10 + "" + minutes % 10;
        String secondsString = sec / 10 + "" + sec % 10;
        return new Time(hoursString, minutesString + "", secondsString);
    }

    @Value
    public static class Time {
        String hours;
        String minutes;
        String seconds;
    }
}
