package lesson_14.serialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// https://javarush.ru/groups/posts/2022-serializacija-i-deserializacija-v-java
public class Main {

  public static void main(String[] args) throws Exception {
//    final Cat cat = new Cat("Murzik", 5, Color.ORANGE, new Kitten("Pretty", 1));
//    final ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serialized.txt"));
//    out.writeObject(cat);

    final ObjectInputStream in = new ObjectInputStream(new FileInputStream("serialized.txt"));
    final Cat deserializedCat = (Cat) in.readObject();
    System.out.println(deserializedCat);
  }

}
