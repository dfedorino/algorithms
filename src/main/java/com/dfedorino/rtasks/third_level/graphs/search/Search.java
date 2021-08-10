package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.List;

public interface Search {
    List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList);
}
