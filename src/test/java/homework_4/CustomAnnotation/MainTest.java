package homework_4.CustomAnnotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends UnitBase {

    Main main = new Main();

    @Test
    void giveModTrue_whenRun_thenExtraMethods() {
        setInput("true");
        assertEquals("run3 - extraMethod", getOutputLines()[0]);
        assertEquals("run4 - extraMethod", getOutputLines()[1]);
    }
}