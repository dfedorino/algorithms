package com.dfedorino.rtasks.third_level.graphs.search;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private final Lines app = new Lines();

    @Test
    public void testGetRoute_whenNoObstacles_thenRouteIsBuilt() {
        String[][] map = {
                {".", ".", "X"},
                {".", "@", "."},
                {".", ".", "."}
        };
        Lines.Route expectedRoute = new Lines.Route();
        expectedRoute.setFound(true);
        expectedRoute.setRoute(new String[][]{
                {".", "+", "X"},
                {".", "@", "."},
                {".", ".", "."}
        });
        assertThat(app.getRoute(map)).isEqualTo(expectedRoute);
    }

    @Test
    public void testGetRoute_whenTestCase1_thenRouteIsBuilt() {
        String[][] map = {
                {"@", "."},
                {".", "X"}
        };
        Lines.Route expectedRoute = new Lines.Route();
        expectedRoute.setFound(true);
        expectedRoute.setRoute(new String[][]{
                {"@", "+"},
                {".", "X"}
        });
        assertThat(app.getRoute(map)).isEqualTo(expectedRoute);
    }

    @Test
    public void testGetRoute_whenNoRoute_thenNoRouteIsBuilt() {
        String[][] map = {
                {"@", "O"},
                {"O", "X"}
        };
        Lines.Route expectedRoute = new Lines.Route();
        assertThat(app.getRoute(map)).isEqualTo(expectedRoute);
    }
}