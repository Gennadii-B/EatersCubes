package ru.privet.entitys;

/**
 * Created by gendy on 28.12.16.
 */
public class Cube {

    public Cube() {
        CubeId = counts++;
    }

    private static int counts;
    private int CubeId;

    public int getCubeId() {
        return CubeId;
    }
}
