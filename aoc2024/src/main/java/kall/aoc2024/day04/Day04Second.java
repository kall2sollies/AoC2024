package kall.aoc2024.day04;

import kall.Shared.BaseExercise;

public class Day04Second extends BaseExercise {

    public Day04Second() throws Exception {
        super("D:\\Dev\\AoC2024\\aoc2024\\data\\04_2.txt");
    }

    @Override
    public String run() throws Exception {
        Map map = new Map(getLines());

        Integer found = 0;

        for (Integer x = 0 ; x < map.getXSize() ; x++) {
            for (Integer y = 0 ; y < map.getYSize() ; y++) {
                Cell cell = map.getCellAt(x, y);

                if (cell.getValue() == 'A' &&
                    cell.getCellAtDirection(Directions.NW) != null && cell.getCellAtDirection(Directions.NW).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.NE) != null && cell.getCellAtDirection(Directions.NE).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.SW) != null && cell.getCellAtDirection(Directions.SW).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.SE) != null && cell.getCellAtDirection(Directions.SE).getValue() == 'S'
                ) {
                    found++;
                }

                if (cell.getValue() == 'A' &&
                    cell.getCellAtDirection(Directions.NW) != null && cell.getCellAtDirection(Directions.NW).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.NE) != null && cell.getCellAtDirection(Directions.NE).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.SW) != null && cell.getCellAtDirection(Directions.SW).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.SE) != null && cell.getCellAtDirection(Directions.SE).getValue() == 'M'
                ) {
                    found++;
                }

                if (cell.getValue() == 'A' &&
                    cell.getCellAtDirection(Directions.NW) != null && cell.getCellAtDirection(Directions.NW).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.NE) != null && cell.getCellAtDirection(Directions.NE).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.SW) != null && cell.getCellAtDirection(Directions.SW).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.SE) != null && cell.getCellAtDirection(Directions.SE).getValue() == 'M'
                ) {
                    found++;
                }

                if (cell.getValue() == 'A' &&
                    cell.getCellAtDirection(Directions.NW) != null && cell.getCellAtDirection(Directions.NW).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.NE) != null && cell.getCellAtDirection(Directions.NE).getValue() == 'M' &&
                    cell.getCellAtDirection(Directions.SW) != null && cell.getCellAtDirection(Directions.SW).getValue() == 'S' &&
                    cell.getCellAtDirection(Directions.SE) != null && cell.getCellAtDirection(Directions.SE).getValue() == 'S'
                ) {
                    found++;
                }
            }
        }

        return found.toString();
    }

}