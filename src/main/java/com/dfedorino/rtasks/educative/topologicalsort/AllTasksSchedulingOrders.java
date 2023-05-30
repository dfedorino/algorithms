package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class AllTasksSchedulingOrders {

    /**
     * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be
     * completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a
     * method to print all possible ordering of tasks meeting all prerequisites.
     * <p>
     *
     * Example 1:
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: [0, 1, 2]
     * Explanation: There is only possible ordering of the tasks.
     * <p>
     *
     * Example 2:
     * Input: Tasks=4, Prerequisites=[3, 2], [3, 0], [2, 0], [2, 1]
     * Output:
     * 1) [3, 2, 0, 1]
     * 2) [3, 2, 1, 0]
     * Explanation: There are two possible orderings of the tasks meeting all prerequisites.
     * <p>
     *
     * Example 3:
     * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
     * Output:
     * 1) [0, 1, 4, 3, 2, 5]
     * 2) [0, 1, 3, 4, 2, 5]
     * 3) [0, 1, 3, 2, 4, 5]
     * 4) [0, 1, 3, 2, 5, 4]
     * 5) [1, 0, 3, 4, 2, 5]
     * 6) [1, 0, 3, 2, 4, 5]
     * 7) [1, 0, 3, 2, 5, 4]
     * 8) [1, 0, 4, 3, 2, 5]
     * 9) [1, 3, 0, 2, 4, 5]
     * 10) [1, 3, 0, 2, 5, 4]
     * 11) [1, 3, 0, 4, 2, 5]
     * 12) [1, 3, 2, 0, 5, 4]
     * 13) [1, 3, 2, 0, 4, 5]
     */
    public List<List<Integer>> findOrders(int tasks, int[][] prerequisites) {
        int[] inDegrees = new int[tasks];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] p : prerequisites) {
            inDegrees[p[1]]++;
            List<Integer> children = graph.getOrDefault(p[0], new ArrayList<>());
            children.add(p[1]);
            graph.put(p[0], children);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        return fillInResult(inDegrees, graph, queue);
    }

    private List<List<Integer>> fillInResult(int[] inDegrees, Map<Integer, List<Integer>> graph, Queue<Integer> queue) {
        // TODO: 30.05.2023 implement!
        return null;
    }
}
