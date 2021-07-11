package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class BaseCommandBuilder<T extends Collection<?>> implements CommandBuilder<T>{
    private final List<String> commands;

    public BaseCommandBuilder(List<String> commands) {
        this.commands = commands;
    }

    @Override
    public List<Command<T>> buildCommands() {
        return commands.stream()
                .map(this::buildCommand)
                .collect(Collectors.toList());
    }

    public abstract Command<T> buildCommand(String commandString);

    protected static <T extends Collection<?>> Command<T> pushCommand(String commandString, Consumer<Integer> collectionMethod) {
        return () -> {
            Integer data = Integer.parseInt(commandString.split(" ")[1]);
            collectionMethod.accept(data);
            return new CommandResult("ok");
        };
    }

    protected static <T extends Collection<?>> Command<T> command(Supplier<Integer> collectionPopMethod) {
        return () -> new CommandResult(String.valueOf(collectionPopMethod.get()));
    }
}
