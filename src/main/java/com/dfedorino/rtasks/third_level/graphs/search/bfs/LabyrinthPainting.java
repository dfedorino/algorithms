package com.dfedorino.rtasks.third_level.graphs.search.bfs;

import com.dfedorino.rtasks.third_level.graphs.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LabyrinthPainting {
    public int countTotalAreaOfWalls(String[][] labyrinth) {
        String[][] surroundedLabyrinth = surroundWithWall(labyrinth);
        int wallCounter = 0;
        Queue<Segment> toBeVisited = new ArrayDeque<>(labyrinth.length * labyrinth.length);
        Set<Segment> visited = new HashSet<>();
        Pair<Integer, Integer> startCoordinates = new Pair<>(1, 1);
        Segment start = new Segment(surroundedLabyrinth[1][1], startCoordinates);
        toBeVisited.offer(start);
        while(!toBeVisited.isEmpty()) {
            Segment current = toBeVisited.poll();
            if (!visited.contains(current)) {
                List<Segment> adjacentToCurrent = getAdjacentToCurrent(current, surroundedLabyrinth);
                for (Segment adjacent : adjacentToCurrent) {
                    if (adjacent.isWall()) {
                        wallCounter++;
                    } else {
                        if (!visited.contains(adjacent)) {
                            toBeVisited.offer(adjacent);
                        }
                    }
                }
            }
            visited.add(current);
        }
        int wallArea = 3 * 3;
        return (wallCounter - 4) * wallArea;
    }

    private List<Segment> getAdjacentToCurrent(Segment current, String[][] surroundedLabyrinth) {
        int x = current.getCoordinates().getA();
        int y = current.getCoordinates().getB();
        return List.of(
                new Segment(surroundedLabyrinth[x][y - 1], new Pair<>(x, y - 1)),
                new Segment(surroundedLabyrinth[x + 1][y], new Pair<>(x + 1, y)),
                new Segment(surroundedLabyrinth[x][y + 1], new Pair<>(x, y + 1)),
                new Segment(surroundedLabyrinth[x - 1][y], new Pair<>(x - 1, y))
        );
    }

    private String[][] surroundWithWall(String[][] labyrinth) {
        String[][] surroundedLabyrinth = new String[labyrinth.length + 2][labyrinth.length + 2];
        for (int i = 0; i < surroundedLabyrinth.length; i++) {
            for (int j = 0; j < surroundedLabyrinth.length; j++) {
                if (i == 0 || j == 0 || i == surroundedLabyrinth.length - 1 || j == surroundedLabyrinth.length - 1) {
                    surroundedLabyrinth[i][j] = "#";
                } else {
                    surroundedLabyrinth[i][j] = labyrinth[i - 1][j - 1];
                }
            }
        }
        return surroundedLabyrinth;
    }
}
