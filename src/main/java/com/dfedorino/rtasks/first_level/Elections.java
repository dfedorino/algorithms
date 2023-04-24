package com.dfedorino.rtasks.first_level;

import java.util.ArrayList;
import java.util.List;

public class Elections {
    public List<Integer> getPartiesOrdinals(int parties, int bulletins, String[] results) {
        List<Integer> partiesOrdinals = new ArrayList<>();
        int relevantBulletinsAltogether = 0;
        int[] partiesVotes = new int[parties];
        for(String result : results) {
            for (int charIndex = 0; charIndex < parties; charIndex++) {
                if (result.charAt(charIndex) == '+') {
                    partiesVotes[charIndex]++;
                    relevantBulletinsAltogether++;
                }
            }
        }
        double threshold = relevantBulletinsAltogether * 0.07;
        for (int partyIndex = 0; partyIndex < parties; partyIndex++) {
            if (partiesVotes[partyIndex] > threshold) {
                partiesOrdinals.add(partyIndex + 1);
            }
        }
        return partiesOrdinals;
    }
}
