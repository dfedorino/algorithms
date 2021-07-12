package com.dfedorino.rtasks.third_level.structures.command;

import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class Script<T extends Collection<?>> {
    private List<Command<T>> commands;

    public Protocol<String> execute(T collection) {
        List<String> protocol = commands.stream()
                .map(command -> command.execute(collection))
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
        return new Protocol<>(protocol);
    }
}
