import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentGradeTracker {
    private static ArrayList<Integer> grades = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enterGrades();
                    break;
                case 2:
                    computeStatistics();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting Student Grade Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nStudent Grade Tracker");
        System.out.println("1. Enter Grades");
        System.out.println("2. Compute Statistics");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void enterGrades() {
        System.out.println("Enter student grades (type -1 to finish):");
        while (true) {
            int grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            grades.add(grade);
        }
    }

    private static void computeStatistics() {
        if (grades.isEmpty()) {
            System.out.println("No grades available to compute statistics.");
            return;
        }

        double average = calculateAverage(grades);
        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);

        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }

    private static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }
}
