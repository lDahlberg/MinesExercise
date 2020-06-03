package com.navis;

import com.navis.mappers.MineMapper;
import com.navis.mines.Mine;
import com.navis.readers.Reader;
import com.navis.readers.impl.TextFileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Reader reader = new TextFileReader();
        List<String> stringOfMines = reader.read();

        MineMapper mapper = new MineMapper();
        List<Mine> mines = mapper.createMines(stringOfMines);

        mines.forEach(System.out::println);
    }
}
