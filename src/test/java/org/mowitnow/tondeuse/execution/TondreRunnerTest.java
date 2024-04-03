package org.mowitnow.tondeuse.execution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.exceptions.InvalidFileDataException;
import org.mowitnow.tondeuse.exceptions.OutOfBoundsPositionException;
import org.mowitnow.tondeuse.exceptions.TondeuseException;
import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Pelouse;
import org.mowitnow.tondeuse.model.PlanDeTonte;
import org.mowitnow.tondeuse.model.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TondreRunnerTest {

    public static final String PATH = "src/test/resources/";


    @Nested
    @DisplayName("tondeuse rotation")
    class tondeuseRotation {

        @Test
        void given_tondeuse_orientation_nord_when_tondeuse_rotation_gauche_then_tondeuse_pointe_ouest() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, Collections.singletonList(Instruction.GAUCHE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 W");
        }

        @Test
        void given_tondeuse_orientation_est_when_tondeuse_rotation_gauche_then_tondeuse_pointe_nord() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.EAST, Collections.singletonList(Instruction.GAUCHE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 N");
        }

        @Test
        void given_tondeuse_orientation_sud_when_tondeuse_rotation_gauche_then_tondeuse_pointe_est() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.SOUTH, Collections.singletonList(Instruction.GAUCHE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 E");
        }

        @Test
        void given_tondeuse_orientation_ouest_when_tondeuse_rotation_gauche_then_tondeuse_pointe_sud() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.WEST, Collections.singletonList(Instruction.GAUCHE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 S");
        }

        @Test
        void given_tondeuse_orientation_nord_when_tondeuse_rotation_droite_then_tondeuse_pointe_est() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, Collections.singletonList(Instruction.DROITE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 E");
        }

        @Test
        void given_tondeuse_orientation_est_when_tondeuse_rotation_droite_then_tondeuse_pointe_sud() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.EAST, Collections.singletonList(Instruction.DROITE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 S");
        }

        @Test
        void given_tondeuse_orientation_sud_when_tondeuse_rotation_droite_then_tondeuse_pointe_ouest() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.SOUTH, Collections.singletonList(Instruction.DROITE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 W");
        }

        @Test
        void given_tondeuse_orientation_ouest_when_tondeuse_rotation_droite_then_tondeuse_pointe_nord() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.WEST, Collections.singletonList(Instruction.DROITE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 N");
        }

        @Test
        void given_tondeuse_orientation_nord_when_tondeuse_rotation_droite_2_fois_then_tondeuse_pointe_sud() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            List<Instruction> droiteTwice = List.of(Instruction.DROITE, Instruction.DROITE);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, droiteTwice);
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 S");
        }

        @Test
        void given_tondeuse_orientation_nord_when_tondeuse_rotation_droite_et_gauche_then_tondeuse_pointe_nord() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            List<Instruction> droiteGauche = List.of(Instruction.DROITE, Instruction.GAUCHE);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, droiteGauche);
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 N");
        }

        @Test
        void given_deux_tondeuses_orientation_nord_et_sud_when_rotation_droite_et_gauche_then_pointe_est() {
            Pelouse pelouse = new Pelouse(1, 1);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseProgram1 = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, Collections.singletonList(Instruction.DROITE));
            TondeuseCommande tondeuseProgram2 = new TondeuseCommande(new Position(0, 0), Orientation.SOUTH, Collections.singletonList(Instruction.GAUCHE));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Arrays.asList(tondeuseProgram1, tondeuseProgram2)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 E 0 0 E");
        }
    }

    @Nested
    @DisplayName("tondeuse avance")
    class tondeuseMoveForward {

        @Test
        void given_tondeuse_sur_1_1_orientation_nord_when_avancer_then_tondeuse_est_sur_1_2_nord() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(1, 1), Orientation.NORTH, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("1 2 N");
        }

        @Test
        void given_tondeuse_sur_1_1_orientation_est_when_tondeuse_avance_then_tondeuse_est_sur_2_1_est() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(1, 1), Orientation.EAST, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("2 1 E");
        }

        @Test
        void given_tondeuse_sur_1_1_orientation_sud_when_tondeuse_avance_then_tondeuse_est_sur_1_0_sud() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(1, 1), Orientation.SOUTH, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("1 0 S");
        }

        @Test
        void given_tondeuse_sur_1_1_orientation_ouest_when_tondeuse_avance_then_tondeuse_est_sur_0_1_ouest() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(1, 1), Orientation.WEST, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 1 W");
        }

        @Test
        void given_tondeuse_sur_0_0_orientation_est_when_tondeuse_avance_2_fois_then_tondeuse_est_sur_0_2_est() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            List<Instruction> avancerTwice = List.of(Instruction.AVANCER, Instruction.AVANCER);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.EAST, avancerTwice);
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("2 0 E");
        }

        @Test
        void given_a_tondeuse_sur_0_0_est_2_2_sud_when_avance_then_sont_sur_0_2_est_et_2_1_sud() {
            Pelouse pelouse = new Pelouse(2, 2);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseProgram1 = new TondeuseCommande(new Position(0, 0), Orientation.EAST, Collections.singletonList(Instruction.AVANCER));
            TondeuseCommande tondeuseProgram2 = new TondeuseCommande(new Position(2, 2), Orientation.SOUTH, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Arrays.asList(tondeuseProgram1, tondeuseProgram2)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("1 0 E 2 1 S");
        }
    }

    @Nested
    @DisplayName("tondeusene peut pas avancer")
    class tondeuseCantMoveForward {

        @Test
        void given_tondeuse_sur_0_0_orientation_nord_when_tondeuse_avance_then_tondeuse_est_sur_0_0_nord() {
            Pelouse pelouse = new Pelouse(0, 0);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.NORTH, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 N");
        }

        @Test
        void given_tondeuse_sur_0_0_orientation_est_when_tondeuse_avance_then_tondeuse_est_sur_0_0_est() {
            Pelouse pelouse = new Pelouse(0, 0);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.EAST, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 E");
        }

        @Test
        void given_tondeuse_sur_0_0_orientation_sud_when_tondeuse_avance_then_tondeuse_est_sur_0_0_sud() {
            Pelouse pelouse = new Pelouse(0, 0);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.SOUTH, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 S");
        }

        @Test
        void given_tondeuse_sur_0_0_orientation_ouest_when_tondeuse_avance_then_tondeuse_est_sur_0_0_ouest() {
            Pelouse pelouse = new Pelouse(0, 0);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(0, 0), Orientation.WEST, Collections.singletonList(Instruction.AVANCER));
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Collections.singletonList(tondeuseCommande)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("0 0 W");
        }

    }

    @Nested
    @DisplayName("instructions completes")
    class FulltondeusesPrograms {

        @Test
        void given_instructions_completes_execution_complete_then_tondeuses_sont_sur_1_3_nord_et_5_1_est() {
            Pelouse pelouse = new Pelouse(5, 5);
            PelouseControl pelouseControl = new PelouseControl(pelouse);
            List<Instruction> instructionList1 = List.of(Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE, Instruction.AVANCER, Instruction.GAUCHE,Instruction.AVANCER, Instruction.AVANCER);
            List<Instruction> instructionList2 = List.of(Instruction.AVANCER, Instruction.AVANCER, Instruction.DROITE, Instruction.AVANCER, Instruction.AVANCER, Instruction.DROITE, Instruction.AVANCER, Instruction.DROITE, Instruction.DROITE, Instruction.AVANCER);
            TondeuseCommande tondeuseProgram1 = new TondeuseCommande(new Position(1, 2), Orientation.NORTH, instructionList1);
            TondeuseCommande tondeuseProgram2 = new TondeuseCommande(new Position(3, 3), Orientation.EAST,instructionList2);
            TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, Arrays.asList(tondeuseProgram1, tondeuseProgram2)));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("1 3 N 5 1 E");
        }

    }

    @Nested
    @DisplayName("instructions completes depuis fichier")
    class FulltondeusesProgramsFromFile {

        @Test
        void given_multiples_commandes_when_lire_fichier_then_ok() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "commandes_multiples.txt"));

            String positionsTondeuse = tondreRunner.runTousProgrammesTondeuses();

            assertThat(positionsTondeuse).isEqualTo("1 3 N 5 1 E");
        }

        @Test
        void given_aucun_fichier_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "does_not_exists.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class)
                    .hasMessageContaining("src/test/resources/does_not_exists.txt n'existe pas");
        }

        @Test
        void given_fichier_vide_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "fichier_vide.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(InvalidFileDataException.class)
                    .hasMessageContaining("fichier_vide.txt est vide");
        }

        @Test
        void given_tondeuse_erreur_parssing_partielle_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "erreur_parsing_partielle.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(InvalidFileDataException.class)
                    .hasMessageContaining("src/test/resources/erreur_parsing_partielle.txt n'admet pas un nombre de lignes pair");
        }

        @Test
        void given_tondeuse_palouse_parse_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "pelouse_erreur_parsing.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(InvalidFileDataException.class)
                    .hasMessageContaining("Impossible de parser la taille de la pelouse 5 o");
        }

        @Test
        void given_tondeuse_position_parse_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "position_erreur_parsing.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class)
                    .hasMessageContaining("Impossible de parser la position 1 a N");
        }

        @Test
        void given_tondeuse_orientation_parse_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "tondeuse_orientation_erreur_parsing.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class);
        }

        @Test
        void given_tondeuse_orientation_conversion_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "tondeuse_commande_erreur_conversion.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class);
        }

        @Test
        void given_tondeuse_command_parse_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "tondeuse_commande_erreur_parsing.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class)
                    .hasMessageContaining("Impossible de parser la commande tondeuse: AADA1DADDA");
        }

        @Test
        void given_tondeuse_commande_erreur_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "tondeuse_commande_erreur_conversion.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(TondeuseException.class)
                    .hasMessageContaining("Code de l'instruction inconnu Y");
        }

        @Test
        void given_tondeuse_position_dehors_palouse_when_lire_fichier_then_erreur() {
            TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + "position_dehors_pelouse.txt"));

            assertThatThrownBy(tondreRunner::runTousProgrammesTondeuses)
                    .isInstanceOf(OutOfBoundsPositionException.class)
                    .hasMessageContaining("Position de la tondeuse 5 5 en dehors de la pelouse 2 2");
        }

    }
}