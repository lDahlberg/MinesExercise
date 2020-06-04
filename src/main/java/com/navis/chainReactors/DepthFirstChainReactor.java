package com.navis.chainReactors;

import com.navis.explodableItems.ExplodableItem;
import com.navis.service.ExplosionCheckerService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DepthFirstChainReactor {

    public static Set<ExplodableItem> recurseThroughChainReaction(ExplodableItem explodedItem,
                                                           Set<ExplodableItem> itemsToRecurse,
                                                           Set<ExplodableItem> itemsDestroyed) {

        // Ensure that we don't retouch an item we've already gone through
        if(itemsDestroyed.contains(explodedItem)) {
            return itemsDestroyed;
        }

        itemsDestroyed.add(explodedItem);

        // Potential bug here if two mines are in same spot; assuming for now that we can't have 1 on top of another
        Set<ExplodableItem> setWithExplodedItemRemoved = itemsToRecurse.stream().filter(explodableItem -> !explodableItem.equals(explodedItem))
                .collect(Collectors.toCollection(HashSet::new));

        for(ExplodableItem itemToRecurse: setWithExplodedItemRemoved) {
            if(ExplosionCheckerService.didExplode(explodedItem.getXCoordinate(), explodedItem.getYCoordinate(), explodedItem.getBlastRadius(),
                    itemToRecurse.getXCoordinate(), itemToRecurse.getYCoordinate())) {
                    itemsDestroyed.addAll(recurseThroughChainReaction(itemToRecurse, setWithExplodedItemRemoved, itemsDestroyed));
            }
        }
        return itemsDestroyed;
    }
}
