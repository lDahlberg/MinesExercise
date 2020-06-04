package com.navis.exploder;

import java.util.Objects;

public abstract class ExplodableItem {
    private final float xCoordinate;
    private final float yCoordinate;
    private final float blastRadius;

    public ExplodableItem(float xCoordinate, float yCoordinate, float blastRadius) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.blastRadius = blastRadius;
    }

    public float getXCoordinate() {
        return xCoordinate;
    }

    public float getYCoordinate() {
        return yCoordinate;
    }

    public float getBlastRadius() {
        return blastRadius;
    }

    @Override
    public String toString() {
        return "ExplodableItem{" +
                "xCoordinate=" + this.xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", blastRadius=" + blastRadius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExplodableItem that = (ExplodableItem) o;
        return Float.compare(that.xCoordinate, xCoordinate) == 0 &&
                Float.compare(that.yCoordinate, yCoordinate) == 0 &&
                Float.compare(that.blastRadius, blastRadius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, blastRadius);
    }
}
