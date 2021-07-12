package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandBuilderTest {
    @Test
    public void testBuildScript_whenEmptyListWithCommands_thenEmptyScript() {
        // TODO: remove constructor argument
        CommandBuilder<Stack<Integer>> commandBuilder = new StackCommandBuilder(Collections.emptyList());
        Script<Stack<Integer>> expectedScript = new Script<>(Collections.emptyList());
        assertThat(commandBuilder.buildScript(Collections.emptyList())).isEqualTo(expectedScript);
    }

    @Test
    public void testBuildScript_whenNonEmptyListWithCommands_thenNonEmptyScript() {
        // TODO: remove constructor argument
        CommandBuilder<Stack<Integer>> commandBuilder = new StackCommandBuilder(Collections.emptyList());
        Script<Stack<Integer>> script = commandBuilder.buildScript(List.of("size"));
        Stack<Integer> stack = new Stack<>();
        Protocol<String> actualProtocol = script.execute(stack);
        Protocol<String> expectedProtocol = new Protocol<>(List.of("0"));
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }
}