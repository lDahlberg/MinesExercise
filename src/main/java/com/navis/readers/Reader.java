package com.navis.readers;

import java.io.FileNotFoundException;
import java.util.List;

public interface Reader {
    List<String> read(String fileName) throws FileNotFoundException;
}
