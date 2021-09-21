package homework_3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableTaskTest {

    @Test
    void test_NameIsChanged() {

        ImmutableTask task = new ImmutableTask("Immutable class");

        ImmutableTask taskAfterChangeName = task.changeName("new name here!!!");
        assertEquals(taskAfterChangeName.getName(), "new name here!!!");

    }

    @Test
    void test_ReturnsNewObjectAfterChangeName() {

        ImmutableTask task = new ImmutableTask("Immutable class");

        ImmutableTask taskAfterChangeName = task.changeName("new name here!!!");
        assertNotEquals(task, taskAfterChangeName);

    }

    @Test
    void test_changeAdditionalInfoField() {

        String[] info = {"homework_3", "EPAM june 2021"};
        ImmutableTask task = new ImmutableTask("Immutable class",
                "Implement immutable class",
                50,
                info);

        String[] newArray = task.getAdditionalInfo();
        newArray[1] = "EPAM Java core 06/2021";
        assertEquals(task.getAdditionalInfo()[1], info[1]);

    }
}