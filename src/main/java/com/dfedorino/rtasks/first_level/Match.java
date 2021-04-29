package com.dfedorino.rtasks.first_level;

import lombok.Value;

import java.util.Locale;

public class Match {
    /**
     * Напишите программу, которая по данному протоколу матча восстановит итоговый счёт.
     *
     * Протокол состоит из последовательности следующих событий: service, net, out, goal, return, eom.
     * События обозначают следующее:
     *
     * * service — подача (при этом игрок ударяет по мячу).service — всегда первое событие во входном файле.
     * После него могут следовать net, out, goal, return.
     *
     * * net — мяч ударяется о половину поля того игрока, который ударял по мячу последним, слишком много раз.
     * Игрок, который ударял по мячу последним, проигрывает розыгрыш. После этого события могут идти service или eom.
     *
     * * out — мяч уходит в аут. Игрок, который ударял по мячу последним, проигрывает розыгрыш.
     * После этого события могут идти service или eom.
     *
     * * goal — игрок, который ударял по мячу последним, забивает гол (т.,е. выигрывает розыгрыш).
     * Далее может быть service или eom.
     *
     * * return — игрок отбивает мяч, ударяя по нему (игроки ударяют по мячу по очереди).
     * Далее может быть net, out, goal, return.
     *
     * * eom — матч окончен. Это всегда последнее событие.
     *
     * Когда игрок выигрывает розыгрыш, ему начисляется очко. Когда игрок проигрывает розыгрыш, очко начисляется его
     * противнику. Подачи подаются по пять штук, т.,е. первые пять подач подаёт первый игрок, следующие пять — другой
     * и т.д. Полное количество подач может быть не кратным пяти, в таком случае последняя серия подач будет короче
     * пяти штук.
     *
     * Конечно, в реальном матче может произойти ситуация, которую невозможно описать этими событиями, но ваша
     * программа должна считать, что весь матч описывается данными во входном файле событиями.
     *
     * Входные данные
     * Во входном файле находится список событий. События расположены по одному на строке без пробелов.
     * Последовательность событий удовлетворяет всему, что было сказано выше; пустых строк во входном файле нет
     * (кроме, возможно, строк после события eom). Всего событий не более 50000.
     *
     * Выходные данные
     * В выходной файл выведите два числа: очки того, кто подавал первым, потом — очки его противника.
     *
     * @param protocol - массив строк, описывающий события
     * @return - строка, содержащая счет
     */
    public Score getScoreFromProtocol(String[] protocol) {
        int lastServiceOrdinal = 5;
        int firstPlayerScore = 0;
        int secondPlayerScore = 0;
        int serviceCounter = 0;
        for (String event : protocol) {
            Event currentEvent = Event.valueOf(event.toUpperCase(Locale.ROOT));
            switch (currentEvent) {
                case SERVICE:
                    if (serviceCounter % lastServiceOrdinal == 0) {
                        System.out.println("service counter -> " + serviceCounter + ", switch");
                        int temp = firstPlayerScore;
                        firstPlayerScore = secondPlayerScore;
                        secondPlayerScore = temp;
                    }
                    serviceCounter++;
                    break;
                case NET:
                case OUT:
                    secondPlayerScore++;
                    System.out.println(firstPlayerScore + " : " + secondPlayerScore);
                    break;
                case GOAL:
                    firstPlayerScore++;
                    System.out.println(firstPlayerScore + " : " + secondPlayerScore);
                    break;
                case RETURN:
                    break;
                case EOM:
                    return serviceCounter % lastServiceOrdinal == 0 ?
                            new Score(firstPlayerScore, secondPlayerScore) :
                            new Score(secondPlayerScore, firstPlayerScore);
            }
        }
        throw new RuntimeException("No EOM event");
    }

    private enum Event {
        SERVICE, NET, OUT, GOAL, RETURN, EOM
    }

    @Value
    public static class Score {
        int firstPlayerScore;
        int secondPlayerScore;
    }
}
