package org.mowitnow.tondeuse.controle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mowitnow.tondeuse.model.Pelouse;
import org.mowitnow.tondeuse.model.Position;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PelouseControlTest {
    Pelouse pelouseMock;
    PelouseControl pelouseControl;

    @BeforeEach
    void setUp() {
        pelouseMock = mock(Pelouse.class);
        pelouseControl = new PelouseControl(pelouseMock);
    }

    @Test
    void isPositionValideTrueScenario() {
        Position positionMock = mock(Position.class);
        when(positionMock.x()).thenReturn(5);
        when(positionMock.y()).thenReturn(5);
        when(pelouseMock.width()).thenReturn(10);
        when(pelouseMock.length()).thenReturn(10);

        assertTrue(pelouseControl.isPositionValide(positionMock));
    }

    @Test
    void isPositionValideFalseScenario() {
        Position positionMock = mock(Position.class);
        when(positionMock.x()).thenReturn(11);
        when(positionMock.y()).thenReturn(11);
        when(pelouseMock.width()).thenReturn(10);
        when(pelouseMock.length()).thenReturn(10);

        assertFalse(pelouseControl.isPositionValide(positionMock));
    }

    @Test
    void isXValid() {
        assertTrue(pelouseControl.isXValid(0, 10));
        assertFalse(pelouseControl.isXValid(-1, 10));
        assertTrue(pelouseControl.isXValid(10, 10));
        assertFalse(pelouseControl.isXValid(11, 10));
    }

    @Test
    void isYValid() {
        assertTrue(pelouseControl.isYValid(0, 10));
        assertFalse(pelouseControl.isYValid(-1, 10));
        assertTrue(pelouseControl.isYValid(10, 10));
        assertFalse(pelouseControl.isYValid(11, 10));
    }
}