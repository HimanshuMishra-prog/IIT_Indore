package service;

import model.Grade;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GradeService {
    private Map<String, Map<String, Grade>> grades = new HashMap<>();
    private final String filePath = "data/grades.json";

    public GradeService() {
        loadGrades();
    }

    private void loadGrades() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                Grade grade = Grade.fromJSON(json);
                grades.computeIfAbsent(grade.getStudentId(), k -> new HashMap<>()).put(grade.getCourseCode(), grade);
            }
        } catch (IOException e) {
            System.out.println("Error loading grades: " + e.getMessage());
        }
    }

    public void saveGrades() {
        JSONArray jsonArray = new JSONArray();
        for (Map<String, Grade> courseGrades : grades.values()) {
            for (Grade grade : courseGrades.values()) {
                jsonArray.put(grade.toJSON());
            }
        }
        try {
            Files.write(Paths.get(filePath), jsonArray.toString(4).getBytes());
        } catch (IOException e) {
            System.out.println("Error saving grades: " + e.getMessage());
        }
    }

    public Grade getGrade(String studentId, String courseCode) {
        return grades.getOrDefault(studentId, new HashMap<>()).get(courseCode);
    }

    public void addGrade(Grade grade) {
        grades.computeIfAbsent(grade.getStudentId(), k -> new HashMap<>()).put(grade.getCourseCode(), grade);
        saveGrades();
    }
}
