package fr.adamaq01.chromagnon.mouse;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public enum MouseRzLed2 {

    RZLED2_SCROLLWHEEL(0x0203),
    RZLED2_LOGO(0x0703),
    RZLED2_BACKLIGHT(0x0403),
    RZLED2_LEFT_SIDE1(0x0100),
    RZLED2_LEFT_SIDE2(0x0200),
    RZLED2_LEFT_SIDE3(0x0300),
    RZLED2_LEFT_SIDE4(0x0400),
    RZLED2_LEFT_SIDE5(0x0500),
    RZLED2_LEFT_SIDE6(0x0600),
    RZLED2_LEFT_SIDE7(0x0700),
    RZLED2_BOTTOM1(0x0801),
    RZLED2_BOTTOM2(0x0802),
    RZLED2_BOTTOM3(0x0803),
    RZLED2_BOTTOM4(0x0804),
    RZLED2_BOTTOM5(0x0805),
    RZLED2_RIGHT_SIDE1(0x0106),
    RZLED2_RIGHT_SIDE2(0x0206),
    RZLED2_RIGHT_SIDE3(0x0306),
    RZLED2_RIGHT_SIDE4(0x0406),
    RZLED2_RIGHT_SIDE5(0x0506),
    RZLED2_RIGHT_SIDE6(0x0606),
    RZLED2_RIGHT_SIDE7(0x0706);

    private int id;

    private MouseRzLed2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
