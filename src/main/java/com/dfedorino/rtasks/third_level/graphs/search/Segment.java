package com.dfedorino.rtasks.third_level.graphs.search;

import com.dfedorino.rtasks.third_level.graphs.Pair;
import lombok.Value;

@Value
public class Segment {
    private String mark;
    private Pair<Integer, Integer> coordinates;

    public boolean isWall() {
        return mark.equals("#");
    }

    @Override
    public String toString() {
        return "('" + mark + "', [" + coordinates.getA() + ", " + coordinates.getB() + "])";
    }
}
