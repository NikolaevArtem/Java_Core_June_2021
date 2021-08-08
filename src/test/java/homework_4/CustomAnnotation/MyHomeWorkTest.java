package homework_4.CustomAnnotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHomeWorkTest extends UnitBase {

    MyHomeWork myHomeWork = new MyHomeWork();

    @Test

    public void giveModTrue_whenRun_thenExtraMethod() {
        setInput("2");

    }

}