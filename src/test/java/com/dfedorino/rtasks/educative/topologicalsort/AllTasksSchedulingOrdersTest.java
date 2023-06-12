package com.dfedorino.rtasks.educative.topologicalsort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AllTasksSchedulingOrdersTest {
    private final AllTasksSchedulingOrders allTasksSchedulingOrders = new AllTasksSchedulingOrders();

    @Test
    void shouldReturnAllOrdersExample1() {
        int tasks = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}};
        List<List<Integer>> expectedOrders = List.of(
                List.of(0, 1, 2)
        );
        assertThat(allTasksSchedulingOrders.findOrders(tasks, prerequisites))
                .containsExactlyInAnyOrderElementsOf(expectedOrders);
    }

    @Test
    void shouldReturnAllOrdersExample2() {
        int tasks = 4;
        int[][] prerequisites = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        List<List<Integer>> expectedOrders = List.of(
                List.of(3, 2, 0, 1),
                List.of(3, 2, 1, 0)
        );
        assertThat(allTasksSchedulingOrders.findOrders(tasks, prerequisites))
                .containsExactlyInAnyOrderElementsOf(expectedOrders);
    }

    @Test
    void shouldReturnAllOrdersExample3() {
        int tasks = 6;
        int[][] prerequisites = {{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}};
        List<List<Integer>> expectedOrders = List.of(
                List.of(0, 1, 4, 3, 2, 5),
                List.of(0, 1, 3, 4, 2, 5),
                List.of(0, 1, 3, 2, 4, 5),
                List.of(0, 1, 3, 2, 5, 4),
                List.of(1, 0, 3, 4, 2, 5),
                List.of(1, 0, 3, 2, 4, 5),
                List.of(1, 0, 3, 2, 5, 4),
                List.of(1, 0, 4, 3, 2, 5),
                List.of(1, 3, 0, 2, 4, 5),
                List.of(1, 3, 0, 2, 5, 4),
                List.of(1, 3, 0, 4, 2, 5),
                List.of(1, 3, 2, 0, 5, 4),
                List.of(1, 3, 2, 0, 4, 5)
        );
        assertThat(allTasksSchedulingOrders.findOrders(tasks, prerequisites))
                .containsExactlyInAnyOrderElementsOf(expectedOrders);
    }
}