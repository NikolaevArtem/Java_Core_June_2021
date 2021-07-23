package base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * todo Document type UnitBaseMode
 */
public abstract class UnitBaseMode extends UnitBase {

    // can be used to invoke method for object your class under test
    // 1st arg - obj your class under test, 2nd arg - called method, 3rd arg - message to remove from output
    protected void run(Object object, String methodName, String stringToDel) {
        try {
            Method method = object.getClass().getMethod(methodName);
            method.invoke(object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        removeFromOutput(stringToDel);
    }

}
