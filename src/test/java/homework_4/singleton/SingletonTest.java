package homework_4.singleton;

import base.UnitBase;
import homework_4.singleton.Singleton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonTest extends UnitBase {

    @Test
    void getInstance() {
        Singleton singletonInstance1 = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();
        Assertions.assertSame(singletonInstance1, singletonInstance2);
    }
}