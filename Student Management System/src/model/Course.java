package model;

import org.json.JSONObject;

public class Course {
    private String code;
    private String title;
    private int capacity;
    private int enrolled;

    public Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void enroll() throws Exception {
        if (enrolled >= capacity) {
            throw new Exception("Course is full");
        }
        enrolled++;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("title", title);
        json.put("capacity", capacity);
        json.put("enrolled", enrolled);
        return json;
    }

    public static Course fromJSON(JSONObject json) {
        Course course = new Course(json.getString("code"), json.getString("title"), json.getInt("capacity"));
        course.enrolled = json.getInt("enrolled");
        return course;
    }
}
