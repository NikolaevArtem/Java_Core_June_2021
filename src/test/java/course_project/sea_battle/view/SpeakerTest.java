package course_project.sea_battle.view;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpeakerTest extends UnitBase {

    @Test
    void printTestHit() {
        Speaker.voice("shotHit");
        assertEquals("Hit!", getOutputLines()[0]);
    }
    @Test
    void printTestMiss() {
        Speaker.voice("shotMiss");
        assertEquals("Miss!", getOutputLines()[0]);
    }
    @Test
    void printTestNotCorrectCoordinate() {
        Speaker.voice("coordinateFalse");
        assertEquals("Not correct coordinates! Try again.", getOutputLines()[0]);
    }
    @Test
    void printTestWriteYouName() {
        Speaker.voice("dialogName");
        assertEquals("Write you Name:", getOutputLines()[0]);
    }
    @Test
    void printTestLose() {
        Speaker.voice("lose1");
        assertEquals("LOSE", getOutputLines()[0]);
    }
    @Test
    void printTestWin() {
        Speaker.voice("win");
        assertEquals("Winner:", getOutputLines()[0]);
    }
    @Test
    void printTestSuccessfully() {
        Speaker.voice("correct");
        assertEquals("Successfully", getOutputLines()[0]);
    }
    @Test
    void printTestError() {
        Speaker.voice("error");
        assertEquals("ERROR:", getOutputLines()[0]);
    }
    @Test
    void printTestShot() {
        Speaker.voice("shot");
        assertEquals("Player shot:", getOutputLines()[0]);
    }
    @Test
    void printTestQuestionPressYOrN() {
        Speaker.voice("autoGenerate");
        assertEquals("Do you want to automatically arrange the ships?", getOutputLines()[0]);
        assertEquals("Press Y-yes/N-no", getOutputLines()[1]);
    }
    @Test
    void printTestNotCorrectData() {
        Speaker.voice("notCorrect");
        assertEquals("Not correct data", getOutputLines()[0]);
    }
    @Test
    void printTestYouTurn() {
        Speaker.voice("queuePlayer");
        assertEquals("You turn, press number, a space and letter:", getOutputLines()[0]);
    }
    @Test
    void printTestTurnBot() {
        Speaker.voice("queueII");
        assertEquals("Turn Bot!", getOutputLines()[0]);
    }
    @Test
    void printTestReapeatShot() {
        Speaker.voice("repeatShot");
        assertEquals("Repeat shot;-)))", getOutputLines()[0]);
    }
    @Test
    void printTestThisCoordinateIsOccupied() {
        Speaker.voice("fieldNotEmpty");
        assertEquals("This coordinate is occupied by another ship", getOutputLines()[0]);
    }
    @Test
    void printTestYouNotCanCreateShip() {
        Speaker.voice("sizeShipBad");
        assertEquals("you can't create a ship of this size", getOutputLines()[0]);
    }
    @Test
    void printTestFirstElementLocation() {
        Speaker.voice("inputInstruction");
        assertEquals("The first element is the location of the ship vertically - 1 horizontally-2.", getOutputLines()[0]);
        assertEquals("Then a space, coordinates of the first number, a space, a letter.", getOutputLines()[1]);
        assertEquals("Space, the length of the ship. input.", getOutputLines()[2]);
    }

}