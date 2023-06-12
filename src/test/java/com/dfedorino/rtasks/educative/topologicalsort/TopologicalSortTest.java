package com.dfedorino.rtasks.educative.topologicalsort;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dfedorino.rtasks.educative.topologicalsort.TopologicalSortTest.CustomListAssert.*;

class TopologicalSortTest {
    private final TopologicalSort topologicalSort = new TopologicalSort();

    @Test
    void shouldSortInAnyExpectedOrderExample1() {
        int vertices = 4;
        int[][] edges = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};

        List<List<Integer>> possibleResults = List.of(
                List.of(3, 2, 1, 0),
                List.of(3, 2, 0, 1)
        );

        List<Integer> actualResult = topologicalSort.sort(vertices, edges);
        assertThat(actualResult).containsExactlyElementsOfAny(possibleResults);
    }

    @Test
    void shouldSortInAnyExpectedOrderExample2() {
        int vertices = 5;
        int[][] edges = {{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}};

        List<List<Integer>> possibleResults = List.of(
                List.of(4, 2, 3, 0, 1),
                List.of(4, 3, 2, 0, 1),
                List.of(4, 3, 2, 1, 0),
                List.of(4, 2, 3, 1, 0),
                List.of(4, 2, 0, 3, 1)
        );

        List<Integer> actualResult = topologicalSort.sort(vertices, edges);
        assertThat(actualResult).containsExactlyElementsOfAny(possibleResults);
    }

    @Test
    void shouldSortInAnyExpectedOrderExample3() {
        int vertices = 7;
        int[][] edges = {{6, 4}, {6, 2}, {5, 3}, {5, 4}, {3, 0}, {3, 1}, {3, 2}, {4, 1}};

        List<List<Integer>> possibleResults = List.of(
                List.of(5, 6, 3, 4, 0, 1, 2),
                List.of(6, 5, 3, 4, 0, 1, 2),
                List.of(5, 6, 4, 3, 0, 2, 1),
                List.of(6, 5, 4, 3, 0, 1, 2),
                List.of(5, 6, 3, 4, 0, 2, 1),
                List.of(5, 6, 3, 4, 1, 2, 0)
                // There are other valid topological ordering of the graph too.
        );

        List<Integer> actualResult = topologicalSort.sort(vertices, edges);
        assertThat(actualResult).containsExactlyElementsOfAny(possibleResults);
    }

    public static class CustomListAssert<ELEMENT> extends ListAssert<ELEMENT> {
        public CustomListAssert(List<ELEMENT> actual) {
            super(actual);
        }

        public static <ELEMENT> CustomListAssert<ELEMENT> assertThat(List<ELEMENT> actual) {
            return new CustomListAssert<>(actual);
        }

        public CustomListAssert<ELEMENT> containsExactlyElementsOfAny(List<List<ELEMENT>> possibleResults) {
            if (possibleResults.stream().noneMatch(actual::equals)) {
                String errorMessage = "Expected actual: %s to have same elements in the same order as any of the expected: %s";
                failWithMessage(errorMessage, actual, possibleResults);
            }
            return this;
        }
    }
}