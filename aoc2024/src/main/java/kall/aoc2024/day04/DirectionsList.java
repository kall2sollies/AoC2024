package kall.aoc2024.day04;

import java.util.Arrays;
import java.util.List;

public class DirectionsList {
    public static List<Directions> all() {
        return Arrays.asList(
            Directions.N,
            Directions.NE,
            Directions.E,
            Directions.SE,
            Directions.S,
            Directions.SW,
            Directions.W,
            Directions.NW
        );
    }
}