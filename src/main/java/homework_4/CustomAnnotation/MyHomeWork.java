package homework_4.CustomAnnotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class MyHomeWork {

    public void execute() throws IOException {
        System.out.println("Choose mod Extra/Simple : [true/false]");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean extraMod = Boolean.parseBoolean(bufferedReader.readLine());

        Class<MyHomeWork> myHW = MyHomeWork.class;
        for (Method method : myHW.getDeclaredMethods()) {
            if (extraMod == method.isAnnotationPresent(Extra.class)) {
                try {
                    method.invoke(myHW.newInstance());
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }

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


}
