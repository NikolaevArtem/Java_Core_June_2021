package lesson_11.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

  public static void main(String[] args) {
    // List
    new ArrayList();
    new LinkedList<>();
    new CopyOnWriteArrayList<>(); // concurrent
    new Vector<>(); // legacy
    new Stack<>(); // legacy

    // Map
    new HashMap<>();
    new LinkedHashMap<>();
    new TreeMap<>();
    new IdentityHashMap<>();
    new ConcurrentHashMap<>(); // concurrent
    new Hashtable<>(); // legacy

    // Set
    new HashSet<>();
    new TreeSet<>();
    new LinkedHashSet<>();
    new ConcurrentSkipListSet<>(); // concurrent
    new BitSet(); // legacy

    // Queue
    new PriorityQueue<>();
    new ArrayDeque<>();
    new ArrayBlockingQueue<>(5);

  }

}
