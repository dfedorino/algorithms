package com.dfedorino.rtasks.third_level.graphs.search.bfs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LabyrinthPaintingTest {
    private final LabyrinthPainting app = new LabyrinthPainting();

    @Test
    public void testCountTotalAreaOfWalls_whenThreeEmptySegments_then72() {
        String[][] labyrinth = {
                          /**/  /**/
                    {".", ".",  "."} /**/,
                /**/ {".", ".", "."} /**/,
                /**/ {".", ".", "."}
        };            /**/ /**/
        int expectedArea = 8 * 9;
        assertThat(app.countTotalAreaOfWalls(labyrinth)).isEqualTo(expectedArea);
    }

    @Test
    public void testCountTotalAreaOfWalls_whenFourEmptySegments_then108() {
        String[][] labyrinth = {
                           /**/ /**/ /**/
                     {".", ".", ".", "."} /**/,
                /**/ {".", ".", ".", "."} /**/,
                /**/ {".", ".", ".", "."} /**/,
                /**/ {".", ".", ".", "."}
        };           /**/ /**/ /**/
        int expectedArea = 12 * 9;
        assertThat(app.countTotalAreaOfWalls(labyrinth)).isEqualTo(expectedArea);
    }

    @Test
    public void testCountTotalAreaOfWalls_whenTwelveEmptySegments_then180() {
        String[][] labyrinth = {
                                 /**/ /**/     /**/
                     {".",       ".", ".",     "."} /**/,
                                /**/ /**/
                /**/ {".", /**/ "#", "#", /**/ "."} /**/,
                /**/ {".", /**/ "#", "#", /**/ "."} /**/,
                               /**/  /**/
                /**/ {".",      ".", ".",      "."}
        };           /**/       /**/ /**/
        int expectedArea = 20 * 9;
        assertThat(app.countTotalAreaOfWalls(labyrinth)).isEqualTo(expectedArea);
    }

    @Test
    public void testCountTotalAreaOfWalls_whenTwelveEmptySegmentsAndTwoRooms_then198() {
        String[][] labyrinth = {
                           /**/ /**/       /**/ /**/
                     {".", ".", ".",       ".", "."} /**/ ,
                                     /**/ /**/ /**/
                /**/ {".", ".", ".", /**/ "#", "#"},
                /**/ {".", ".", /**/ "#", ".", "."},
                /**/ {".", ".", /**/ "#", "#", "#"},
                                /**/ /**/ /**/
                /**/ {".", ".", ".", ".", "."}
                     /**/  /**/ /**/ /**/
        };
        int expectedArea = 22 * 9;
        assertThat(app.countTotalAreaOfWalls(labyrinth)).isEqualTo(expectedArea);
    }
}