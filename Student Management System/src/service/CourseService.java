package service;

import model.Course;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CourseService {
    private Map<String, Course> courses = new HashMap<>();
    private final String filePath = "data/courses.json";

    public CourseService() {
        loadCourses();
    }

    private void loadCourses() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = jsonArray.getJSONObject(i);
                Course course = Course.fromJSON(json);
                courses.put(course.getCode(), course);
            }
        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
        }
    }

    public void saveCourses() {
        JSONArray jsonArray = new JSONArray();
        for (Course course : courses.values()) {
            jsonArray.put(course.toJSON());
        }
        try {
            Files.write(Paths.get(filePath), jsonArray.toString(4).getBytes());
        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
        }
    }

    public Course getCourse(String code) {
        return courses.get(code);
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
        saveCourses();
    }

    public Map<String, Course> getCourses() {
        return courses;
    }
}
