package Homework_1;

public class Main {
  public static void main(String[] args) {
    int k = args.length;
    if (k==0) {
      System.out.println("\033[32mApplication has been called \033[31mwithout\033[32m the arguments!!! \033[0m");
    } else {
      for (int i=0; i<=k-1;i++) {
        if (args[i].equals("error"))//не забыть написать КРАСНЫМ цветом!!!
        {
          System.out.println("\033[31mAlarm! \033[0m");//https://stackoverflow.com/questions/565252/how-to-set-a-strings-color
          break;//выходим
        }
        else {
          String s = "letter";
          if (args[i].length()>1) {s=s+"s";}
          System.out.println(args[i]+": "+args[i].length()+" "+s);
        }
      }
    }
  }
}
