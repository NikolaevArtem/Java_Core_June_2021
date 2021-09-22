package homework_4.CustomAnnotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHomeWorkTest extends UnitBase {

    MyHomeWork myHomeWork = new MyHomeWork();

    @Test
    void giveModTrue_whenRun_thenExtraMethods() {
        setInput("extra");
        myHomeWork.execute();
        removeFromOutput("Choose mod Extra/Simple : [extra/simple]");
        assertEquals("run3 - extraMethod", getOutputLines()[0]);
        assertEquals("run4 - extraMethod", getOutputLines()[1]);
    }

    @Test
    void giveModFalse_whenRun_thenSimpleMethods() {
        setInput("simple");
        myHomeWork.execute();
        removeFromOutput("Choose mod Extra/Simple : [extra/simple]");
        assertEquals("run1 - simpleMethod", getOutputLines()[0]);
        assertEquals("run2 - simpleMethod", getOutputLines()[1]);
    }
}