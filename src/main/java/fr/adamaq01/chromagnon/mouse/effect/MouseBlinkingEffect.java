package fr.adamaq01.chromagnon.mouse.effect;

import fr.adamaq01.chromagnon.ColorRef;
import fr.adamaq01.chromagnon.mouse.MouseEffectType;
import fr.adamaq01.chromagnon.mouse.MouseRzLed;
import org.json.JSONObject;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public class MouseBlinkingEffect implements MouseEffect {

    private MouseRzLed led;
    private ColorRef color;

    public MouseBlinkingEffect(MouseRzLed led, ColorRef color) {
        this.led = led;
        this.color = color;
    }

    public void setLed(MouseRzLed led) {
        this.led = led;
    }

    public MouseRzLed getLed() {
        return led;
    }

    public void setColor(ColorRef color) {
        this.color = color;
    }

    public ColorRef getColor() {
        return color;
    }

    @Override
    public MouseEffectType type() {
        return MouseEffectType.CHROMA_BLINKING;
    }

    @Override
    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        JSONObject params = new JSONObject();
        params.put("ledid", this.led.getId());
        params.put("color", this.color.value());
        object.put("param", params);
        return object;
    }
}
