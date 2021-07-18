package com.dfedorino.rtasks.third_level.graphs;

import lombok.Value;

@Value
public class Pair<T, U> {
    private T a;
    private U b;
}
