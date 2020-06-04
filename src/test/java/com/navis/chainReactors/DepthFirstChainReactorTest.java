package com.navis.chainReactors;

import com.navis.exploder.ExplodableItem;
import com.navis.mines.Mine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstChainReactorTest {

    private DepthFirstChainReactor dfs;

    @BeforeEach
    public void setup() {
        dfs = new DepthFirstChainReactor();
    }

    @Test
    void recurseThroughSetsTestsBaseCondition() {

        Mine mineAlreadyExploded = new Mine(0, 0, 1);

        Set<ExplodableItem> itemsDestroyed = new HashSet<>(Arrays.asList(mineAlreadyExploded));

        Set<ExplodableItem> result = dfs.recurseThroughChainReaction(mineAlreadyExploded, new HashSet<>(), itemsDestroyed);

        assertEquals(result, itemsDestroyed);
    }

    @Test
    void recurseThroughSetsTestsThatMineExplodesMineTwo() {

        Mine mineToExplode = new Mine(0, 0, 2);

        Mine adjacentMine = new Mine(1, 0, 1);

        Set<ExplodableItem> itemsToRecurse = new HashSet<>(Arrays.asList(adjacentMine));
        Set<ExplodableItem> itemsDestroyed = new HashSet<>();

        Set<ExplodableItem> result = dfs.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

        Set<ExplodableItem> expected = new HashSet<>(Arrays.asList(mineToExplode, adjacentMine));
        assertEquals(expected, result);
    }

    @Test
    void recurseThroughSetsTestsThatMineOneExplodesThreeOtherMines() {

        Mine mineToExplode = new Mine(0, 0, 2);

        Mine adjacentMine = new Mine(1, 0, 5);
        Mine farAwayMine = new Mine(6, 0, 1);
        Mine farAwayMineAdjacentMine = new Mine(6, 1, 2);

        Set<ExplodableItem> itemsToRecurse = new HashSet<>(Arrays.asList(adjacentMine, farAwayMine, farAwayMineAdjacentMine));
        Set<ExplodableItem> itemsDestroyed = new HashSet<>();

        Set<ExplodableItem> result = dfs.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

        Set<ExplodableItem> expected = new HashSet<>(Arrays.asList(mineToExplode, adjacentMine, farAwayMine, farAwayMineAdjacentMine));
        assertEquals(expected, result);
    }

    @Test
    void recurseThroughSetsTestsThatMineOneReactionHaltsWhenBlastRadiusDoes() {

        Mine mineToExplode = new Mine(0, 0, 2);

        Mine adjacentMine = new Mine(1, 0, 2);
        Mine farAwayMine = new Mine(6, 0, 1);
        Mine farAwayMineAdjacentMine = new Mine(6, 1, 2);

        Set<ExplodableItem> itemsToRecurse = new HashSet<>(Arrays.asList(adjacentMine, farAwayMine, farAwayMineAdjacentMine));
        Set<ExplodableItem> itemsDestroyed = new HashSet<>();

        Set<ExplodableItem> result = dfs.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

        Set<ExplodableItem> expected = new HashSet<>(Arrays.asList(mineToExplode, adjacentMine));
        assertEquals(expected, result);
    }
}