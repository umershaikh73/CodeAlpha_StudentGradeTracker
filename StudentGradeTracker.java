import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    // Constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Input details for each student
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // clear input buffer
            System.out.print("Enter name of student " + (i+1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();

            students.add(new Student(name, marks));
        }

        // Calculate average, highest, and lowest marks
        int totalMarks = 0;
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            totalMarks += s.marks;

            if (s.marks > highestMarks) {
                highestMarks = s.marks;
                topStudent = s.name;
            }

            if (s.marks < lowestMarks) {
                lowestMarks = s.marks;
                lowStudent = s.name;
            }
        }

        double average = (double) totalMarks / n;

        // Display summary report
        System.out.println("\n===== Student Summary Report =====");
        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
        }

        System.out.println("\nAverage Marks: " + average);
        System.out.println("Highest Marks: " + highestMarks + " (by " + topStudent + ")");
        System.out.println("Lowest Marks: " + lowestMarks + " (by " + lowStudent + ")");

        sc.close();
    }
}
