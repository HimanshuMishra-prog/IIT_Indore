package model;

import org.json.JSONObject;

public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
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

    public static Student fromJSON(JSONObject json) {
        return new Student(json.getString("id"), json.getString("name"));
    }
}
