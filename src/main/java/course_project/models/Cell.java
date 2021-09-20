/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_project.models;


public class Cell {
    private char letter;
    private int digit;
    private boolean beaten;

    public Cell() {
    }

    public Cell(char letter, int digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public boolean isBeaten() {
        return beaten;
    }

    public void setBeaten(boolean beaten) {
        this.beaten = beaten;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (this.letter != other.letter) {
            return false;
        }
        if (this.digit != other.digit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "letter=" + letter +
                ", digit=" + digit +
                ", beaten=" + beaten +
                '}';
    }
}
