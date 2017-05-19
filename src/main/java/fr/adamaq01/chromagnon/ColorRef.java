package fr.adamaq01.chromagnon;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public class ColorRef {

    private int red, green, blue;

    public ColorRef(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getRed() {
        return red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getGreen() {
        return green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getBlue() {
        return blue;
    }

    public int value() {
        return (getBlue() & 0xFF) << 16 | (getGreen() & 0xFF) << 8 | (getRed() & 0xFF);
    }
}
