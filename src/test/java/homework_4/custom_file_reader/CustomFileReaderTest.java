package homework_4.custom_file_reader;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomFileReaderTest extends UnitBase {

    private final CustomFileReader reader = new CustomFileReader();

    @Test
    void test_method1() {
        new MethodTestTemplate() {
            @Override
            protected void run() {
                reader.run1();
            }
        }.process();
    }

    @Test
    void test_method2() {
        new MethodTestTemplate() {
            @Override
            protected void run() {
                reader.run2();
            }
        }.process();
    }

    @Test
    void test_method3() {
        new MethodTestTemplate() {
            @Override
            protected void run() {
                reader.run3();
            }
        }.process();
    }

    public abstract class MethodTestTemplate {

        protected abstract void run();

        protected void process() {
            run();
            String resultString = getOutput();
            assertTrue(!resultString.contains(".") && !resultString.contains(","),
                    "Result contains \".\" or \",\" or both:" + System.lineSeparator() + resultString);
        }

    }

}
