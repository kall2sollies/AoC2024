package kall.aoc2024.day04;

import java.util.List;

public class Map {
    private Cell[][] _cells;
    private int _xSize;
    private int _ySize;

    public int getXSize() {
        return _xSize;
    }

    public int getYSize() {
        return _ySize;
    }

    public Map(String[] data) {
        _ySize = data.length;

        for(int y = 0 ; y < _ySize ; y++) {

            List<Character> chars = data[y].chars().mapToObj(c -> (char) c).toList();

            _xSize = chars.size();

            if (_cells == null) {
                _cells = new Cell[_ySize][_xSize];
            }            

            for (int x = 0 ; x < _xSize ; x++) {
                Cell cell = new Cell(x, y, chars.get(x), this);

                _cells[y][x] = cell;
            }
        }
    }

    public Cell getCellAt(int x, int y) {
        if (x >= _xSize || y >= _ySize || x < 0 || y < 0) {
            return null;
        }

        return _cells[y][x];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0 ; y < _ySize ; y++) {
            for (int x = 0 ; x < _xSize ; x++) {
                sb.append(getCellAt(x, y).toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}