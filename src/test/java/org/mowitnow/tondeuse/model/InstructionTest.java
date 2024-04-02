package org.mowitnow.tondeuse.model;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.Tondeuse;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InstructionTest {

    @Test
    public void fromCode_ValidCodes_ReturnsCorrectInstructions() {
        assertEquals(Instruction.AVANCER, Instruction.fromCode("A"), "'A' should correspond to AVANCER");
        assertEquals(Instruction.GAUCHE, Instruction.fromCode("G"), "'G' should correspond to GAUCHE");
        assertEquals(Instruction.DROITE, Instruction.fromCode("D"), "'D' should correspond to DROITE");
    }

    @Test
    public void fromCode_InvalidCode_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Instruction.fromCode("X"), "'X' is an invalid code and should throw an exception");
    }

    @Test
    public void accept_Avancer_CallsTondeuseAvancer() {
        Tondeuse mockTondeuse = Mockito.mock(Tondeuse.class);
        PelouseControl mockPelouseControl = Mockito.mock(PelouseControl.class);

        assertDoesNotThrow(() -> Instruction.AVANCER.accept(mockTondeuse, mockPelouseControl));
        Mockito.verify(mockTondeuse, Mockito.times(1)).avancer(mockPelouseControl);
    }

    @Test
    public void accept_Gauche_CallsTondeuseGauche() {
        Tondeuse mockTondeuse = Mockito.mock(Tondeuse.class);
        PelouseControl mockPelouseControl = Mockito.mock(PelouseControl.class);

        assertDoesNotThrow(() -> Instruction.GAUCHE.accept(mockTondeuse, mockPelouseControl));
        Mockito.verify(mockTondeuse, Mockito.times(1)).gauche();
    }

    @Test
    public void accept_Droite_CallsTondeuseDroite() {
        Tondeuse mockTondeuse = Mockito.mock(Tondeuse.class);
        PelouseControl mockPelouseControl = Mockito.mock(PelouseControl.class);

        assertDoesNotThrow(() -> Instruction.DROITE.accept(mockTondeuse, mockPelouseControl));
        Mockito.verify(mockTondeuse, Mockito.times(1)).droite();
    }
}
