package lesson_12_13.collections.MyLittleHashMap;

public class MyLittleHashMap <K, V> {

  private MyNode<K, V>[] nodes;

  // не хватает: расширение (grow) + переменная size
  // уникальность ключей
  // remove и оптимизация памяти/времени доступа
  public MyLittleHashMap() {
    nodes = new MyNode[16];
  }

  public void put(K key, V value) {
    final int bucket = key.hashCode() % 16;
    if (nodes[bucket] == null) {
      nodes[bucket] = new MyNode<>(key, value);
    } else {
      final MyNode<K, V> previous = nodes[bucket];
      final MyNode<K, V> newOne = new MyNode<>(key, value);
      previous.setNext(newOne);
    }
  }

  public V get(K key) {
    final int bucket = key.hashCode() % 16;
    MyNode<K, V> node = nodes[bucket];
    while (node.getNext() != null) {
      if (key.equals(node.getKey())) {
        return node.getValue();
      } else {
        node = node.getNext();
      }
    }
    return null;
  }

  public void remove(K key) {
    for (int i = 0; i < nodes.length; i++) {
      if (key.equals(nodes[i].getKey())) {
        nodes[i] = null;
      }
    }
  }

}
