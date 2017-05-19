package fr.adamaq01.chromagnon;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import fr.adamaq01.chromagnon.mouse.MouseLed;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Adamaq01 on 19/05/2017.
 */
public class Chromagnon {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        while(!(System.currentTimeMillis() - start > 5000)) {
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE6, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE1, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE7, new ColorRef(0, 0, 0));
            Thread.sleep(200);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE2, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE1, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE3, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE2, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE4, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE3, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE5, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE4, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE6, new ColorRef(196, 19, 178));
            Thread.sleep(50);
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE5, new ColorRef(0, 0, 0));
            Chromagnon.getInstance().setMouseColor(MouseLed.RZLED2_LEFT_SIDE7, new ColorRef(196, 19, 178));
        }
        Chromagnon.getInstance().free();
    }

    private static Chromagnon instance;

    public static Chromagnon getInstance() {
        if(instance == null) {
            instance = new Chromagnon();
        }
        return instance;
    }

    private int sessionId;
    private int[][] mouseColor;

    private Chromagnon() throws ChromagnonException {
        mouseColor = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        try {
            JSONObject initializationData = new JSONObject();
            initializationData.put("title", "Chromagnon");
            initializationData.put("description", "Java Razer Chroma SDK Bindings using Razer Chroma SDK RESTful");
            JSONObject author = new JSONObject();
            author.put("name", "Adamaq01");
            author.put("contact", "adamaq01@adamaq01.fr");
            initializationData.put("author", author);
            JSONArray device_supported = new JSONArray();
            device_supported.put("keyboard");
            device_supported.put("mouse");
            device_supported.put("headset");
            device_supported.put("mousepad");
            device_supported.put("keypad");
            device_supported.put("chromalink");
            initializationData.put("device_supported", device_supported);
            initializationData.put("category", "application");
            HttpResponse<JsonNode> response = Unirest.post("http://localhost/razer/chromasdk").header("Content-Type", "application/json").body(initializationData.toString()).asJson();
            this.sessionId = (int) response.getBody().getObject().get("sessionid");
            System.out.println("Session opened at: " + this.sessionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void heartbeat() throws ChromagnonException {
        try {
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:" + this.sessionId + "/chromasdk/heartbeat").asJson();
            int result = (int) response.getBody().getObject().get("result");
            System.out.println(ChromagnonException.errorCodeToString(result));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void free() throws ChromagnonException {
        try {
            HttpResponse<JsonNode> response = Unirest.delete("http://localhost:" + this.sessionId + "/chromasdk").asJson();
            int result = (int) response.getBody().getObject().get("result");
            System.out.println(ChromagnonException.errorCodeToString(result));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void setMouseColor(MouseLed led, ColorRef color) {
        try {
            JSONObject object = new JSONObject();
            object.put("effect", "CHROMA_CUSTOM2");
            mouseColor[led.getRow()][led.getColumn()] = color.value();
            JSONArray params = new JSONArray(mouseColor);
            object.put("param", params);
            HttpResponse<JsonNode> response = Unirest.put("http://localhost:" + this.sessionId + "/chromasdk/mouse").header("Content-Type", "application/json").body(object).asJson();
            int result = (int) response.getBody().getObject().get("result");
            System.out.println(ChromagnonException.errorCodeToString(result));
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
