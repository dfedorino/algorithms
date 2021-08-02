package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.function.BiFunction;

public class CommandImpl<T extends Collection<Integer>> implements Command<T> {
    private final Integer value;
    private final BiFunction<Integer, T, CommandResult> operation;

    public CommandImpl(Integer value, BiFunction<Integer, T, CommandResult> operation) {
        this.value = value;
        this.operation = operation;
    }

    public CommandResult execute(T collection) {
        return operation.apply(value, collection);
    }
}
