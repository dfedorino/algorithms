package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptExecutor<T extends Collection<?>> {
    private final List<Command<T>> commands;

    public ScriptExecutor(List<Command<T>> commands) {
        this.commands = commands;
    }

    public List<String> generateProtocol(T collection) {
        return commands.stream()
                .map(command -> command.execute(collection))
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
    }
}
