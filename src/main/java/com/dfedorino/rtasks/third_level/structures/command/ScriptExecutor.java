package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ScriptExecutor<T extends Collection<?>> {
    public Protocol<String> generateProtocol(Script<T> script, T collection) {
        List<String> records = script.getCommands().stream()
                .map(command -> command.execute(collection))
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
        return new Protocol<>(records);
    }
}
