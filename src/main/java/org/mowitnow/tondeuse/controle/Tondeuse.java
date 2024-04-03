package org.mowitnow.tondeuse.controle;

import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Position;

public class Tondeuse {
    private Position position;
    private Orientation orientation;

    public Tondeuse(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public void avancer(PelouseControl pelouse) {
        Position nextPosition = computeNextPosition();
        if(pelouse.isPositionValide(nextPosition)) {
            position = nextPosition;
        }
    }

    private Position computeNextPosition() {
        return switch (orientation){
            case NORTH -> position.north();
            case EAST -> position.east();
            case SOUTH -> position.south();
            case WEST -> position.west();
        };
    }

    public void gauche() {
        orientation = orientation.gauche();
    }

    public void droite() {
        orientation = orientation.droite();
    }

    @Override
    public String toString() {
        return position.toString() + " " + orientation.toString();
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
