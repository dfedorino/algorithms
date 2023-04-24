package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ScriptBuilderTest {
    private final ScriptBuilder<Stack<Integer>> scriptBuilder = new StackScriptBuilder();

    @Test
    public void testBuildScript_whenEmptyListWithCommands_thenEmptyScript() {
        Script<Stack<Integer>> expectedScript = new Script<>(Collections.emptyList());
        assertThat(scriptBuilder.buildScript(Collections.emptyList())).isEqualTo(expectedScript);
    }
}