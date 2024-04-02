package org.mowitnow.tondeuse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void moveNorth_IncreasesYByOne() {
        Position original = new Position(0, 0);
        Position result = original.north();
        assertEquals(new Position(0, 1), result);
    }

    @Test
    public void moveEast_IncreasesXByOne() {
        Position original = new Position(0, 0);
        Position result = original.east();
        assertEquals(new Position(1, 0), result);
    }

    @Test
    public void moveSouth_DecreasesYByOne() {
        Position original = new Position(0, 0);
        Position result = original.south();
        assertEquals(new Position(0, -1), result);
    }

    @Test
    public void moveWest_DecreasesXByOne() {
        Position original = new Position(0, 0);
        Position result = original.west();
        assertEquals(new Position(-1, 0), result);
    }

    @Test
    public void toString_ReturnsExpectedFormat() {
        Position position = new Position(5, 10);
        assertEquals("5 10", position.toString());
    }
}
