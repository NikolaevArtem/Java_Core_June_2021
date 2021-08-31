package lesson_12_13.collections.MyLittleHashMap;

public class MyNode <K, V> {

  private K key;
  private V value;
  private MyNode<K, V> next;

  public MyNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public void setKey(K key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public MyNode<K, V> getNext() {
    return next;
  }

  public void setNext(MyNode<K, V> next) {
    this.next = next;
  }
}
