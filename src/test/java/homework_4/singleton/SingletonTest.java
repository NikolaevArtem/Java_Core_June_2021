package homework_4.singleton;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest extends UnitBase {


    @Test
    public void SingletonMainTest (){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Assertions.assertEquals(singleton1, singleton2);
        Assertions.assertSame(singleton1, singleton2);
    }

}
