package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {
    private final Match match = new Match();

    @Test
    public void testGetScoreFromProtocol_TaskCase_2_4() {
        String[] events = {
                // first player serves
                "service",
                "goal", // 1:0
                "service",
                "out", // 1:1
                "service",
                "net", // 1:2
                "service",
                "return",
                "return",
                "return",
                "out", // 1:3
                "service",
                "return",
                "goal", // 2:3

                // second player serves
                "service",
                "goal", // 2:4
                "eom"
        };
        assertThat(match.getScoreFromProtocol(events)).isEqualTo(new Match.Score(2, 4));
    }

    @Test
    public void testGetScoreFromProtocol_NoSwitches_5_0() {
        String[] events = {
                // first player serves
                "service",
                "goal", // 1:0
                "service",
                "goal", // 2:0
                "service",
                "goal", // 3:0
                "service",
                "goal", // 4:0
                "service",
                "goal", // 5:0
                "eom"
        };
        assertThat(match.getScoreFromProtocol(events)).isEqualTo(new Match.Score(5, 0));
    }

    @Test
    public void testGetScoreFromProtocol_OneSwitch_3_3() {
        String[] events = {
                // first player serves
                "service",
                "goal", // 1:0
                "service",
                "out", // 1:1
                "service",
                "goal", // 2:1
                "service",
                "net", // 2:2
                "service",
                "goal", // 3:2

                // second player serves
                "service",
                "goal", // 3:3
                "eom"
        };
        assertThat(match.getScoreFromProtocol(events)).isEqualTo(new Match.Score(3, 3));
    }

    @Test
    public void testGetScoreFromProtocol_TwoSwitches_8_7() {
        String[] events = {
                // first player serves
                "service",
                "goal", // 1:0
                "service",
                "out", // 1:1
                "service",
                "goal", // 2:1
                "service",
                "net", // 2:2
                "service",
                "goal", // 3:2

                // second player serves
                "service",
                "goal", // 3:3
                "service",
                "out", // 4:3
                "service",
                "goal", // 4:4
                "service",
                "net", // 5:4
                "service",
                "goal", // 5:5

                // first player serves
                "service",
                "goal", // 6:5
                "service",
                "out", // 6:6
                "service",
                "goal", // 7:6
                "service",
                "net", // 7:7
                "service",
                "goal", // 8:7
                "eom"
        };
        assertThat(match.getScoreFromProtocol(events)).isEqualTo(new Match.Score(8, 7));
    }
}