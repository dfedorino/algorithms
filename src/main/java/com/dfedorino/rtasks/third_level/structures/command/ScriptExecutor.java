package com.dfedorino.rtasks.third_level.structures.command;

import java.util.List;
import java.util.stream.Collectors;

public class ScriptExecutor {
    private final List<Command> commands;

    public ScriptExecutor(List<Command> commands) {
        this.commands = commands;
    }

    public List<String> generateProtocol() {
        return commands.stream()
                .map(Command::execute)
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
    }
}
