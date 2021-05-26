package com.dfedorino.rtasks.second_level;

public class ExplosionHazard {
    public int getNumberOfSafeStacks(int containers) {
        /* 1.  разбиваем задачу на простейшие подзадачи:
        1.1 если контейнеров 0, значит безопасных вариантов хранения тоже 0;
        1.2 если контейнер 1, значит безопасных вариантов хранения 2: [A, B];
        1.3 если контейнеров 2, значит безопасных вариантов хранения 3: [A, B], [B, A] и [B, B]
        1.4 если контейнеров 3, значит возможны следующие варианты:
            [..., A] - для такой комбинации предпоследний контейнер будет только B, а перед ним
                       все комбинации для длины 1;
            [..., B] - для такой комбинации валидны все безопасные варианты хранения для длины 2;
        1.5 формула вычисления для n контейнеров: n = (n - 2) + (n - 1);
        2.  каковы самые маленькие входные данные для вычисления простейшей подзадачи:
        2.1 f(0) == 0; f(1) == 2; f(2) == 3, все остальные контейнеры вычисляются по формуле выше */
        int[] stacks = new int[containers + 1];
        for (int numberOfContainers = 1; numberOfContainers < stacks.length; numberOfContainers++) {
            switch (numberOfContainers) {
                case 1:
                    stacks[1] = 2;
                    break;
                case 2:
                    stacks[2] = 3;
                    break;
                default:
                    int previousStacks = stacks[numberOfContainers - 1];
                    int beforePreviousStacks = stacks[numberOfContainers - 2];
                    stacks[numberOfContainers] = previousStacks + beforePreviousStacks;
            }
        }
        return stacks[containers];
    }
}
