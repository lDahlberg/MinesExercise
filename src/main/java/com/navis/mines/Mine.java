package com.navis.mines;

import com.navis.exploder.ExplodableItem;

public final class Mine extends ExplodableItem {

    private static int offGrid = Integer.MIN_VALUE;
    private static int nullBlastValue = 0;
    public static Mine NULL = new Mine(offGrid, offGrid, nullBlastValue);

    public Mine(float xCoordinate, float yCoordinate, float blastRadius) {
        super(xCoordinate, yCoordinate, blastRadius);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
