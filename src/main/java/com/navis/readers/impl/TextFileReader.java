package com.navis.readers.impl;

import com.navis.readers.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*Text file consumer. Uses base Java api to consume file
* In the interest of time, I did not test the file as it contains no logic
*/
public class TextFileReader implements Reader {
    @Override
    public List<String> read(String fileName) throws FileNotFoundException {
        try {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileNotFoundException(String.format("Could not find filename %s", fileName));
        }
    }
}
