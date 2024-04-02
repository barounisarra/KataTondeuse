package org.mowitnow.tondeuse.model;

import org.mowitnow.tondeuse.exceptions.TondeuseException;

import java.util.Arrays;

public enum Orientation {
    NORTH("N") {
        @Override
        public Orientation gauche() {
            return WEST;
        }

        @Override
        public Orientation droite() {
            return EAST;
        }
    },

    EAST("E") {
        @Override
        public Orientation gauche() {
            return NORTH;
        }

        @Override
        public Orientation droite() {
            return SOUTH;
        }
    },

    SOUTH("S") {
        @Override
        public Orientation gauche() {
            return EAST;
        }

        @Override
        public Orientation droite() {
            return WEST;
        }
    },

    WEST("W") {
        @Override
        public Orientation gauche() {
            return SOUTH;
        }

        @Override
        public Orientation droite() {
            return NORTH;
        }
    };

    private final String code;

    Orientation(String code) {
        this.code = code;
    }

    public static Orientation fromCode(String code) {
        return Arrays.stream(Orientation.values())
                .filter(orientation -> orientation.code.equals(code))
                .findFirst().orElseThrow(() -> new TondeuseException("Code de l'orientation inconnu" + code));
    }


    public abstract Orientation gauche();

    public abstract Orientation droite();

    @Override
    public String toString() {
        return this.code;
    }
}
