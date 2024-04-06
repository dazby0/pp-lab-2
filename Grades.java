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
        scanner.nextLine(); 

        final int numberOfSubjects = 3;
        double[][] studentGrades = new double[numberOfStudents][numberOfSubjects];

        String[] subjects = {"mathematics", "physics", "chemistry"};

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1));
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println("Enter the grades for " + subjects[j] + " (separated by space): ");
                String[] gradesInput = scanner.nextLine().split("\\s+");
                int numberOfGrades = gradesInput.length;
                double sumOfGrades = 0;
                for (String grade : gradesInput) {
                    sumOfGrades += Double.parseDouble(grade);
                }
                studentGrades[i][j] = sumOfGrades / numberOfGrades;
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nAverage grades for student " + (i + 1) + ":");
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println(subjects[j] + ": " + studentGrades[i][j]);
            }
        }

        scanner.close();
    }
}
