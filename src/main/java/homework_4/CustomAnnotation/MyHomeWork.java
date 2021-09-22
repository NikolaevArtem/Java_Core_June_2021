package homework_4.CustomAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyHomeWork {

    public void run1(){
        System.out.println("run1 - simpleMethod");
    }

    public void run2(){
        System.out.println("run2 - simpleMethod");
    }

    @Extra
    public void run3(){
        System.out.println("run3 - extraMethod");
    }

    @Extra
    public void run4(){
        System.out.println("run4 - extraMethod");
    }

    public void execute() {
        Class<MyHomeWork> myHW = MyHomeWork.class;

        System.out.println("Choose mod Extra/Simple : [extra/simple]");
        boolean mod = giveMod();

        for (Method method : myHW.getDeclaredMethods()) {
            if (!method.getName().equals("execute") && !method.getName().equals("giveMod")) {
                if (mod == method.isAnnotationPresent(Extra.class)) {
                    try {
                        method.invoke(myHW.newInstance());
                    } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean giveMod() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String mod = bufferedReader.readLine();
            if (mod.equals("simple")) {
                return false;
            }

            if (mod.equals("extra")) {
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
