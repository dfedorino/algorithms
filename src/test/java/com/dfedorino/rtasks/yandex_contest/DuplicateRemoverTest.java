package com.dfedorino.rtasks.yandex_contest;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class DuplicateRemoverTest {
    @Test
    public void testGetUniqueIntegers_ThreeUniqueTwoDuplicates_ThreeValues() throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        List<Integer> expected = Arrays.asList(2, 4, 8);
        Path outputFile = duplicateRemover.getFileWithUniqueIntegers(
                "src/main/resources/threeUniqueTwoDuplicatesInput.txt",
                "threeUniqueTwoDuplicatesOutput.txt");
        List<Integer> actual = Files.lines(outputFile).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetUniqueIntegers_TwoUniqueThreeDuplicates_TwoValues() throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        List<Integer> expected = Arrays.asList(2, 8);
        Path outputFile = duplicateRemover.getFileWithUniqueIntegers(
                "src/main/resources/twoUniqueThreeDuplicatesInput.txt",
                "twoUniqueThreeDuplicatesOutput.txt");
        List<Integer> actual = Files.lines(outputFile).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetUniqueIntegers_ThreeUniqueZeroDuplicates_ThreeValues() throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();
        List<Integer> expected = Arrays.asList(2, 4, 8);
        Path outputFile = duplicateRemover.getFileWithUniqueIntegers(
                "src/main/resources/threeUniqueZeroDuplicatesInput.txt",
                "threeUniqueZeroDuplicatesOutput.txt");
        List<Integer> actual = Files.lines(outputFile).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}