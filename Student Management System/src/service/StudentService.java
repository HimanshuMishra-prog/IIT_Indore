package service;

import model.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private Map<String, Student> students = new HashMap<>();
    private final String filePath = "data/students.json";

    public StudentService() {
        loadStudents();
    }

    private void loadStudents() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                Student student = Student.fromJSON(json);
                students.put(student.getId(), student);
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    public void saveStudents() {
        JSONArray jsonArray = new JSONArray();
        for (Student student : students.values()) {
            jsonArray.put(student.toJSON());
        }
        try {
            Files.write(Paths.get(filePath), jsonArray.toString(4).getBytes());
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
        saveStudents();
    }
}
