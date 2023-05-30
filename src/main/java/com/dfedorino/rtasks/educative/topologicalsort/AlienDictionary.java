package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class AlienDictionary {
    /**
     * There is a dictionary containing words from an alien language for which we don’t know the ordering of the
     * letters. Write a method to find the correct order of the letters in the alien language. It is given that the
     * input is a valid dictionary and there exists an ordering among its letters.
     * <p>
     *
     * Example 1:
     * Input: Words: ["ba", "bc", "ac", "cab"]
     * Output: bac
     * Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
     * from the given words we can conclude the following ordering among its characters:
     * <p>
     *
     * 1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
     * 2. From "bc" and "ac", we can conclude that 'b' comes before 'a'
     * <p>
     *
     * From the above two points, we can conclude that the correct character order is: "bac"
     * <p>
     *
     * Example 2:
     * Input: Words: ["cab", "aaa", "aab"]
     * Output: cab
     * Explanation: From the given words we can conclude the following ordering among its characters:
     * <p>
     *
     * 1. From "cab" and "aaa", we can conclude that 'c' comes before 'a'.
     * 2. From "aaa" and "aab", we can conclude that 'a' comes before 'b'
     * <p>
     *
     * From the above two points, we can conclude that the correct character order is: "cab"
     * <p>
     *
     * Example 3:
     * Input: Words: ["ywx", "wz", "xww", "xz", "zyy", "zwz"]
     * Output: ywxz
     * Explanation: From the given words we can conclude the following ordering among its characters:
     * <p>
     *
     * 1. From "ywx" and "wz", we can conclude that 'y' comes before 'w'.
     * 2. From "wz" and "xww", we can conclude that 'w' comes before 'x'.
     * 3. From "xww" and "xz", we can conclude that 'w' comes before 'z'
     * 4. From "xz" and "zyy", we can conclude that 'x' comes before 'z'
     * 5. From "zyy" and "zwz", we can conclude that 'y' comes before 'w'
     * <p>
     *
     * From the above five points, we can conclude that the correct character order is: "ywxz"
     */
    public String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();

        // convert the words into edges + count number of unique characters
        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];
            for (int j = 0; j < left.length() && j < right.length(); j++) {
                char leftChar = left.charAt(j);
                char rightChar = right.charAt(j);

                if (leftChar != rightChar) {
                    inDegree.put(leftChar, inDegree.getOrDefault(leftChar, 0));
                    Set<Character> children = graph.getOrDefault(leftChar, new HashSet<>());
                    if (!children.contains(rightChar)) {
                        inDegree.put(rightChar, inDegree.getOrDefault(rightChar, 0) + 1);
                        children.add(rightChar);
                        graph.put(leftChar, children);
                    }
                    break;
                }
            }
        }

        // sort the vertices topologically to find the right order
        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> characterInDegree : inDegree.entrySet()) {
            if (characterInDegree.getValue() == 0) {
                queue.offer(characterInDegree.getKey());
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            Character character = queue.poll();
            order.append(character);
            Set<Character> children = graph.getOrDefault(character, Collections.emptySet());
            for (Character child : children) {
                inDegree.computeIfPresent(child, (k, v) -> v - 1);
                if (inDegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        return order.toString();
    }
}
