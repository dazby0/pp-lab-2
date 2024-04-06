import java.util.Scanner;

public class Grades {
    
    public static double calculateAverage(double[] grades) {
        double sumOfGrades = 0;
        for (double grade : grades) {
            sumOfGrades += grade;
        }
        return sumOfGrades / grades.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character left by nextInt()

        final int numberOfSubjects = 3;
        double[][] studentGrades = new double[numberOfStudents][numberOfSubjects];

        String[] subjects = {"mathematics", "physics", "chemistry"};

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.print("Enter the grade for " + subjects[j] + ": ");
                studentGrades[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nAverage grade for student " + (i + 1) + ": " + calculateAverage(studentGrades[i]));
        }

        scanner.close();
    }
}
