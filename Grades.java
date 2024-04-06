import java.util.Scanner;

public class Grades {

    public static double calculateAverage(double[] grades) {
        double sumOfGrades = 0;
        for (double grade : grades) {
            sumOfGrades += grade;
        }
        return sumOfGrades / grades.length;
    }

    public static void enterGradesForStudent(double[] studentGrades, Scanner scanner) {
        for (int i = 0; i < studentGrades.length; i++) {
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            studentGrades[i] = scanner.nextDouble();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        final int numberOfSubjects = 3;
        double[][] studentGrades = new double[numberOfStudents][numberOfSubjects];

        String[] subjects = {"mathematics", "physics", "chemistry"};

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Enter the number of grades for " + subjects[j] + ": ");
                int numGrades = scanner.nextInt();
                double[] grades = new double[numGrades];
                System.out.println("Enter grades for " + subjects[j] + ":");
                enterGradesForStudent(grades, scanner);
                studentGrades[i][j] = calculateAverage(grades);
            }
        }

        System.out.println("\nAverage grades for each subject for each student:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println(subjects[j] + ": " + studentGrades[i][j]);
            }
            System.out.println("Average grade: " + calculateAverage(studentGrades[i]));
        }

        scanner.close();
    }
}
