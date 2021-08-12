package homework_4;

import base.UnitBase;
import homework_4.custom_annotation.test_annotation.Main;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest extends UnitBase {
    @Test
    public void beforeSuiteTest() {
       new Main().start();
        assertEquals("@BeforeSuite", getOutputLines()[0]);
    }
    @Test
    public void testPriority() {
        new Main().start();
        assertEquals("test with priority 5", getOutputLines()[1]);
    }
    @Test
    public void testPriority1() {
        new Main().start();
        assertEquals("test with priority 4", getOutputLines()[2]);
    }
    @Test
    public void testPriority2() {
        new Main().start();
        assertEquals("test with priority 2", getOutputLines()[3]);
    }
    @Test
    public void testPriority3() {
        new Main().start();
        assertEquals("test with priority 1", getOutputLines()[4]);
    }
    @Test
    public void testPriority4() {
        new Main().start();
        assertEquals("@AfterSuite", getOutputLines()[5]);
    }

}
