package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandsTest {
    @Test
    public void testCommand_whenFunction_thenCommandReturned() {
        Commands<Stack<Integer>> commands = new Commands<>();
        Stack<Integer> stack = new Stack<>();
        CommandResult actualResult = commands.command(Stack::size).execute(stack);
        CommandResult expectedResult = new CommandResult("0");
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}