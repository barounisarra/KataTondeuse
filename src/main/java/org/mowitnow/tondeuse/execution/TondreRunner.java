package org.mowitnow.tondeuse.execution;

import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.PlansDeTonte;
import org.mowitnow.tondeuse.controle.Tondeuse;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.model.PlanDeTonte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TondreRunner {

    private final PlansDeTonte plansDeTonte;

    private final List<Tondeuse> tondeuses = new ArrayList<>();

    public TondreRunner(PlansDeTonte plansDeTonte) {
        this.plansDeTonte = plansDeTonte;
    }

    public String runTousProgrammesTondeuses() {
        PlanDeTonte planDeTonte = plansDeTonte.get();
        planDeTonte.programmeTondeuses().forEach(programmeTondeuse -> runProgrammeTondeuse(programmeTondeuse, planDeTonte.pelouseControl()));
        return tondeuses.stream().map(Tondeuse::toString).collect(Collectors.joining(" "));
    }

    private void runProgrammeTondeuse(TondeuseCommande programmeTondeuse, PelouseControl pelouseControl) {
        Tondeuse tondeuse = new Tondeuse(programmeTondeuse.getPosition(), programmeTondeuse.getOrientation());
        programmeTondeuse.getInstructions().forEach(instruction -> instruction.accept(tondeuse, pelouseControl));
        tondeuses.add(tondeuse);
    }
}
