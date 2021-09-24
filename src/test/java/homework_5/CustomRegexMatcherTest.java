package homework_5;

import base.UnitBase;
import homework_5.customRegexMatcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomRegexMatcherTest extends UnitBase {

    @Test
    public void regexMailTest() {
        assertTrue(new CustomRegexMatcher().checkMail("kostya_asdsa@mail.ru"));
    }
    @Test
    public void regexMailTest2() {
        assertFalse(new CustomRegexMatcher().checkMail("kostya_asdsa@mail.r"));
    }
    @Test
    public void regexMailTest3() {
        assertFalse(new CustomRegexMatcher().checkMail("kos@gmail.com"));
    }
    @Test
    public void regexMailTest4() {
        assertTrue(new CustomRegexMatcher().checkMail("something23-as_sa@gmail.ru"));
    }
    @Test
    public void regexMailTest5() {
        assertFalse(new CustomRegexMatcher().checkMail("notvalidmail@a.com"));
    }
    @Test
    public void regexMailTest6() {
        assertTrue(new CustomRegexMatcher().checkMail("some_mail123@yandex.ru"));
    }
    @Test
    public void regexMailTest7() {
        assertFalse(new CustomRegexMatcher().checkMail("kosdf23adsamail.ru"));
    }

}
