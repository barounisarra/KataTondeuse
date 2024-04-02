package org.mowitnow.tondeuse.model;

import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.Tondeuse;
import org.mowitnow.tondeuse.exceptions.TondeuseException;

import java.util.Arrays;
import java.util.function.BiConsumer;

public enum Instruction implements BiConsumer<Tondeuse, PelouseControl> {

    AVANCER("A", Tondeuse::avancer),

    GAUCHE("G", (tondeuse, pelouse) -> tondeuse.gauche()),

    DROITE("D", (tondeuse, pelouse) -> tondeuse.droite());

    private final String operation;
    private final BiConsumer<Tondeuse, PelouseControl> instruction;

    Instruction(String operation, BiConsumer<Tondeuse, PelouseControl> instruction) {
        this.operation = operation;
        this.instruction = instruction;
    }

    public static Instruction fromCode(String operation) {
        return Arrays.stream(Instruction.values())
                .filter(orientation -> orientation.operation.equals(operation))
                .findFirst().orElseThrow(() -> new TondeuseException("Code de l'instruction inconnu " + operation));
    }

    @Override
    public void accept(Tondeuse tondeuse, PelouseControl pelouseControl) {
        instruction.accept(tondeuse, pelouseControl);
    }
}
