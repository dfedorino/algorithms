package com.dfedorino.rtasks.third_level.graphs.search.bfs;

import com.dfedorino.rtasks.third_level.graphs.Pair;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OneKnightTest {
    private final OneKnight app = new OneKnight();
    @Test
    public void testGetShortestRoute() {
        int fieldSize = 5;
        Pair<Integer, Integer> start = new Pair<>(3, 3);
        Pair<Integer, Integer> finish = new Pair<>(5, 1);
        List<Pair<Integer, Integer>> route = app.getShortestRoute(fieldSize, start, finish);
        System.out.println(">> route:");
        route.forEach(System.out::println);
        assertThat(route).hasSize(5);
    }
}