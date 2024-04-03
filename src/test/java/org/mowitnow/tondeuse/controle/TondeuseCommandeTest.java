package org.mowitnow.tondeuse.controle;

import org.junit.jupiter.api.Test;
import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Position;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TondeuseCommandeTest {

    @Test
    public void constructorWithVarargs_ShouldCorrectlyAssignFields() {
        Position expectedPosition = new Position(1, 2);
        Orientation expectedOrientation = Orientation.NORTH;
        List<Instruction> expectedInstructions = List.of(Instruction.AVANCER, Instruction.DROITE);

        TondeuseCommande commande = new TondeuseCommande(expectedPosition, expectedOrientation, expectedInstructions);

        assertEquals(expectedPosition, commande.getPosition());
        assertEquals(expectedOrientation, commande.getOrientation());
        assertTrue(expectedInstructions.containsAll(commande.getInstructions()));
    }

    @Test
    public void constructorWithList_ShouldCorrectlyAssignFields() {
        Position expectedPosition = new Position(3, 4);
        Orientation expectedOrientation = Orientation.EAST;
        List<Instruction> expectedInstructions = Arrays.asList(Instruction.AVANCER, Instruction.GAUCHE);

        TondeuseCommande commande = new TondeuseCommande(expectedPosition, expectedOrientation, expectedInstructions);

        assertEquals(expectedPosition, commande.getPosition());
        assertEquals(expectedOrientation, commande.getOrientation());
        assertEquals(expectedInstructions, commande.getInstructions());
    }

    @Test
    public void getPosition_ShouldReturnCorrectPosition() {
        Position expectedPosition = new Position(5, 5);
        TondeuseCommande commande = new TondeuseCommande(expectedPosition, Orientation.SOUTH, null);

        assertEquals(expectedPosition, commande.getPosition());
    }

    @Test
    public void getOrientation_ShouldReturnCorrectOrientation() {
        Orientation expectedOrientation = Orientation.WEST;
        TondeuseCommande commande = new TondeuseCommande(new Position(1, 1), expectedOrientation, null);

        assertEquals(expectedOrientation, commande.getOrientation());
    }

    @Test
    public void getInstructions_ShouldReturnCorrectInstructions() {
        List<Instruction> expectedInstructions = Arrays.asList(Instruction.DROITE, Instruction.GAUCHE);
        TondeuseCommande commande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, expectedInstructions);

        assertEquals(expectedInstructions, commande.getInstructions());
    }
}
