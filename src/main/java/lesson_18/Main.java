package lesson_18;

import lombok.SneakyThrows;

public class Main {

  // https://habr.com/ru/post/164487/

  // benefits of multithreading
  // better performance
  // better resource utilization
  // better user experience
  public static void main(String[] args) throws InterruptedException {
    final Thread walk = new Thread(Thread.currentThread().getThreadGroup(), new Walk());
    final Thread talk = new Thread(Thread.currentThread().getThreadGroup(), new Talk());
    walk.start();
    talk.start();

    System.out.println("walk.getThreadGroup() = " + walk.getThreadGroup());
    System.out.println("talk.getThreadGroup() = " + talk.getThreadGroup());

//    walk.setDaemon(true);
//    talk.setDaemon(true);
//    walk.join();
//    talk.join();

    for (int i = 0; i < 5; i++) {
      System.out.println("Main thread");
      try {
      } catch (Exception e) {
        System.err.println(e);
      }
    }

  }

  private static void threadMethods() throws InterruptedException {
    Thread.sleep(200);
    Thread.activeCount();
    final Thread thread = Thread.currentThread();
    thread.start();
    thread.join();
    thread.interrupt();
    thread.yield();
    thread.run(); // only method inside
    thread.getId();
    thread.getName();
    thread.getState();
    thread.getPriority();
  }

  static class Walk extends Thread {

    public void run() {
      try {
        for (int i = 0; i < 10; i++) {
          System.out.println("Walking - " + Thread.currentThread().getName());
          Thread.sleep(200);
        }
      } catch (Exception e) {
        System.err.println(e);
      }
    }

    @SneakyThrows
    @Override
    public void interrupt() {
      throw new InterruptedException();
    }

  }

  static class Talk implements Runnable {

    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println("Talking - " + Thread.currentThread().getName());
        try {
          Thread.sleep(200);
        } catch (Exception e) {
          System.err.print(e);
        }
      }
    }
  }

}


