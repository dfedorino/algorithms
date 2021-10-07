package com.dfedorino.rtasks.third_level.graphs;

import lombok.Value;

@Value
public class Edge {
    private final int firstVertex;
    private final int secondVertex;
    private final int weight;
}