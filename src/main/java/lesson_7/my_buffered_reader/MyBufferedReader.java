package lesson_7.my_buffered_reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends BufferedReader {

  public MyBufferedReader(Reader in, int sz) {
    super(in, sz);
  }

  public MyBufferedReader(Reader in) {
    super(in);
  }

  @Override
  public String readLine() {
    try {
      return super.readLine().trim();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "";
  }

  @Override
  public void close() throws IOException {
    System.out.println("Stream is closed");
    super.close();
  }

  public int readInt() {
    try {
    return Integer.parseInt(this.readLine());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

}
