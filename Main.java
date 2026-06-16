import java.util.ArrayList;
import java.util.Scanner;

// A simple class to represent a Student
class Student {
    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Course: " + course;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Student Record Management System ===");
        
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // ADD STUDENT FEATURE
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    
                    students.add(new Student(id, name, course));
                    System.out.println("Student added successfully!");
                    break;

                case 2: // VIEW ALL STUDENTS FEATURE
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3: // SEARCH STUDENT FEATURE
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.id == searchId) {
                            System.out.println("Student Found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student with ID " + searchId + " not found.");
                    break;

                case 4: // DELETE STUDENT FEATURE
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).id == deleteId) {
                            students.remove(i);
                            System.out.println("Student record deleted.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) System.out.println("Student with ID " + deleteId + " not found.");
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
                                 }
