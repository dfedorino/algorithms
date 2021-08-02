package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class BaseScriptBuilder<T extends Collection<Integer>> implements ScriptBuilder<T> {
    private final Map<String, Function<String, Command<T>>> stringToCommand;

    public BaseScriptBuilder() {
        stringToCommand = new HashMap<>();
        stringToCommand.put("size", (commandStr) -> new CommandImpl<>(null, (value, collection) -> new CommandResult(collection.size() + "")));
        stringToCommand.put("clear", (commandStr) -> new CommandImpl<>(null, (value, collection) -> {
            collection.clear();
            return new CommandResult("ok");
        }));
        stringToCommand.put("exit", (commandStr) -> new CommandImpl<>(null, (value, collection) -> new CommandResult("bye")));
    }

    @Override
    public Script<T> buildScript(List<String> commandStrings) {
        List<Command<T>> commands = commandStrings.stream()
                .map(this::getCommand)
                .collect(Collectors.toList());
        return new Script<>(commands);
    }

    public abstract Command<T> getCommand(String commandString);

    public Map<String, Function<String, Command<T>>> getStringToCommand() {
        return stringToCommand;
    }
}
