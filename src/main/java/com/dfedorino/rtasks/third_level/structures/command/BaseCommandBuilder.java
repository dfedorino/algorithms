package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseCommandBuilder<T extends Collection<?>> implements CommandBuilder<T> {
    @Override
    public Script<T> buildScript(List<String> commandStrings) {
        List<Command<T>> commands = commandStrings.stream()
                .map(this::buildCommand)
                .collect(Collectors.toList());
        return new Script<>(commands);
    }

    public abstract Command<T> buildCommand(String commandString);
}
