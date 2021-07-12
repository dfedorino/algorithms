package com.dfedorino.rtasks.third_level.structures.command;

import lombok.Value;

import java.util.List;

@Value
public class Protocol<T> {
    private List<T> records;
}
