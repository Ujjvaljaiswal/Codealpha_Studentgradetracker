import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradesTracker{
    private ArrayList<Student> students;

    public StudentGradesTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

    public double calculateAverage() {
        double total = 0;
        for (Student student : students) {
            total += student.grade;
        }
        return students.size() > 0 ? total / students.size() : 0;
    }

    public double findHighestScore() {
        double highest = Double.NEGATIVE_INFINITY;
        for (Student student : students) {
            if (student.grade > highest) {
                highest = student.grade;
            }
        }
        return highest;
    }

    public double findLowestScore() {
        double lowest = Double.POSITIVE_INFINITY;
        for (Student student : students) {
            if (student.grade < lowest) {
                lowest = student.grade;
            }
        }
        return lowest;
    }

    public void displaySummary() {
        System.out.println("Summary Report:");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Grade: " + student.grade);
        }
        System.out.printf("Average Score: %.2f%n", calculateAverage());
        System.out.printf("Highest Score: %.2f%n", findHighestScore());
        System.out.printf("Lowest Score: %.2f%n", findLowestScore());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradesTracker manager = new StudentGradesTracker();

        while (true) {
            System.out.print("Enter student name (or 'exit' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            manager.addStudent(name, grade);
        }

        manager.displaySummary();
        scanner.close();
    }
}
