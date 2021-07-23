package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraPyramidPrinterTest extends UnitBase{



    @Test
    public void givenArgsForChangeBricksAndSymmetricMode_whenRun_thenPrint() {
        setInput("3");
        String[] args = new String[]{"-brick", "aAa", "-mode", "symmetric"};
        new PyramidPrinter(args).run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("aAa      ", getOutputLines()[0]);
        assertEquals("   aAaaAaaAa   ", getOutputLines()[1]);
        assertEquals("aAaaAaaAaaAaaAa", getOutputLines()[2]);
    }

    @Test
    public void givenArgsForChangeBricksAndRigthSideMode_whenRun_thenPrint() {
        setInput("5");
        String[] args = new String[]{"-mode", "rightSide", "-brick", "Java"};
        new PyramidPrinter(args).run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("Java", getOutputLines()[0]);
        assertEquals("            JavaJava", getOutputLines()[1]);
        assertEquals("        JavaJavaJava", getOutputLines()[2]);
        assertEquals("    JavaJavaJavaJava", getOutputLines()[3]);
        assertEquals("JavaJavaJavaJavaJava", getOutputLines()[4]);
    }

    @Test
    public void givenArgsForChangeBricksAndInverseMode_whenRun_thenPrint() {
        setInput("10");
        String[] args = new String[]{"-mode", "inverse", "-brick", "O"};
        new PyramidPrinter(args).run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("OOOOOOOOOO", getOutputLines()[0]);
        assertEquals("OOOOOOOOO ", getOutputLines()[1]);
        assertEquals("OOOOOOOO  ", getOutputLines()[2]);
        assertEquals("OOOOOOO   ", getOutputLines()[3]);
        assertEquals("OOOOOO    ", getOutputLines()[4]);
        assertEquals("OOOOO     ", getOutputLines()[5]);
        assertEquals("OOOO      ", getOutputLines()[6]);
        assertEquals("OOO       ", getOutputLines()[7]);
        assertEquals("OO        ", getOutputLines()[8]);
        assertEquals("O", getOutputLines()[9]);
    }
}
