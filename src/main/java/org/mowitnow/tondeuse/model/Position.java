package org.mowitnow.tondeuse.model;

public record Position(int x, int y) {
    public Position north() {
        return new Position(x, y + 1);
    }

    public Position east() {
        return new Position(x + 1, y);
    }

    public Position south() {
        return new Position(x, y - 1);
    }

    public Position west() {
        return new Position(x - 1, y);
    }

    @Override
    public String toString() {
        return  x + " " + y ;
    }
}