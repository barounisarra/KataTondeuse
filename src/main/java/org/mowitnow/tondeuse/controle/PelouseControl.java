package org.mowitnow.tondeuse.controle;

import org.mowitnow.tondeuse.model.Pelouse;
import org.mowitnow.tondeuse.model.Position;

public class PelouseControl {
    private final Pelouse pelouse;

    public PelouseControl(Pelouse pelouse) {
        this.pelouse = pelouse;
    }

    public boolean isPositionValide(Position nextPosition) {
        return isXValid(nextPosition.x(), pelouse.width()) && isYValid(nextPosition.y(), pelouse.length());
    }

    public boolean isXValid(int nextX, int maxX) {
        return 0 <= nextX && nextX <= maxX;
    }

    public boolean isYValid(int nextY, int maxY) {
        return 0 <= nextY && nextY <= maxY;
    }

    public Pelouse getPelouse() {
        return pelouse;
    }

    @Override
    public String toString() {
        return pelouse.width() + " " + pelouse.length();
    }
}
