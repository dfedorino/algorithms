package com.dfedorino.rtasks.third_level.structures.command;

import lombok.Value;

import java.util.Collection;
import java.util.List;

@Value
public class Script<T extends Collection<?>> {
    private List<Command<T>> commands;
}
