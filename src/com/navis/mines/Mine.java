package com.navis.mines;

public final class Mine {

    private final float xCoordinate;
    private final float yCoordinate;
    private final float blastRadius;

    // Null pattern so that we can use use a mapper without checking for null values
    // For the purposes of this exercise, the grid is assumed to be far smaller than 2^32 x 2^32
    private static int offGrid = Integer.MIN_VALUE;
    private static int nullBlastValue = 0;
    public static Mine NULL = new Mine(offGrid, offGrid, nullBlastValue);

    public Mine(float xCoordinate, float yCoordinate, float blastRadius) {
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
        return "Mine{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", blastRadius=" + blastRadius +
                '}';
    }
}
