package model;

import org.json.JSONObject;

public class Instructor {
    private String id;
    private String name;

    public Instructor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("name", name);
        return json;
    }

    public static Instructor fromJSON(JSONObject json) {
        return new Instructor(json.getString("id"), json.getString("name"));
    }
}
