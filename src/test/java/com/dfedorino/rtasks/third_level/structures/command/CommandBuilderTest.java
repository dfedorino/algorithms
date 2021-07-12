package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandBuilderTest {
    private final CommandBuilder<Stack<Integer>> commandBuilder = new StackCommandBuilder();

    @Test
    public void testBuildScript_whenEmptyListWithCommands_thenEmptyScript() {
        Script<Stack<Integer>> expectedScript = new Script<>(Collections.emptyList());
        assertThat(commandBuilder.buildScript(Collections.emptyList())).isEqualTo(expectedScript);
    }
}