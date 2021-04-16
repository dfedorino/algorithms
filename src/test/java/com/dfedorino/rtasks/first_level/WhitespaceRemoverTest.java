package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WhitespaceRemoverTest {
    private final WhitespaceRemover app = new WhitespaceRemover();

    @Test
    public void testRemoveRedundant_NoWhitespaces_SameString() {
        assertEquals(app.removeRedundant("aaa"), "aaa");
    }

    @Test
    public void testRemoveRedundant_NecessaryWhitespaces_SameString() {
        assertEquals(app.removeRedundant(" a a a "), " a a a ");
    }

    @Test
    public void testRemoveRedundant_RedundantWhitespaces_SameString() {
        assertEquals(app.removeRedundant("  a  a  a  "), " a a a ");
    }

    @Test
    public void testRemoveRedundant_TaskTest1() {
        assertEquals(
                app.removeRedundant( " nz d urp lren s bwz  boom  t a   j    ho    vi"),
                                    " nz d urp lren s bwz boom t a j ho vi"
        );
    }

    @Test
    public void testRemoveRedundant_TaskTest2() {
        assertEquals(
                app.removeRedundant(
                        "   d  iz  czl l l h udq t "),
                         " d iz czl l l h udq t "
        );
    }
}