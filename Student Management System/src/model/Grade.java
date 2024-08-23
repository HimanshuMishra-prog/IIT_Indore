package model;

import org.json.JSONObject;

public class Grade {
    private String studentId;
    private String courseCode;
    private char grade;

    public Grade(String studentId, String courseCode, char grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public char getGrade() {
        return grade;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("studentId", studentId);
        json.put("courseCode", courseCode);
        json.put("grade", grade);
        return json;
    }

    public static Grade fromJSON(JSONObject json) {
        return new Grade(json.getString("studentId"), json.getString("courseCode"), json.getString("grade").charAt(0));
    }
}
