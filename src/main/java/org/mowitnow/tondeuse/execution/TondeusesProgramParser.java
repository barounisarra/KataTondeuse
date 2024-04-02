package org.mowitnow.tondeuse.execution;

import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.exceptions.InvalidFileDataException;
import org.mowitnow.tondeuse.exceptions.TondeuseException;
import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Pelouse;
import org.mowitnow.tondeuse.model.PlanDeTonte;
import org.mowitnow.tondeuse.model.Position;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TondeusesProgramParser {

    private final List<String> lines;

    public TondeusesProgramParser(String fileName, List<String> lines) {
        if (lines.isEmpty()) {
            throw new InvalidFileDataException(fileName + " est vide");
        }
        if (lines.size()%2==0) {
            throw new InvalidFileDataException(fileName + " n'admet pas un nombre de lignes pair");
        }
        this.lines = List.copyOf(lines);
    }

    public PlanDeTonte parse() {
        return new PlanDeTonte(parsePelouse(), parseInstructions());
    }

    private PelouseControl parsePelouse() {
        Pattern pattern = Pattern.compile("(\\d+) (\\d+)");
        Matcher matcher = pattern.matcher(lines.get(0));
        if (matcher.matches()) {
            int width = Integer.parseInt(matcher.group(1));
            int length = Integer.parseInt(matcher.group(2));
            Pelouse pelouse = new Pelouse(width, length);
            return new PelouseControl(pelouse);
        }
        throw new InvalidFileDataException("Impossible de parser la taille de la pelouse " + lines.get(0));
    }

    private List<TondeuseCommande> parseInstructions() {
        List<TondeuseCommande> programmeTondeuses = IntStream.range(0, lines.size() / 2)
                .mapToObj(i -> createTondeuseCommandeFromLines(lines.get(2 * i + 1), lines.get(2 * i + 2))) // Each pair of lines corresponds to a tondeuse's position/orientation and its commands, respectively
                .collect(Collectors.toList());
        return programmeTondeuses;
    }

    private TondeuseCommande createTondeuseCommandeFromLines(String positionLine, String commandLine) {
        Position position = parsePosition(positionLine);
        Orientation orientation = parseOrientation(positionLine);
        List<Instruction> commands = parserCommandesTondeuses(commandLine);
        return new TondeuseCommande(position, orientation, commands);
    }

    private Position parsePosition(String line) {
        Pattern pattern = Pattern.compile("(\\d+) (\\d+).*");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Position(x, y);
        }
        throw new TondeuseException("Impossible de parser la position " + line);
    }

    private Orientation parseOrientation(String line) {
        Pattern pattern = Pattern.compile(".* ([A-Z])");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return Orientation.fromCode(matcher.group(1));
        }
        throw new TondeuseException("Impossible de parser l'orientation " + line);
    }

    private List<Instruction> parserCommandesTondeuses(String line) {
        Pattern pattern = Pattern.compile("([A-Z]*)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            return matcher.group(0).chars().mapToObj(Character::toString).map(Instruction::fromCode).toList();
        }
        throw new TondeuseException("Impossible de parser la commande tondeuse: " + line);
    }

}
