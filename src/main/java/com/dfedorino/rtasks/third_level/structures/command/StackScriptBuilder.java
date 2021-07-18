package com.dfedorino.rtasks.third_level.structures.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackScriptBuilder extends BaseScriptBuilder<Stack<Integer>> {
    private final Map<String, Command<Stack<Integer>>> map;
    private final Commands<Stack<Integer>> commands;

    public StackScriptBuilder() {
        commands = new Commands<>();
        map = new HashMap<>();
        map.put("pop", commands.createCommandUsing(Stack::pop));
        map.put("back", commands.createCommandUsing(Stack::peek));
        map.put("size", commands.createCommandUsing(Stack::size));
        map.put("clear", (stack) -> {
            stack.clear();
            return new CommandResult("ok");
        });
        map.put("exit", (stack) -> new CommandResult("bye"));
    }

    @Override
    public Command<Stack<Integer>> getCommand(String commandString) {
        return map.getOrDefault(commandString, this.getPushCommand(commandString));
    }

    private Command<Stack<Integer>> getPushCommand(String commandString) {
        return commands.createPushCommandUsing(commandString, Stack::push);
    }
}
