package com.dfedorino.rtasks.third_level.structures;

import com.dfedorino.rtasks.third_level.structures.implementations.SimpleArrayDeque;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProtocolTest {
    Protocol.SimpleStack<Integer> stack = new SimpleArrayDeque<>();
    Protocol.ProtectedQueue<Integer> queue = new SimpleArrayDeque<>();
    Protocol.ProtectedDeque<Integer> deque = new SimpleArrayDeque<>();

    @Test
    public void testGenerateProtocol_whenCommandsForStack_thenExpectedProtocol() {

    }

    @Test
    public void testGenerateProtocol_whenCommandsForQueue_thenExpectedProtocol() {

    }

    @Test
    public void testGenerateProtocol_whenCommandsForDeque_thenExpectedProtocol() {

    }
}