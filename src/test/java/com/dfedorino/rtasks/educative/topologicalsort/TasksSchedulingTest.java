package com.dfedorino.rtasks.educative.topologicalsort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TasksSchedulingTest {
    private final TasksScheduling tasksScheduling = new TasksScheduling();

    @Test
    void shouldReturnTrueWhenNoCyclicDependencies() {
        int tasks = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 2}
        };
        assertThat(tasksScheduling.isSchedulingPossible(tasks, prerequisites)).isTrue();
    }

    @Test
    void shouldReturnFalseWhenCyclicDependency() {
        int tasks = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        assertThat(tasksScheduling.isSchedulingPossible(tasks, prerequisites)).isFalse();
    }

    @Test
    void shouldReturnTrueWhenExample3() {
        int tasks = 6;
        int[][] prerequisites = {
                {2, 5},
                {0, 5},
                {0, 4},
                {1, 4},
                {3, 2},
                {1, 3}
        };
        assertThat(tasksScheduling.isSchedulingPossible(tasks, prerequisites)).isTrue();
    }
}