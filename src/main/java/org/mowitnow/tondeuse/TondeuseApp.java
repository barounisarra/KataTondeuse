package org.mowitnow.tondeuse;

import org.mowitnow.tondeuse.execution.TondreFromFile;
import org.mowitnow.tondeuse.execution.TondreRunner;

public class TondeuseApp {

    public static final String PATH = "src/main/resources/";



    public static void main(String... args) {


        if (args.length != 1) {
            throw new IllegalArgumentException("argument file name is missing");
        }

        TondreRunner tondreRunner = new TondreRunner(new TondreFromFile(PATH + args[0]));
        System.out.println(" result = " + tondreRunner.runTousProgrammesTondeuses());

    }
}
