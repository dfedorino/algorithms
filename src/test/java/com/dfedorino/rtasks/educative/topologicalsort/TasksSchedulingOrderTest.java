package com.dfedorino.rtasks.educative.topologicalsort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TasksSchedulingOrderTest {
    private final TasksSchedulingOrder tasksSchedulingOrder = new TasksSchedulingOrder();

    @Test
    void shouldReturnSortedTasksExample1() {
        int tasks = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 2}
        };

        assertThat(tasksSchedulingOrder.findOrder(tasks, prerequisites)).containsExactlyElementsOf(List.of(0, 1, 2));
    }


    @Test
    void shouldReturnEmptyListExample2() {
        int tasks = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        assertThat(tasksSchedulingOrder.findOrder(tasks, prerequisites)).isEmpty();
    }

    @Test
    void shouldReturnSortedTasksExample3() {
        int tasks = 6;
        int[][] prerequisites = {
                {2, 5},
                {0, 5},
                {0, 4},
                {1, 4},
                {3, 2},
                {1, 3}
        };

        List<Integer> expectedOrder = List.of(0, 1, 4, 3, 2, 5);
        assertThat(tasksSchedulingOrder.findOrder(tasks, prerequisites)).containsExactlyElementsOf(expectedOrder);
    }
}