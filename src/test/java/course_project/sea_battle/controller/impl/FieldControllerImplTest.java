package course_project.sea_battle.controller.impl;

import base.UnitBase;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldControllerImplTest extends UnitBase {

    @Test
    void InstanceMethodReturnFieldFillsWaterTest() {
        assertTrue(Arrays.stream(FieldControllerImpl.getInstance().instance().getCells())
                .flatMap(Arrays::stream)
                .allMatch(x -> x.equals(CellStatus.WATER)));
    }

    @Test
    void DrawFieldsWith1FieldTest() {
        Field waterField1 = FieldControllerImpl.getInstance().instance();
        FieldControllerImpl.getInstance().drawFields(waterField1);

        String raw1 =   "   ╔══════════╗";
        String raw2 =   "   ║ABCDEFGHIG║";
        String raw3 =   "╔══╬══════════╣";
        String raw4 =   "║ 1║~~~~~~~~~~║";
        String raw5 =   "║ 2║~~~~~~~~~~║";
        String raw6 =   "║ 3║~~~~~~~~~~║";
        String raw7 =   "║ 4║~~~~~~~~~~║";
        String raw8 =   "║ 5║~~~~~~~~~~║";
        String raw9 =   "║ 6║~~~~~~~~~~║";
        String raw10 =  "║ 7║~~~~~~~~~~║";
        String raw11 =  "║ 8║~~~~~~~~~~║";
        String raw12 =  "║ 9║~~~~~~~~~~║";
        String raw13 =  "║10║~~~~~~~~~~║";
        String raw14 =  "╚══╩══════════╝";

        assertEquals(14, getOutputLines().length);
        assertEquals(raw1.trim(), getOutputLines()[0]);
        assertEquals(raw2, getOutputLines()[1]);
        assertEquals(raw3, getOutputLines()[2]);
        assertEquals(raw4, getOutputLines()[3]);
        assertEquals(raw5, getOutputLines()[4]);
        assertEquals(raw6, getOutputLines()[5]);
        assertEquals(raw7, getOutputLines()[6]);
        assertEquals(raw8, getOutputLines()[7]);
        assertEquals(raw9, getOutputLines()[8]);
        assertEquals(raw10, getOutputLines()[9]);
        assertEquals(raw11, getOutputLines()[10]);
        assertEquals(raw12, getOutputLines()[11]);
        assertEquals(raw13, getOutputLines()[12]);
        assertEquals(raw14.trim(), getOutputLines()[13]);
    }


    @Test
    void DrawFieldsWith2FieldsTest() {

        final String raw2 =   "   ║ABCDEFGHIG║" + "\t" + "   ║ABCDEFGHIG║";
        final String raw3 =   "╔══╬══════════╣" + "\t" + "╔══╬══════════╣";
        final String raw4 =   "║ 1║~~~~~~~~~~║" + "\t" + "║ 1║X~~~~~~~~~║";
        final String raw5 =   "║ 2║~~~~~~~~~~║" + "\t" + "║ 2║~~~~~~~~~~║";


        final Field waterField1 = FieldControllerImpl.getInstance().instance();
        final Field waterField2 = FieldControllerImpl.getInstance().instance();

        waterField2.setCell(0,0, CellStatus.HIT);

        FieldControllerImpl.getInstance().drawFields(waterField1, waterField2);

        assertEquals(14, getOutputLines().length);
        assertEquals(raw2, getOutputLines()[1]);
        assertEquals(raw3, getOutputLines()[2]);
        assertEquals(raw4, getOutputLines()[3]);
        assertEquals(raw5, getOutputLines()[4]);
    }

    @Test
    void DrawFieldsWith3FieldsTest() {

        final String expected =
                   "╔══════════╗\t   ╔══════════╗\t   ╔══════════╗\n" +
                "   ║ABCDEFGHIG║\t   ║ABCDEFGHIG║\t   ║ABCDEFGHIG║\n" +
                "╔══╬══════════╣\t╔══╬══════════╣\t╔══╬══════════╣\n" +
                "║ 1║~~~~~~~~~~║\t║ 1║~~█~~~~~~~║\t║ 1║~~⊙~~~~~~~║\n" +
                "║ 2║~~~~~~~~~~║\t║ 2║~~~~~~~~~~║\t║ 2║~~~~~~~~~~║\n" +
                "║ 3║~~~~~~~~~~║\t║ 3║~~~~~~~~~~║\t║ 3║~~~~~~~~~~║\n" +
                "║ 4║~~~~~~~~~~║\t║ 4║~~~~~~~~~~║\t║ 4║~~~~~~~~~~║\n" +
                "║ 5║~~~~~~~~~~║\t║ 5║~~~~~~~~~~║\t║ 5║~~~~~~~~~~║\n" +
                "║ 6║~~~~~~~~~~║\t║ 6║~~~~~~~~~~║\t║ 6║~~~~~~~~~~║\n" +
                "║ 7║~~~~~~~~~~║\t║ 7║~~~~~~~~~~║\t║ 7║~~~~~~~~~~║\n" +
                "║ 8║~~~~~~~~~~║\t║ 8║~~~~~~~~~~║\t║ 8║~~~~~~~~~~║\n" +
                "║ 9║~~~~~~~~~~║\t║ 9║~~~~~~~~~~║\t║ 9║~~~~~~~~~~║\n" +
                "║10║~~~~~~~~~~║\t║10║~~~~~~~~~~║\t║10║~~~~~~~~~~║\n" +
                "╚══╩══════════╝\t╚══╩══════════╝\t╚══╩══════════╝";


        final Field waterField = FieldControllerImpl.getInstance().instance();
        final Field waterField2 = FieldControllerImpl.getInstance().instance();
        waterField2.setCell(2,0, CellStatus.SHIP);
        final Field waterField3 = FieldControllerImpl.getInstance().instance();
        waterField3.setCell(2,0, CellStatus.SHOT);

        FieldControllerImpl.getInstance().drawFields(waterField, waterField2, waterField3);

        assertEquals(expected, getOutput());
    }
}