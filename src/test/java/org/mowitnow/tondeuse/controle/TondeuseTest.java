package org.mowitnow.tondeuse.controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class TondeuseTest {
    private Position startPosition;
    private Orientation startOrientation;
    private Tondeuse tondeuse;
    private PelouseControl pelouseControl;

    @BeforeEach
    void setUp() {
        startPosition = new Position(1, 2);
        startOrientation = Orientation.NORTH;
        pelouseControl = Mockito.mock(PelouseControl.class);
        tondeuse = new Tondeuse(startPosition, startOrientation);
    }

    @Test
    void testConstructor() {
        assertEquals(startPosition, tondeuse.getPosition()); // Assuming getPosition is public for testing
        assertEquals(startOrientation, tondeuse.getOrientation()); // Assuming getOrientation is public for testing
    }

    @Test
    void testAvancerValidPosition() {
        Position nextPosition = new Position(1, 3);
        when(pelouseControl.isPositionValide(nextPosition)).thenReturn(true);

        tondeuse.avancer(pelouseControl);
        assertEquals(nextPosition, tondeuse.getPosition());
    }

    @Test
    void testAvancerInvalidPosition() {
        Position invalidNextPosition = new Position(1, 3);
        when(pelouseControl.isPositionValide(invalidNextPosition)).thenReturn(false);

        tondeuse.avancer(pelouseControl);
        assertEquals(startPosition, tondeuse.getPosition()); // Should remain unchanged
    }

    @Test
    void testGauche() {
        tondeuse.gauche();
        assertEquals(Orientation.WEST, tondeuse.getOrientation()); // Assuming the starting orientation was NORTH
    }

    @Test
    void testDroite() {
        tondeuse.droite();
        assertEquals(Orientation.EAST, tondeuse.getOrientation()); // Assuming the starting orientation was NORTH
    }

    @Test
    void testToString() {
        String expected = startPosition.toString() + " " + startOrientation.toString();
        assertEquals(expected, tondeuse.toString());
    }
}
