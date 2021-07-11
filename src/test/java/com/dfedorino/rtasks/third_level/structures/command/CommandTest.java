package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    public void testExecute_whenCollectionPassed_thenCommandResult() {
        Command<Stack<Integer>> stackCommand = (Stack<Integer> stack) -> new CommandResult(stack.size() + "");
        assertThat(stackCommand.execute(new Stack<>())).isEqualTo(new CommandResult("0"));
    }
}