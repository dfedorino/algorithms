package com.dfedorino.rtasks.third_level.graphs.search.bfs;

import com.dfedorino.rtasks.third_level.graphs.Pair;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Lines {
    public Route getRoute(String[][] map) {
        Segment start = findSegmentWithMark("@", map);
        Segment finish = findSegmentWithMark("X", map);
        Map<Segment, List<Segment>> adjacencyMap = buildAdjacencyMap(map);
        Map<Segment, Integer> distanceMap = buildDistanceMap(start, finish, adjacencyMap);
        if (distanceMap == null) {
            return new Route();
        }
        return buildRoute(start, finish, map, adjacencyMap, distanceMap);
    }

    private Segment findSegmentWithMark(String mark, String[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i].equals(mark)) {
                    return new Segment(mark, new Pair<>(i, j));
                }
            }
        }
        throw new IllegalArgumentException("Mark not found");
    }

    private Map<Segment, List<Segment>> buildAdjacencyMap(String[][] map) {
        Map<Segment, List<Segment>> adjacencyMap = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                Segment current = new Segment(map[i][j], new Pair<>(j, i));
                List<Pair<Integer, Integer>> allAdjacentCoordinates = List.of(
                        new Pair<>(j, i - 1),
                        new Pair<>(j + 1, i),
                        new Pair<>(j, i + 1),
                        new Pair<>(j - 1, i)
                );
                List<Segment> validAdjacentSegments = allAdjacentCoordinates.stream()
                        .filter(coordinates -> areValid(coordinates, map))
                        .map(coordinates -> createSegment(coordinates, map))
                        .collect(Collectors.toList());
                adjacencyMap.put(current, validAdjacentSegments);
            }
        }
        return adjacencyMap;
    }

    private Segment createSegment(Pair<Integer, Integer> coordinates, String[][] map) {
        int j = coordinates.getA();
        int i = coordinates.getB();
        return new Segment(map[i][j], coordinates);
    }

    private boolean areValid(Pair<Integer, Integer> coordinates, String[][] map) {
        int j = coordinates.getA();
        int i = coordinates.getB();
        return isValid(i, map) & isValid(j, map);
    }

    private boolean isValid(int coordinate, String[][] map) {
        return coordinate >= 0 & coordinate < map.length;
    }

    private Map<Segment, Integer> buildDistanceMap(Segment start, Segment finish, Map<Segment, List<Segment>> adjacencyMap) {
        Map<Segment, Integer> distanceMap = new HashMap<>();
        Queue<Segment> toBeVisited = new ArrayDeque<>();
        toBeVisited.offer(finish);
        distanceMap.put(finish, 0);
        while (!toBeVisited.isEmpty()) {
            Segment current = toBeVisited.poll();
            List<Segment> adjacentToCurrent = adjacencyMap.get(current);
            for (Segment adjacent : adjacentToCurrent) {
                if (!adjacent.getMark().equals("O") && !distanceMap.containsKey(adjacent)) {
                    distanceMap.put(adjacent, distanceMap.get(current) + 1);
                    if (adjacent.equals(start)) {
                        return distanceMap;
                    }
                    toBeVisited.offer(adjacent);
                }
            }
        }
        return null;
    }

    private Route buildRoute(Segment start, Segment finish, String[][] map, Map<Segment, List<Segment>> adjacencyMap, Map<Segment, Integer> distanceMap) {
        String[][] stringRoute = getCopyOf(map);
        Segment current = start;
        while (!current.equals(finish)) {
            markRoute(map, stringRoute, current);
            List<Segment> adjacentToCurrent = adjacencyMap.get(current);
            for (Segment adjacent : adjacentToCurrent) {
                if (distanceMap.get(adjacent) < distanceMap.get(current)) {
                    current = adjacent;
                    break;
                }
            }
        }
        Route route = new Route();
        route.setFound(true);
        route.setRoute(stringRoute);
        return route;
    }

    private String[][] getCopyOf(String[][] map) {
        String[][] copy = new String[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, map.length);
        }
        return copy;
    }

    private void markRoute(String[][] map, String[][] stringRoute, Segment adjacent) {
        int y = adjacent.getCoordinates().getA();
        int x = adjacent.getCoordinates().getB();
        if (map[x][y].equals(".")) {
            stringRoute[x][y] = "+";
        }
    }

    @Data
    public static class Route {
        private boolean isFound;
        private String[][] route;
    }
}
