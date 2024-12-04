package kall.aoc2024.day04;

public class Cell {
    private int _x, _y;
    private Character _value;
    private Map _map;

    public int getX() { return _x; }
    public int getY() { return _y; }
    public Character getValue() { return _value; }

    public Cell(int x, int y, Character value, Map mapReference) {
        _map = mapReference;
        _x = x;
        _y = y;
        _value = value;
    }

    public Cell getCellAtDirection(Directions direction) {
        int xOffset = 0;
        int yOffset = 0;

        if (direction == Directions.N) {
            xOffset = 0;
            yOffset = -1;
        }

        if (direction == Directions.NE) {
            xOffset = 1;
            yOffset = -1;
        }

        if (direction == Directions.E) {
            xOffset = 1;
            yOffset = 0;
        }
        
        if (direction == Directions.SE) {
            xOffset = 1;
            yOffset = 1;
        }

        if (direction == Directions.S) {
            xOffset = 0;
            yOffset = 1;
        }

        if (direction == Directions.SW) {
            xOffset = -1;
            yOffset = 1;
        }

        if (direction == Directions.W) {
            xOffset = -1;
            yOffset = 0;
        }

        if (direction == Directions.NW) {
            xOffset = -1;
            yOffset = -1;
        }

        return _map.getCellAt(_x + xOffset, _y + yOffset);
    }

    @Override
    public String toString() {
        return this._value.toString();
    }
}