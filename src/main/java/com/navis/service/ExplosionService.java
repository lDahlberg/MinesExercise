package com.navis.service;

import com.navis.exploder.ExplodableItem;

import java.util.List;

public interface ExplosionService {
    List<ExplodableItem> findGreatestChainReactions(List<ExplodableItem> itemsToExplode);
}
