package com.dfedorino.rtasks.first_level;

public class TreasureFinder {
    /**
     * Капитан Флинт зарыл клад на Острове сокровищ. Он оставил описание, как найти клад.
     * Описание состоит из строк вида: "North 5", где  слово – одно из "North", "South", "East", "West", – задает
     * направление движения, а  число – количество шагов, которое необходимо пройти в этом направлении.
     * <p>
     * Напишите программу, которая по описанию пути к кладу определяет точные координаты клада, считая, что начало
     * координат находится в начале пути, ось OX направлена на восток, ось OY – на север.
     * <p>
     * Входные данные
     * На вход подается последовательность строк указанного формата. Гарантируется, что числа не превосходят
     * 10^8
     * <p>
     * Выходные данные
     * Необходимо вывести  координаты клада – два целых числа через пробел. Гарантируется, что эти числа не
     * превосходят 10^8.
     *
     * @param guide - строка с направлениями и шагами
     * @return строка с координатами, где первое значение - х, второе - у
     */
    public String getCoordinates(String guide) {
        String anyWhitespace = "\\s";
        String[] directionsAndSteps = guide.split(anyWhitespace);
        int x = 0;
        int y = 0;
        for (int wordIndex = 0; wordIndex < directionsAndSteps.length - 1; wordIndex += 2) {
            String direction = directionsAndSteps[wordIndex];
            int steps = Integer.parseInt(directionsAndSteps[wordIndex + 1]);
            switch (direction) {
                case "North":
                    y += steps;
                    break;
                case "East":
                    x += steps;
                    break;
                case "South":
                    y -= steps;
                    break;
                case "West":
                    x -= steps;
                    break;
            }
        }
        return x + " " + y;
    }
}
