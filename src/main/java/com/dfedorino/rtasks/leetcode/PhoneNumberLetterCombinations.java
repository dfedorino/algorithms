package com.dfedorino.rtasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinations {
    private final Map<Character, List<String>> digitAndLettersMap;

    public PhoneNumberLetterCombinations() {
        digitAndLettersMap = new HashMap<>();
        digitAndLettersMap.put('2', List.of("a", "b", "c"));
        digitAndLettersMap.put('3', List.of("d", "e", "f"));
        digitAndLettersMap.put('4', List.of("g", "h", "i"));
        digitAndLettersMap.put('5', List.of("j", "k", "l"));
        digitAndLettersMap.put('6', List.of("m", "n", "o"));
        digitAndLettersMap.put('7', List.of("p", "q", "r", "s"));
        digitAndLettersMap.put('8', List.of("t", "u", "v"));
        digitAndLettersMap.put('9', List.of("w", "x", "y", "z"));
    }
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
     * that the number could represent. Return the answer in any order.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     * 1()     2(abc) 3(def)
     * 4(ghi)  5(jkl) 6(mno)
     * 7(pqrs) 8(tuv) 9(wxyz)
     * *()     0( )   #()
     *
     * @param digits - a string containing digits from 2-9 inclusive
     * @return a list with all possible letter combinations that the number could represent
     */
    public List<String> letterCombinations(String digits) {
        int index = 0;
        return letterCombinations(index, digits);
    }

    private List<String> letterCombinations(int index, String digits) {
        if (index == digits.length()) {
            return Collections.emptyList();
        } else {
            List<String> previousCombinations = letterCombinations(index + 1, digits);
            List<String> currentDigitLetters = digitAndLettersMap.get(digits.charAt(index));
            if (previousCombinations.isEmpty()) {
                return Collections.unmodifiableList(currentDigitLetters);
            } else {
                List<String> currentCombinations = new ArrayList<>();
                for (String letter : currentDigitLetters) {
                    for (String combination : previousCombinations) {
                        currentCombinations.add(letter + combination);
                    }
                }
                return currentCombinations;
            }
        }
    }
}
