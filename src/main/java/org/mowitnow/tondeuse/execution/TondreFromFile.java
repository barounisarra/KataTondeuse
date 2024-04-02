package org.mowitnow.tondeuse.execution;

import org.mowitnow.tondeuse.controle.PlansDeTonte;
import org.mowitnow.tondeuse.exceptions.InvalidFileDataException;
import org.mowitnow.tondeuse.exceptions.TondeuseException;
import org.mowitnow.tondeuse.model.PlanDeTonte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TondreFromFile implements PlansDeTonte {

    private final String fileName;

    public TondreFromFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public PlanDeTonte get() {
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return new TondeusesProgramParser(fileName, lines).parse();
        } catch (FileNotFoundException f) {
            throw new TondeuseException(fileName + " n'existe pas");
        } catch (IOException e) {
            throw new InvalidFileDataException("error while reading " + fileName);
        }
    }


}
