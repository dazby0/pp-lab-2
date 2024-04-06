import java.util.Scanner;

public class Grades {
    
    public static double calculateAverage(double[] grades) {
        double sumOfGrades = 0;
        for (double grade : grades) {
            sumOfGrades += grade;
        }
        return sumOfGrades / grades.length;
    }
    
    public static void enterGrades(Scanner scanner, double[] studentGrades, String subject) {
        System.out.println("Enter the grades for " + subject + " (separated by space): ");
        String input = scanner.nextLine().trim(); // Usuwa białe znaki z końca
        if (input.endsWith(" ")) {
            input = input.substring(0, input.length() - 1); // Usuwa ostatnią spację
        }
        String[] gradesInput = input.split("\\s+");
        for (int i = 0; i < gradesInput.length; i++) {
            studentGrades[i] = Double.parseDouble(gradesInput[i]);
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
                enterGrades(scanner, studentGrades[i], subjects[j]);
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nAverage grades for student " + (i + 1) + ":");
            for (int j = 0; j < numberOfSubjects; j++) {
                System.out.println(subjects[j] + ": " + calculateAverage(studentGrades[i]));
            }
        }

        scanner.close();
    }
}
