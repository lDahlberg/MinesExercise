package com.navis.mappers;

import com.navis.explodableItems.ExplodableItem;
import com.navis.explodableItems.mines.Mine;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Float.parseFloat;

public class MineMapper {

    private static final String regexSplit = "\\s";
    public List<ExplodableItem> createMines(List<String> unmappedMines) {
        return unmappedMines.stream().map(this::createMineFromString).collect(Collectors.toList());
    }

    private Mine createMineFromString(String unmappedMine) {
        String[] values = unmappedMine.split(regexSplit);

        int expectedLength = 3;
        if(values.length != expectedLength) {
            return Mine.NULL;
        }

        // Assuming for now that all mines are coming in as integers / floats and not as 'junk'
        float xCoordinate = parseFloat(values[0]);
        float yCoordinate =  parseFloat(values[1]);
        float blastRadius =  parseFloat(values[2]);
        return new Mine(xCoordinate, yCoordinate, blastRadius);
    }
}
