import model.Student;
import model.Course;
import model.Grade;
import service.StudentService;
import service.CourseService;
import service.GradeService;

import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static GradeService gradeService = new GradeService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. Assign Grade");
            System.out.println("3. View Transcript");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    assignGrade(scanner);
                    break;
                case 3:
                    viewTranscript(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        try {
            Student student = studentService.getStudent(studentId);
            Course course = courseService.getCourse(courseCode);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }
            if (course == null) {
                System.out.println("Course not found.");
                return;
            }

            course.enroll();
            courseService.addCourse(course);
            System.out.println("Student enrolled in course successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void assignGrade(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter grade: ");
        char grade = scanner.nextLine().charAt(0);

        try {
            Student student = studentService.getStudent(studentId);
            Course course = courseService.getCourse(courseCode);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }
            if (course == null) {
                System.out.println("Course not found.");
                return;
            }
            if (course.getEnrolled() <= 0) {
                System.out.println("Student is not enrolled in this course.");
                return;
            }

            Grade gradeEntry = new Grade(studentId, courseCode, grade);
            gradeService.addGrade(gradeEntry);
            System.out.println("Grade assigned successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewTranscript(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student student = studentService.getStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Transcript for " + student.getName());
        for (Course course : courseService.getCourses().values()) {
            Grade grade = gradeService.getGrade(studentId, course.getCode());
            if (grade != null) {
                System.out.println(course.getTitle() + ": " + grade.getGrade());
            }
        }
    }
}
