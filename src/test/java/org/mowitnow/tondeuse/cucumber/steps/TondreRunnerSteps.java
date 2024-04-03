package org.mowitnow.tondeuse.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mowitnow.tondeuse.controle.PelouseControl;
import org.mowitnow.tondeuse.controle.TondeuseCommande;
import org.mowitnow.tondeuse.execution.TondreRunner;
import org.mowitnow.tondeuse.model.Instruction;
import org.mowitnow.tondeuse.model.Orientation;
import org.mowitnow.tondeuse.model.Pelouse;
import org.mowitnow.tondeuse.model.PlanDeTonte;
import org.mowitnow.tondeuse.model.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondreRunnerSteps {
    private Pelouse pelouse;
    private PelouseControl pelouseControl;
    private List<TondeuseCommande> tondeuseCommandes = new ArrayList<>();
    private String results;

    @Given("a lawn of size {int} by {int}")
    public void a_lawn_of_size_by(int width, int height) {
        this.pelouse = new Pelouse(width, height);
        this.pelouseControl = new PelouseControl(pelouse);
    }

    @Given("a mower at position {int} {int} facing {string} with instructions {string}")
    public void a_mower_at_position_facing_with_instructions(int x, int y, String orientationStr, String instructionsStr) {
        Orientation orientation = Orientation.fromCode(orientationStr);
        List<Instruction> instructionList = Arrays.stream(instructionsStr.split(""))
                .map(Instruction::fromCode)
                .collect(Collectors.toList());

        TondeuseCommande tondeuseCommande = new TondeuseCommande(new Position(x, y), orientation, instructionList);
        tondeuseCommandes.add(tondeuseCommande);
    }

    @When("I execute the mowing program")
    public void i_execute_the_mowing_program() {
        TondreRunner tondreRunner = new TondreRunner(() -> new PlanDeTonte(pelouseControl, tondeuseCommandes));
        results = tondreRunner.runTousProgrammesTondeuses();
    }

    @Then("the mower should end up at {int} {int} facing {string}")
    public void the_mower_should_end_up_at_facing(int x, int y, String orientation) {
        assertEquals(String.format("%d %d %s", x, y, orientation.charAt(0)), results);
    }

    @Then("the result should end up at {int} {int} facing {string} and {int} {int} facing {string}")
    public void the_mower_should_end_up_at_facing(int x1, int y1, String orientation1, int x2, int y2, String orientation2) {
        assertEquals(String.format("%d %d %s %d %d %s", x1, y1, orientation1, x2, y2, orientation2), results);
    }

}
