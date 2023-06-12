package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class TasksScheduling {
    /**
     * There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks which need to be
     * completed before it can be scheduled. Given the number of tasks and a list of prerequisite pairs, find out if
     * it is possible to schedule all the tasks.
     * <p>
     *
     * Example 1:
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2]
     * Output: true
     * Explanation: To execute task '1', task '0' needs to finish first. Similarly, task '1' needs
     * to finish before '2' can be scheduled. One possible scheduling of tasks is: [0, 1, 2]
     * <p>
     *
     * Example 2:
     * Input: Tasks=3, Prerequisites=[0, 1], [1, 2], [2, 0]
     * Output: false
     * Explanation: The tasks have a cyclic dependency, therefore they cannot be scheduled.
     * <p>
     *
     * Example 3:
     * Input: Tasks=6, Prerequisites=[2, 5], [0, 5], [0, 4], [1, 4], [3, 2], [1, 3]
     * Output: true
     * Explanation: A possible scheduling of tasks is: [0 1 4 3 2 5]
     **/
    public boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        // the main problem for me was to understand, how do we find a cyclic dependency

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
                sources.add(i);
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

        return sorted.size() == tasks;
    }
}
