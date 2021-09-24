package homework_4.custom_annotation.test_annotation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
     //   new Main().start();
    }

    public void start() {
        Class c = TestClass.class;
        Method method[] = c.getDeclaredMethods();
        ArrayList<Method> arrayList = new ArrayList<>();
        Object testObj = null;
        try {
            testObj = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method method1 : method) {
            if (method1.isAnnotationPresent(TestAnnotation.class)) {
                arrayList.add(method1);
            }
            if (method1.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = method1;
                } else throw new RuntimeException("Method beforeSuite can be only one");
            }
            if (method1.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = method1;
                } else throw new RuntimeException("Method afterSuite can be only one");
            }
        }
        arrayList.sort((o1, o2) -> o2.getAnnotation(TestAnnotation.class).priority() - o1.getAnnotation(TestAnnotation.class).priority());
        if (beforeMethod != null) {
            try {
                beforeMethod.invoke(testObj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        for (Method o : arrayList) {
            try {
                o.invoke(testObj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (afterMethod != null) {
            try {
                afterMethod.invoke(testObj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

