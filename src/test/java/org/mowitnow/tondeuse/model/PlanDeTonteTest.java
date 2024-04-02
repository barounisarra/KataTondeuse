package org.mowitnow.tondeuse.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.TondeuseCommande;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlanDeTonteTest {

    private PelouseControl pelouseControlMock;
    private TondeuseCommande tondeuseCommandeMock;

    @BeforeEach
    void setUp() {
        pelouseControlMock = Mockito.mock(PelouseControl.class);
        tondeuseCommandeMock = Mockito.mock(TondeuseCommande.class);
    }

    @Test
    void constructor_ValidPosition_DoesNotThrowException() {
        Position validPosition = new Position(1, 1);
        Mockito.when(tondeuseCommandeMock.getPosition()).thenReturn(validPosition);
        Mockito.when(pelouseControlMock.isPositionValide(validPosition)).thenReturn(true);

        List<TondeuseCommande> tondeuseCommandes = Collections.singletonList(tondeuseCommandeMock);

        assertDoesNotThrow(() -> new PlanDeTonte(pelouseControlMock, tondeuseCommandes));
    }

    @Test
    void constructor_InvalidPosition_ThrowsIllegalArgumentException() {
        Position invalidPosition = new Position(10, 10);
        Mockito.when(tondeuseCommandeMock.getPosition()).thenReturn(invalidPosition);
        Mockito.when(pelouseControlMock.isPositionValide(invalidPosition)).thenReturn(false);

        List<TondeuseCommande> tondeuseCommandes = Collections.singletonList(tondeuseCommandeMock);

        assertThrows(IllegalArgumentException.class, () -> new PlanDeTonte(pelouseControlMock, tondeuseCommandes));
    }

    @Test
    void constructor_MultipleTondeuses_ValidAndInvalidPositions_ThrowsIllegalArgumentException() {
        TondeuseCommande validTondeuseCommande = Mockito.mock(TondeuseCommande.class);
        Position validPosition = new Position(1, 1);
        Mockito.when(validTondeuseCommande.getPosition()).thenReturn(validPosition);
        Mockito.when(pelouseControlMock.isPositionValide(validPosition)).thenReturn(true);

        TondeuseCommande invalidTondeuseCommande = Mockito.mock(TondeuseCommande.class);
        Position invalidPosition = new Position(10, 10);
        Mockito.when(invalidTondeuseCommande.getPosition()).thenReturn(invalidPosition);
        Mockito.when(pelouseControlMock.isPositionValide(invalidPosition)).thenReturn(false);

        List<TondeuseCommande> tondeuseCommandes = Arrays.asList(validTondeuseCommande, invalidTondeuseCommande);

        assertThrows(IllegalArgumentException.class, () -> new PlanDeTonte(pelouseControlMock, tondeuseCommandes));
    }
}
