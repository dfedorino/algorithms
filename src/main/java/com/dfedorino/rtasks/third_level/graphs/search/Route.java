package com.dfedorino.rtasks.third_level.graphs.search;

import lombok.Value;

import java.util.List;

@Value
public class Route {
    private List<Integer> vertexes;

    public int getLength() {
        return vertexes.size();
    }

    public void addVertex(int vertex) {
        vertexes.add(vertex);
    }
}
