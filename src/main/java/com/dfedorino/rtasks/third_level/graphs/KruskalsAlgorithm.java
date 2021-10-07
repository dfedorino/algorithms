package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsAlgorithm {

    public List<Edge> buildSpanningTree(List<Edge> edges) {
        // sort all the edges according to their weight
        Queue<Edge> sortedEdges = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        sortedEdges.addAll(edges);
        List<Edge> spanningTree = new ArrayList<>();
        // add them to a spanning tree:
            // if current edge will cause a loop in a spanning tree - skip
            // else - add to spanning tree
        return null;
    }
}
