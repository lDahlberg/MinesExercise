package com.navis.service;

// As this was provided, it's being untested as as an existing API that the creator has already properly unit tested
public class ExplosionChecker {
    public static boolean didExplode(Float x1, Float y1, Float r, Float x2, Float y2) {
     return r >= Math.sqrt( Math.pow( (x2-x1), 2) + Math.pow( (y2-y1), 2));
   }
}
