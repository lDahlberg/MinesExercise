package com.navis.readers.impl;

import com.navis.readers.Reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class TextFileReader implements Reader {

    private static final String fileName = "./exampleTextFiles/example_mines.txt";
    @Override
    public List<String> read() {
        try {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
