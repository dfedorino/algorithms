package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class TasksSchedulingOrder {

    /**
     * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be
     * completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, write a
     * method to find the ordering of tasks we should pick to finish all tasks.
     * <p>
     *
     * Example 1:
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: [0, 1, 2]
     * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
     * to finish before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]
     * <p>
     *
     * Example 2:
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: [0, 1, 2]
     * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
     * to finish before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]
     * <p>
     *
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: [0, 1, 2]
     * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
     * to finish before '2' can be scheduled. A possible scheduling of tasks is: [0, 1, 2]
     */
    public List<Integer> findOrder(int tasks, int[][] prerequisites) {
        int[] inDegrees = new int[tasks];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[1]]++;
            List<Integer> children = graph.getOrDefault(prerequisite[0], new ArrayList<>());
            children.add(prerequisite[1]);
            graph.put(prerequisite[0], children);
        }

        Queue<Integer> sources = new ArrayDeque<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                sources.offer(i);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sorted.add(vertex);
            List<Integer> children = graph.getOrDefault(vertex, Collections.emptyList());
            for (int child : children) {
                if (--inDegrees[child] == 0) {
                    sources.offer(child);
                }
            }
        }

        return sorted.size() == tasks ? sorted : Collections.emptyList();
    }
}
