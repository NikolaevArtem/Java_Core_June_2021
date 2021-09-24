package course_project;

import base.UnitBase;
import org.junit.jupiter.api.Test;


import static course_project.seaBattle.Game.checkWin;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Main extends UnitBase {

    @Test
    public void testChechWinMethod1() {
       assertTrue(checkWin(20,20));
    }
    @Test
    public void testChechWinMethod2()  {
        assertFalse(checkWin(0,0));
    }
    @Test
    public void testChechWinMethod3() {
        assertTrue(checkWin(10,3));
    }

    @Test
    public void testChechWinMethod4() {
        assertFalse(checkWin(0,3));
    }

}
