Feature: Lawn mowing program execution
  As a user of the automatic lawn mowing system
  I want to execute mowing programs
  So that the lawn is mowed according to the provided instructions

  Scenario: Mowing a simple lawn with one move to the west
    Given a lawn of size 1 by 1
    And a mower at position 0 0 facing "N" with instructions "G"
    When I execute the mowing program
    Then the mower should end up at 0 0 facing "W"

  Scenario: Mowing a lawn with a sequence of rotations and movements
    Given a lawn of size 5 by 5
    And a mower at position 1 2 facing "N" with instructions "GAGAGAGAA"
    When I execute the mowing program
    Then the mower should end up at 1 3 facing "N"

  Scenario: Mowing a lawn with multiple mowers and different sets of instructions
    Given a lawn of size 5 by 5
    And a mower at position 1 2 facing "N" with instructions "GAGAGAGAA"
    And a mower at position 3 3 facing "E" with instructions "AADAADADDA"
    When I execute the mowing program
    Then the result should end up at 1 3 facing "N" and 5 1 facing "E"