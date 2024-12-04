package kall.aoc2024.day04;

import java.util.List;

import kall.Shared.BaseExercise;

public class Day04First extends BaseExercise {

    public Day04First() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\04_1.txt");
    }

    @Override
    public String run() throws Exception {
        Map map = new Map(getLines());

        List<Character> pattern = "XMAS".chars().mapToObj(c -> (char) c).toList();

        Integer found = 0;

        for (Integer x = 0 ; x < map.getXSize() ; x++) {
            for (Integer y = 0 ; y < map.getYSize() ; y++) {
                Cell cell = map.getCellAt(x, y);

                if (cell.getValue() != pattern.get(0)) {
                    continue;
                }

                for (Directions direction : DirectionsList.all()) {
                    if (cell.getCellAtDirection(direction) != null && cell.getCellAtDirection(direction).getValue() == pattern.get(1) &&
                        cell.getCellAtDirection(direction).getCellAtDirection(direction) != null && cell.getCellAtDirection(direction).getCellAtDirection(direction).getValue() == pattern.get(2) &&
                        cell.getCellAtDirection(direction).getCellAtDirection(direction).getCellAtDirection(direction) != null && cell.getCellAtDirection(direction).getCellAtDirection(direction).getCellAtDirection(direction).getValue() == pattern.get(3)) {
                        
                        found++;

                        System.out.println("Found at " + x.toString() + ", " + y.toString() + " in direction " + direction.toString());
                    }
                }
            }
        }

        return found.toString();
    }

}