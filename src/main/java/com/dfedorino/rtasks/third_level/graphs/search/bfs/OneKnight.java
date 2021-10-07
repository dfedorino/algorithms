package com.dfedorino.rtasks.third_level.graphs.search.bfs;

import com.dfedorino.rtasks.third_level.graphs.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class OneKnight {
    public List<Pair<Integer, Integer>> getShortestRoute(int fieldSize, Pair<Integer, Integer> start, Pair<Integer, Integer> finish) {
        return getRouteFromFinishToStart(fieldSize, finish, start);
    }

    private List<Pair<Integer, Integer>> getRouteFromFinishToStart(int fieldSize, Pair<Integer, Integer> start, Pair<Integer, Integer> finish) {
        if (start.equals(finish)) {
            return List.of(start);
        }
        Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> adjacencyList = new HashMap<>();
        Map<Pair<Integer, Integer>, Integer> dist = new HashMap<>();
        populateAdjacencyListAndDistance(fieldSize, start, finish, adjacencyList, dist);
        List<Pair<Integer, Integer>> route = new ArrayList<>();
        Pair<Integer, Integer> currentPosition = finish;
        route.add(currentPosition);
        while(!currentPosition.equals(start)) {
            List<Pair<Integer, Integer>> adjacentToCurrent = adjacencyList.get(currentPosition);
            for (Pair<Integer, Integer> adjacentPosition: adjacentToCurrent) {
                if (dist.get(adjacentPosition) < dist.get(currentPosition)) {
                    route.add(adjacentPosition);
                    currentPosition = adjacentPosition;
                    break;
                }
            }
        }
        return route;
    }

    private void populateAdjacencyListAndDistance(
            int fieldSize,
            Pair<Integer, Integer> start,
            Pair<Integer, Integer> finish,
            Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> adjacencyList,
            Map<Pair<Integer, Integer>, Integer> dist) {

        Queue<Pair<Integer, Integer>> toBeVisited = new ArrayDeque<>();
        dist.put(start, 0);
        toBeVisited.offer(start);
        while(!toBeVisited.isEmpty()) {
            Pair<Integer, Integer> currentPosition = toBeVisited.poll();
            List<Pair<Integer, Integer>> adjacentToCurrent = computeAdjacentToCurrent(currentPosition, fieldSize);
            adjacencyList.put(currentPosition, adjacentToCurrent);
            if (currentPosition.equals(finish)) {
                break;
            }
            for (Pair<Integer, Integer> adjacentPosition : adjacentToCurrent) {
                if (dist.get(adjacentPosition) == null) {
                    toBeVisited.offer(adjacentPosition);
                    dist.put(adjacentPosition, dist.get(currentPosition) + 1);
                }
            }
        }
    }

    private List<Pair<Integer, Integer>> computeAdjacentToCurrent(Pair<Integer, Integer> currentPosition, int fieldSize) {
        int x = currentPosition.getA();
        int y = currentPosition.getB();

        List<Pair<Integer, Integer>> allPossiblePositions = List.of(
                // I:
                new Pair<>(x - 2, y - 1),
                new Pair<>(x - 1, y - 2),

                //II:
                new Pair<>(x + 2, y - 1),
                new Pair<>(x + 1, y - 2),

                //III:
                new Pair<>(x + 2, y + 1),
                new Pair<>(x + 1, y + 2),

                // IV:
                new Pair<>(x - 2, y + 1),
                new Pair<>(x - 1, y + 2)
        );

        return allPossiblePositions.stream()
                .filter(position -> isOnBoard(position, fieldSize))
                .collect(Collectors.toList());
    }

    private boolean isOnBoard(Pair<Integer, Integer> position, int fieldSize) {
        int x = position.getA();
        int y = position.getB();
        return x > 0 & x <= fieldSize & y > 0 & y <= fieldSize;
    }
}
