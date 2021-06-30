package com.dfedorino.rtasks.third_level.structures;

import com.dfedorino.rtasks.third_level.structures.implementations.ProtectedDequeProtocolDynamicImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtectedDequeProtocolTest {

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushFrontN_thenOk(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_front 1"))).isEqualTo(List.of("ok"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushBackN_thenOk(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_back 2"))).isEqualTo(List.of("ok"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPopFront_thenDeletedValue(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_front 1", "pop_front"))).isEqualTo(List.of("ok", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPopBack_thenDeletedValue(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_back 2", "pop_back"))).isEqualTo(List.of("ok", "2"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenFront_thenDeletedValue(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_front 1", "front"))).isEqualTo(List.of("ok", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenBack_thenValue(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push_back 2", "back"))).isEqualTo(List.of("ok", "2"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenSize_thenActualSize(String name, ProtectedDequeProtocol protocol) {
        List<String> commands = List.of("push_front 1", "push_front 2", "size");
        List<String> expectedProtocol = List.of("ok", "ok", "2");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenClear_thenOk(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("clear"))).isEqualTo(List.of("ok"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenExit_thenBye(String name, ProtectedDequeProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("exit"))).isEqualTo(List.of("bye"));
    }

    @DataProvider(name = "implementations")
    public Object[][] implementations() {
        return new Object[][] {
                {"Dynamic implementation", new ProtectedDequeProtocolDynamicImpl()}
        };
    }
}