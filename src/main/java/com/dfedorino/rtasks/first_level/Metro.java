package com.dfedorino.rtasks.first_level;

public class Metro {
    /**
     * Витя работает недалеко от одной из станций кольцевой линии Московского метро, а живет рядом с другой станцией
     * той же линии. Требуется выяснить, мимо какого наименьшего количества промежуточных станций необходимо проехать
     * Вите по кольцу, чтобы добраться с работы домой.
     * <p>
     * Входные данные
     * Станции пронумерованы подряд натуральными числами 1, 2, 3, …, N (1-я станция – соседняя с N-й),
     * N не превосходит 100.
     * <p>
     * Вводятся три числа: сначала N – общее количество станций кольцевой линии, а затем
     * i и j – номера станции, на которой Витя садится, и станции, на которой он должен выйти. Числа i и j
     * не совпадают. Все числа разделены пробелом.
     * <p>
     * Выходные данные
     * Требуется выдать минимальное количество промежуточных станций (не считая станции посадки и высадки),
     * которые необходимо проехать Вите.
     *
     * @param allStations - количество станций кольцевой линии
     * @param fromOrdinal - номер станции, на которой Витя садится
     * @param toOrdinal   - номер станции, на которой он должен выйти
     * @return минимальное кол-во промежуточных станций
     */
    public int getMinStations(int allStations, int fromOrdinal, int toOrdinal) {
        int stationCounter = 0;
        int nextStationIndex = fromOrdinal + 1;
        int previousStationIndex = allStations - fromOrdinal + 1;
        while (nextStationIndex != previousStationIndex) {
            System.out.println("next station index -> " + nextStationIndex);
            System.out.println("previous station index -> " + previousStationIndex);
            if (nextStationIndex++ == toOrdinal || previousStationIndex-- == toOrdinal) {
                return stationCounter;
            }
            stationCounter++;
        }
        return stationCounter;
    }
}
