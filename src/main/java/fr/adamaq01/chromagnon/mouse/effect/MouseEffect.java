package fr.adamaq01.chromagnon.mouse.effect;

import fr.adamaq01.chromagnon.mouse.MouseEffectType;
import org.json.JSONObject;

/**
 * Created by Adamaq01 on 19/05/17.
 */
public interface MouseEffect {

    public MouseEffectType type();

    public JSONObject toJson();
}
