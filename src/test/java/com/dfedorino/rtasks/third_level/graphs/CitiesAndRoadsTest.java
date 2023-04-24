package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CitiesAndRoadsTest {
    private final CitiesAndRoads app = new CitiesAndRoads();

    @Test
    private void testCountRoads_whenCities_thenCountRoadsBetweenThem() {
        int[][] citiesAndRoads = {
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertThat(app.countRoads(citiesAndRoads)).isEqualTo(3);
    }
}