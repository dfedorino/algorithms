package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseScriptBuilder<T extends Collection<?>> implements ScriptBuilder<T> {
    @Override
    public Script<T> buildScript(List<String> commandStrings) {
        List<Command<T>> commands = commandStrings.stream()
                .map(this::getCommand)
                .collect(Collectors.toList());
        return new Script<>(commands);
    }

    public abstract Command<T> getCommand(String commandString);
}
