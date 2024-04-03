package org.mowitnow.tondeuse.controle;

import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Position;

import java.util.List;

public class TondeuseCommande {

    private final Position position;

    private final Orientation orientation;

    private final List<Instruction> instructions;

    public TondeuseCommande(Position position, Orientation orientation, List<Instruction> instructions) {
        this.position = position;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }
}
