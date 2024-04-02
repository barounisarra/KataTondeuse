package org.mowitnow.tondeuse.model;

import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.exceptions.OutOfBoundsPositionException;

import java.util.List;

public record PlanDeTonte(PelouseControl pelouseControl, List<TondeuseCommande> programmeTondeuses) {
    public PlanDeTonte {
        programmeTondeuses.forEach(programmeTondeuse -> isPositionDeDepartValide(pelouseControl, programmeTondeuse));
    }

    private void isPositionDeDepartValide(PelouseControl pelouseControl, TondeuseCommande programmeTondeuse) throws OutOfBoundsPositionException {
        if (!pelouseControl.isPositionValide(programmeTondeuse.getPosition())) {
            throw new OutOfBoundsPositionException("Position de la tondeuse " + programmeTondeuse.getPosition() + " en dehors de la pelouse " + pelouseControl);
        }
    }
}