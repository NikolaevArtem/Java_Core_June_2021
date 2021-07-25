package homework_3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ImmutableWorkerTest {

    @Test
    void testIfImmutable() {
        List<String> testList = new ArrayList<>();
        Age age = new Age(13, 5, 1980);
        ImmutableWorker worker = new ImmutableWorker("Jones", "Marketing", 874, testList, age);
        assertNotEquals(worker, worker.updateWorker("null", "Sales", 0, null, null));
    }
}
