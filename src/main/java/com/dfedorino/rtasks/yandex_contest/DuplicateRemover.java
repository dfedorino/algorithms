package com.dfedorino.rtasks.yandex_contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DuplicateRemover {
    /**
     * Given an array of integers in the file. The 1st integer is n, n <= 1_000_000.
     * The following are n lines of integers in the ascending order.
     * Return the file with only unique integers per line in ascending order
     *
     * @param path           - path to the input file
     * @param outputFileName - desired output file name
     * @return path to the output file with unique integers in ascending order
     * @throws IOException - if any I/O error occurs
     */
    public Path getFileWithUniqueIntegers(String path, String outputFileName) throws IOException {
        Path inputFile = Paths.get(path);
        Path outputFile = inputFile.resolveSibling(outputFileName);
        try (BufferedReader inputFileReader = Files.newBufferedReader(inputFile);
             BufferedWriter outputFileWriter = Files.newBufferedWriter(outputFile)) {
            int linesToCheck = Integer.parseInt(inputFileReader.readLine());
            Set<String> uniqueIntegers = new HashSet<>(linesToCheck);
            for (int lineIndex = 1; lineIndex <= linesToCheck; lineIndex++) {
                String currentInteger = inputFileReader.readLine();
                boolean isUniqueInteger = uniqueIntegers.add(currentInteger);
                if (isUniqueInteger) {
                    outputFileWriter.append(currentInteger);
                    if (lineIndex != linesToCheck) {
                        outputFileWriter.newLine();
                    }
                }
            }
        }
        return outputFile;
    }
}
