import java.util.Scanner; // read keyboard input

public class QuizGrader {

    public static void printSpecs() {
        System.out.println("==============================");
        System.out.println("   Quiz Grade Calculator");
        System.out.println("==============================");
        System.out.println("This program allows a student to:");
        System.out.println("  - Enter up to 10 quiz scores");
        System.out.println("  - Calculates the average score");
        System.out.println("  - Displays the letter grade");
        System.out.println("  - Enter 999 at any time to quit");
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        printSpecs();

        Scanner scanner = new Scanner(System.in); // creates keyboard reader
        int[] grades = new int[10];  // array holding up to 10 grades
        int grade = 0; // stores the grade the user types
        int total = 0;   // running total of all grades
        int count = 0;   // how many grades entered

        System.out.print("Enter a quiz grade (999 to quit): ");
        grade = scanner.nextInt(); // reads what user types

        while (grade != 999 && count < 10) { // stop at 999 OR 10 grades
            grades[count] = grade;  // store grade in array at current position
            total += grade;         // add to running total
            count++;                // increment count

            System.out.print("Enter a quiz grade (999 to quit): ");
            grade = scanner.nextInt();
        }

        System.out.println("\n=== Grades Entered ===");
        for (int i = 0; i < count; i++) {
            System.out.println("Grade " + (i + 1) + ": " + grades[i]);
        }
        System.out.println("Total grades entered: " + count);
        System.out.println("Running total: " + total);
        double average = (double) total / count;
        System.out.printf("Average grade: %.2f%n", average);
        String letterGrade;
        // Retrieves the letter grade based on the average
        if (average >= 90) {
            letterGrade = "A";
        } else if (average >= 80) {
            letterGrade = "B";
        } else if (average >= 70) {
            letterGrade = "C";
        } else if (average >= 60) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        System.out.println("Letter grade: " + letterGrade);
        scanner.close();
    }
}