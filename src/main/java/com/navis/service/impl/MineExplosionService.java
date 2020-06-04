package com.navis.service.impl;

import com.navis.exploder.ExplodableItem;
import com.navis.service.ExplosionChecker;
import com.navis.service.ExplosionService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MineExplosionService implements ExplosionService {
    @Override
    public List<ExplodableItem> findGreatestChainReactions(List<ExplodableItem> itemsToExplode) {
        Map<ExplodableItem, Set<ExplodableItem>> relationships = itemsToExplode.stream().map(explodableItem -> {
            Set<ExplodableItem> explodedItems = itemsToExplode.stream().filter(item -> ExplosionChecker.didExplode(
                    explodableItem.getXCoordinate(),
                    explodableItem.getYCoordinate(),
                    explodableItem.getBlastRadius(),
                    item.getXCoordinate(),
                    item.getYCoordinate()
            )).collect(Collectors.toSet());
            return new Relationships(explodableItem, explodedItems);
        }).collect(Collectors.toMap(Relationships::getExplodableItem, Relationships::getItemsInBlastRadius));

        for(ExplodableItem itemToExplode : itemsToExplode) {}
        return null;
    }

    public Set<ExplodableItem> recurseThroughSets(Map<ExplodableItem, Set<ExplodableItem>> relationships,
                                                  Set<ExplodableItem> itemsToRecurse,
                                                  Set<ExplodableItem> itemsAlreadyDestroyed) {
        if(itemsAlreadyDestroyed.containsAll(itemsToRecurse)) {
            return itemsAlreadyDestroyed;
        }

        itemsAlreadyDestroyed.addAll(itemsToRecurse);

        for(ExplodableItem itemToRecurse: itemsToRecurse) {
            itemsAlreadyDestroyed.addAll(recurseThroughSets(relationships, relationships.get(itemToRecurse), itemsAlreadyDestroyed));
        }
        return itemsAlreadyDestroyed;
    }
    private class Relationships {
        private ExplodableItem explodableItem;
        private Set<ExplodableItem> itemsInBlastRadius;

        public Relationships(ExplodableItem explodableItem, Set<ExplodableItem> itemsInBlastRadius) {
            this.explodableItem = explodableItem;
            this.itemsInBlastRadius = itemsInBlastRadius;
        }

        public ExplodableItem getExplodableItem() {
            return explodableItem;
        }

        public Set<ExplodableItem> getItemsInBlastRadius() {
            return itemsInBlastRadius;
        }
    }
}
