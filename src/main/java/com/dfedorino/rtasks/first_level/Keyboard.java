package com.dfedorino.rtasks.first_level;

public class Keyboard {
    public String check(int[] resist, int[] sequence) {
        for (int buttonNumber : sequence) {
            resist[buttonNumber - 1]--;
        }
        StringBuilder result = new StringBuilder();
        for (int resistValue : resist) {
            result.append(resistValue < 0)
                    .append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
