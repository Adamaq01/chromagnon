package fr.adamaq01.chromagnon.mouse;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public enum MouseEffectType {

    CHROMA_NONE(0),
    CHROMA_BLINKING(1),
    CHROMA_BREATHING(2),
    CHROMA_CUSTOM(3),
    CHROMA_REACTIVE(4),
    CHROMA_SPECTRUMCYCLING(5),
    CHROMA_STATIC(6),
    CHROMA_WAVE(7),
    CHROMA_CUSTOM2(8),
    CHROMA_INVALID(9);

    private int id;

    private MouseEffectType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
