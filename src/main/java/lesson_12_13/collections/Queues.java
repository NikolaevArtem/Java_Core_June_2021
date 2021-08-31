package lesson_12_13.collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {

  public static void main(String[] args) {
    queueMethodsImpl();
    new ArrayDeque<>();
  }

//    private static void queueMethods() {
//    Queue<String> queue = new Queue();
//    queue.element();
//    queue.offer("");
//    queue.peek();
//    queue.poll();
//    queue.remove();
//  }

  private static void queueMethodsImpl() {
    System.out.println("--------------add -> offer--------------");
    Queue<String> queue = new PriorityQueue<>(); // FIFO
    System.out.println("queue.offer(A) = " + queue.offer("A"));
    System.out.println("Current queue state A - " + queue);
    queue.offer("E");
    System.out.println("Current queue state E - " + queue);
    queue.offer("D");
    System.out.println("Current queue state D - " + queue);
    queue.offer("C");
    System.out.println("Current queue state C - " + queue);
    queue.offer("B");
    System.out.println("Current queue state B - " + queue);
    System.out.println("--------------check -> element/peek--------------");
    System.out.println("queue.peek() = " + queue.peek()); // no ex in case of empty queue
    System.out.println("queue.element() = " + queue.element());
    System.out.println("Current queue state - " + queue);
//    System.out.println("--------------get -> poll--------------");
//    System.out.println("queue.poll() = " + queue.poll());
//    System.out.println("Current queue state - " + queue);
//    System.out.println("queue.poll() = " + queue.poll());
//    System.out.println("Current queue state - " + queue);
//    System.out.println("queue.poll() = " + queue.poll());
//    System.out.println("Current queue state - " + queue);
//    System.out.println("queue.poll() = " + queue.poll());
//    System.out.println("Current queue state - " + queue);
    System.out.println("--------------remove--------------");
    System.out.println("queue.remove() = " + queue.remove());
    System.out.println("Current queue state - " + queue);
  }


}
