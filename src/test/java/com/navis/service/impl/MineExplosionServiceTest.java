package com.navis.service.impl;

import com.navis.explodableItems.ExplodableItem;
import com.navis.explodableItems.mines.Mine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MineExplosionServiceTest {
    MineExplosionService service;

    @BeforeEach
    public void setup() {
        service = new MineExplosionService();
    }

    @Test
    void findGreatestChainReactionsReturnsAll() {
        Mine mine1 = new Mine(0, 0, 2);

        Mine mine2 = new Mine(1, 0, 5);
        Mine mine3 = new Mine(6, 0, 1);
        Mine mine4 = new Mine(6, 1, 2);

        List<ExplodableItem> itemsToChainReact = Arrays.asList(mine1, mine2, mine3, mine4);
        List<ExplodableItem> result = service.findGreatestChainReactions(itemsToChainReact);
        List<ExplodableItem> expected = Arrays.asList(mine1, mine2);
        assertEquals(expected, result);
    }
}