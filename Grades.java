import java.util.Scanner;

public class Grades {

    public static double calculateAverage(double[] grades) {
        double sumOfGrades = 0;
        for (double grade : grades) {
            sumOfGrades += grade;
        }
        return sumOfGrades / grades.length;
    }

    public static void enterGradesForStudent(double[][][] studentGrades, Scanner scanner, int studentIndex, String[] subjects) {
        for (int j = 0; j < studentGrades[studentIndex].length; j++) {
            System.out.print("Enter the number of grades for " + subjects[j] + ": ");
            int numGrades = scanner.nextInt();
            double[] grades = new double[numGrades];
            System.out.println("Enter grades for " + subjects[j] + ":");
            for (int k = 0; k < numGrades; k++) {
                System.out.print("Grade " + (k + 1) + ": ");
                grades[k] = scanner.nextDouble();
            }
            studentGrades[studentIndex][j] = grades;
        }
    }

    public static void printEnteredGrades(double[][][] studentGrades, String[] subjects) {
        System.out.println("\nList of entered grades for each student for each subject:");
        for (int i = 0; i < studentGrades.length; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < studentGrades[i].length; j++) {
                System.out.println(subjects[j] + ": ");
                for (double grade : studentGrades[i][j]) {
                    System.out.print(grade + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        final int numberOfSubjects = 3;
        double[][][] studentGrades = new double[numberOfStudents][numberOfSubjects][];

        String[] subjects = {"mathematics", "physics", "chemistry"};

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            enterGradesForStudent(studentGrades, scanner, i, subjects);
        }

        System.out.println("\nAverage grades for each subject for each student:");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println(subjects[j] + ": " + calculateAverage(studentGrades[i][j]));
            }
        }

        printEnteredGrades(studentGrades, subjects);

        scanner.close();
    }
}
