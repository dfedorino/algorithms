package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArchiveTest {
    private final Archive app = new Archive();

    @Test
    public void testCountArchivedUsers_ZeroUsers_ZeroArchived() {
        assertThat(app.countArchivedUsers(100, new int[]{})).isEqualTo(0);
    }

    @Test
    public void testCountArchivedUsers_OneUserWithLessDataThanArchive_OneArchived() {
        assertThat(app.countArchivedUsers(100, new int[]{50})).isEqualTo(1);
    }

    @Test
    public void testCountArchivedUsers_OneUserWithMoreDataThanArchive_ZeroArchived() {
        assertThat(app.countArchivedUsers(100, new int[]{101})).isEqualTo(0);
    }

    @Test
    public void testCountArchivedUsers_TwoUsers_OnlyOneCanBeArchived() {
        assertThat(app.countArchivedUsers(100, new int[]{200, 50})).isEqualTo(1);
    }

    @Test
    public void testCountArchivedUsers_ThreeUsers_OnlyTwoCanBeArchived() {
        assertThat(app.countArchivedUsers(100, new int[]{50, 30, 50})).isEqualTo(2);
    }

    @Test
    public void testCountArchivedUsers_ThreeUsersDataTogetherIsArchive_ThreeCanBeArchived() {
        assertThat(app.countArchivedUsers(90, new int[]{30, 30, 30})).isEqualTo(3);
    }

    @Test
    public void testCountArchivedUsers_FourUsersDataTogetherIsLessThanArchive_FourCanBeArchived() {
        assertThat(app.countArchivedUsers(120, new int[]{30, 29, 30, 30})).isEqualTo(4);
    }
}