package lesson_6.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

  private String s;
  private int i;

  public Cat(String s) {
    this.s = s;
  }

  public void setI(int i) {
    if (i < 0) {
      this.i = 0;
    }
    this.i = i;
  }

}
