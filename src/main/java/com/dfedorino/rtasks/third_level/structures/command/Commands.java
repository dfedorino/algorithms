package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Commands<T extends Collection<?>> {
    public Command<T> command(Function<T, Integer> collectionPopMethod) {
        return (T collection) -> new CommandResult(String.valueOf(collectionPopMethod.apply(collection)));
    }

    public Command<T> pushCommand(String commandString, BiConsumer<T, Integer> collectionMethod) {
        return (collection) -> {
            Integer data = Integer.parseInt(commandString.split(" ")[1]);
            collectionMethod.accept(collection, data);
            return new CommandResult("ok");
        };
    }
}
