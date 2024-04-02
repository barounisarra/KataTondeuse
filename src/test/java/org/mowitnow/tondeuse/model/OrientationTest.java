package org.mowitnow.tondeuse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrientationTest {

    @Test
    public void fromCode_ValidCodes_Returns_CorrectOrientations() {
        assertEquals(Orientation.NORTH, Orientation.fromCode("N"), "N should correspond to NORTH");
        assertEquals(Orientation.EAST, Orientation.fromCode("E"), "E should correspond to EAST");
        assertEquals(Orientation.SOUTH, Orientation.fromCode("S"), "S should correspond to SOUTH");
        assertEquals(Orientation.WEST, Orientation.fromCode("W"), "W should correspond to WEST");
    }

    @Test
    public void fromCode_InvalidCode_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Orientation.fromCode("X"), "X is an invalid code and should throw an exception");
    }

    @Test
    public void gauche_From_North_Returns_West() {
        assertEquals(Orientation.WEST, Orientation.NORTH.gauche(), "Turning left from NORTH should result in WEST");
    }

    @Test
    public void droite_From_North_Returns_East() {
        assertEquals(Orientation.EAST, Orientation.NORTH.droite(), "Turning right from NORTH should result in EAST");
    }

    @Test
    public void gauche_From_East_Returns_North() {
        assertEquals(Orientation.NORTH, Orientation.EAST.gauche(), "Turning left from EAST should result in NORTH");
    }

    @Test
    public void droite_From_East_Returns_South() {
        assertEquals(Orientation.SOUTH, Orientation.EAST.droite(), "Turning right from EAST should result in SOUTH");
    }

    @Test
    public void gauche_From_South_Returns_East() {
        assertEquals(Orientation.EAST, Orientation.SOUTH.gauche(), "Turning left from SOUTH should result in EAST");
    }

    @Test
    public void droite_From_South_Returns_West() {
        assertEquals(Orientation.WEST, Orientation.SOUTH.droite(), "Turning right from SOUTH should result in WEST");
    }

    @Test
    public void gauche_From_West_Returns_South() {
        assertEquals(Orientation.SOUTH, Orientation.WEST.gauche(), "Turning left from WEST should result in SOUTH");
    }

    @Test
    public void droite_From_West_Returns_North() {
        assertEquals(Orientation.NORTH, Orientation.WEST.droite(), "Turning right from WEST should result in NORTH");
    }
}
