package com.navis.explodableItems.mines;

import com.navis.explodableItems.ExplodableItem;

/*
* Mine that can explode
* Contains a null value that has minimum integer values to put it off the grid so it doesn't affect the calculations
* But also doesn't force null checks
*/
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

    @Override
    public String toString() {
        return "Mine{" + super.toString() + "}";
    }
}
