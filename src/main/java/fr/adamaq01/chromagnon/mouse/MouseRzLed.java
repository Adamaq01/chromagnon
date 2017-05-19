package fr.adamaq01.chromagnon.mouse;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public enum MouseRzLed {

    RZLED_NONE(0),
    RZLED_SCROLLWHEEL(1),
    RZLED_LOGO(2),
    RZLED_BACKLIGHT(3),
    RZLED_SIDE_STRIP1(4),
    RZLED_SIDE_STRIP2(5),
    RZLED_SIDE_STRIP3(6),
    RZLED_SIDE_STRIP4(7),
    RZLED_SIDE_STRIP5(8),
    RZLED_SIDE_STRIP6(9),
    RZLED_SIDE_STRIP7(10),
    RZLED_SIDE_STRIP8(11),
    RZLED_SIDE_STRIP9(12),
    RZLED_SIDE_STRIP10(13),
    RZLED_SIDE_STRIP11(14),
    RZLED_SIDE_STRIP12(15),
    RZLED_SIDE_STRIP13(16),
    RZLED_SIDE_STRIP14(17),
    RZLED_ALL(0xFFFF);

    private int id;

    private MouseRzLed(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
