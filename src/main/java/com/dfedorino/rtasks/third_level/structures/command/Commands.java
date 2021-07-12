package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.function.Function;

public class Commands<T extends Collection<?>> {
    public Command<T> command(Function<T, Integer> collectionPopMethod) {
        return (T collection) -> new CommandResult(String.valueOf(collectionPopMethod.apply(collection)));
    }
}
