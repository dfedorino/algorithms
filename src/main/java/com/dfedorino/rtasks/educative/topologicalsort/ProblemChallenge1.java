package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class ProblemChallenge1 {
    /**
     * Given a sequence originalSeq and an array of sequences, write a method to find if originalSeq can be uniquely
     * reconstructed from the array of sequences.
     *
     * Unique reconstruction means that we need to find if originalSeq is the only sequence such that all sequences in
     * the array are subsequences of it.
     *
     * Example 1:
     * Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [3, 4]]
     * Output: true
     * Explanation: The sequences [1, 2], [2, 3], and [3, 4] can uniquely reconstruct
     * [1, 2, 3, 4], in other words, all the given sequences uniquely define the order of numbers
     * in the 'originalSeq'.
     *
     * Example 2:
     * Input: originalSeq: [1, 2, 3, 4], seqs: [[1, 2], [2, 3], [2, 4]]
     * Output: false
     * Explanation: The sequences [1, 2], [2, 3], and [2, 4] cannot uniquely reconstruct
     * [1, 2, 3, 4]. There are two possible sequences we can construct from the given sequences:
     * 1) [1, 2, 3, 4]
     * 2) [1, 2, 4, 3]
     *
     * Example 3:
     * Input: originalSeq: [3, 1, 4, 2, 5], seqs: [[3, 1, 5], [1, 4, 2, 5]]
     * Output: true
     * Explanation: The sequences [3, 1, 5] and [1, 4, 2, 5] can uniquely reconstruct
     * [3, 1, 4, 2, 5].
     */

    public boolean canConstruct(int[] originalSeq, int[][] seqs) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                inDegree.put(seq[i - 1], inDegree.getOrDefault(seq[i - 1], 0));
                inDegree.put(seq[i], inDegree.getOrDefault(seq[i], 0) + 1);
                List<Integer> children = graph.getOrDefault(seq[i - 1], new ArrayList<>());
                children.add(seq[i]);
                graph.put(seq[i - 1], children);
            }
        }

        Queue<Integer> sources = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                sources.offer(e.getKey());
            }
        }

        int i = 0;
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            // equality with original sequence check
            if (vertex != originalSeq[i++]) {
                return false;
            }
            int newSources = 0;
            List<Integer> children = graph.getOrDefault(vertex, Collections.emptyList());
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.offer(child);
                    newSources++;
                }
            }
            // if we have more than 1 sources on each level,
            // then the original sequence cannot be uniquely reconstructed
            if (newSources > 1) {
                return false;
            }
        }

        return true;
    }
}
