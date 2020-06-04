package com.navis.service.impl;

import com.navis.chainReactors.DepthFirstChainReactor;
import com.navis.explodableItems.ExplodableItem;
import com.navis.service.ExplosionService;

import java.util.*;

public class MineExplosionService implements ExplosionService {

    // In the interest of time, I've omitted a memoization of this chain reaction
    // But the next step would be to create a HashMap to store existing values and then add those values
    // to the sets in the chain reactor so we don't have to re-cycle through them
    @Override
    public List<ExplodableItem> findGreatestChainReactions(List<ExplodableItem> itemsToExplode) {

        int largestSize = 0;
        List<ExplodableItem> minesToChoose = new ArrayList<>();
        Set<ExplodableItem> itemsToRecurse = new HashSet<>(itemsToExplode);
        for(ExplodableItem itemToExplode : itemsToExplode) {
            Set<ExplodableItem> explodedItems = DepthFirstChainReactor.recurseThroughChainReaction(
                    itemToExplode,
                    itemsToRecurse,
                    new HashSet<>()
            );
            if(explodedItems.size() == largestSize) {
                minesToChoose.add(itemToExplode);
            } else if(explodedItems.size() > largestSize) {
                minesToChoose = new ArrayList<>();
                minesToChoose.add(itemToExplode);
                largestSize = explodedItems.size();
            }
        }

        System.out.println(String.format("Maximum numbers of mines exploded is: %d", largestSize));
        return minesToChoose;
    }
}
