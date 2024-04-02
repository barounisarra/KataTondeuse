package org.mowitnow.tondeuse.execution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.exceptions.InvalidFileDataException;
import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.PlanDeTonte;
import org.mowitnow.tondeuse.model.Position;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TondeusesProgramParserTest {

    private TondeusesProgramParser parser;

    @BeforeEach
    void setUp() {
        List<String> lines = Arrays.asList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );
        parser = new TondeusesProgramParser("testFileName", lines);
    }

    @Test
    void parse_ValidInput_CreatesExpectedPlanDeTonte() {
        PlanDeTonte plan = parser.parse();

        assertNotNull(plan);
        assertNotNull(plan.pelouseControl());
        assertEquals(5, plan.pelouseControl().getPelouse().width());
        assertEquals(5, plan.pelouseControl().getPelouse().length());

        List<TondeuseCommande> commandes = plan.programmeTondeuses();
        assertNotNull(commandes);
        assertEquals(2, commandes.size());

        TondeuseCommande firstCommande = commandes.get(0);
        Assertions.assertEquals(new Position(1, 2), firstCommande.getPosition());
        Assertions.assertEquals(Orientation.NORTH, firstCommande.getOrientation());
        assertEquals(Arrays.asList(Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER, Instruction.AVANCER), firstCommande.getInstructions());

        TondeuseCommande secondCommande = commandes.get(1);
        Assertions.assertEquals(new Position(3, 3), secondCommande.getPosition());
        Assertions.assertEquals(Orientation.EAST, secondCommande.getOrientation());
        assertEquals(Arrays.asList(Instruction.AVANCER, Instruction.AVANCER, Instruction.DROITE, Instruction.AVANCER, Instruction.AVANCER, Instruction.DROITE, Instruction.AVANCER, Instruction.DROITE, Instruction.DROITE, Instruction.AVANCER), secondCommande.getInstructions());
    }

    @Test
    void parse_EmptyLines_ThrowsIllegalArgumentException() {
        InvalidFileDataException thrown = assertThrows(InvalidFileDataException.class, () -> new TondeusesProgramParser("emptyFile", Arrays.asList()));
        assertEquals("emptyFile est vide", thrown.getMessage());
    }

    @Test
    void parse_EvenNumberOfLines_ThrowsIllegalArgumentException() {
        InvalidFileDataException thrown = assertThrows(InvalidFileDataException.class, () -> new TondeusesProgramParser("evenFile", Arrays.asList("5 5", "1 2 N")));
        assertEquals("evenFile n'admet pas un nombre de lignes pair", thrown.getMessage());
    }
}
