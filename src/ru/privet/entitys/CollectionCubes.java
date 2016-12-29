package ru.privet.entitys;

import java.util.ArrayList;

/**
 * Created by gendy on 28.12.16.
 */
public class CollectionCubes {

    private static final ArrayList<Cube> Cubes = new ArrayList<>(20);

    public static ArrayList<Cube> getCubes() {
        return Cubes;
    }
}
