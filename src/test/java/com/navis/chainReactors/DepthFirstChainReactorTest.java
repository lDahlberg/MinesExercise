package com.navis.chainReactors;

import com.navis.explodableItems.ExplodableItem;
import com.navis.explodableItems.mines.Mine;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstChainReactorTest {

    @Test
    void recurseThroughSetsTestsBaseCondition() {

        Mine mineAlreadyExploded = new Mine(0, 0, 1);

        Set<ExplodableItem> itemsDestroyed = new HashSet<>(Collections.singleton(mineAlreadyExploded));

        Set<ExplodableItem> result = DepthFirstChainReactor.recurseThroughChainReaction(mineAlreadyExploded, new HashSet<>(), itemsDestroyed);

        assertEquals(result, itemsDestroyed);
    }

    @Test
    void recurseThroughSetsTestsThatMineExplodesMineTwo() {

        Mine mineToExplode = new Mine(0, 0, 2);

        Mine adjacentMine = new Mine(1, 0, 1);

        Set<ExplodableItem> itemsToRecurse = new HashSet<>(Collections.singleton(adjacentMine));
        Set<ExplodableItem> itemsDestroyed = new HashSet<>();

        Set<ExplodableItem> result = DepthFirstChainReactor.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

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

        Set<ExplodableItem> result = DepthFirstChainReactor.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

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

        Set<ExplodableItem> result = DepthFirstChainReactor.recurseThroughChainReaction(mineToExplode, itemsToRecurse, itemsDestroyed);

        Set<ExplodableItem> expected = new HashSet<>(Arrays.asList(mineToExplode, adjacentMine));
        assertEquals(expected, result);
    }
}