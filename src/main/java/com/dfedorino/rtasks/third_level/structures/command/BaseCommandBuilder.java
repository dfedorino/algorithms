package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
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

    @Override
    public Script<T> buildScript(List<String> commandStrings) {
        List<Command<T>> commands = commandStrings.stream()
                .map(this::buildCommand)
                .collect(Collectors.toList());
        return new Script<>(commands);
    }

    public abstract Command<T> buildCommand(String commandString);
}
