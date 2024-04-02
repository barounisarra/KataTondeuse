package org.mowitnow.tondeuse.controle;

import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Position;

import java.util.Arrays;
import java.util.List;

public class TondeuseCommande {

    private final Position position;

    private final Orientation orientation;

    private final List<Instruction> instructions;

    public TondeuseCommande(Position position, Orientation orientation, Instruction... instructions) {
        this.position = position;
        this.orientation = orientation;
        if (instructions != null) { // Check if instructions is not null
            this.instructions = Arrays.asList(instructions);
        } else {
            this.instructions = Arrays.asList(); // Initialize with an empty list if instructions is null
        }    }

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
