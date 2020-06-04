package com.navis.mappers;

import com.navis.explodableItems.ExplodableItem;
import com.navis.explodableItems.mines.Mine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MineMapperTest {

    private MineMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new MineMapper();
    }
    @Test
    void createMinesUnpacksStringsOfAllGoodValues() {
        List<String> unmappedMines = new ArrayList<>();
        unmappedMines.add("1 1 1");
        unmappedMines.add("2 2 2");

        List<ExplodableItem> actual = mapper.createMines(unmappedMines);

        Mine expectedMine111 = new Mine(1, 1, 1);
        Mine expectedMine222 = new Mine(2, 2, 2);

        List<ExplodableItem> expected = Arrays.asList(expectedMine111, expectedMine222);

        assertEquals(expected, actual);
    }

    @Test
    void createMinesUnpacksStringsOfBadValuesCreatesANull() {
        List<String> unmappedMines = new ArrayList<>();
        unmappedMines.add("1 1");
        unmappedMines.add("2 2 2");

        List<ExplodableItem> actual = mapper.createMines(unmappedMines);

        Mine expectedMine111 = new Mine(1, 1, 1);
        Mine expectedMine222 = new Mine(2, 2, 2);

        List<ExplodableItem> expected = Arrays.asList(Mine.NULL, expectedMine222);

        assertEquals(expected, actual);
    }
}