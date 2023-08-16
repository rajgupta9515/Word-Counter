//Here is a possible Java program that implements the word counter task:

// Import the Scanner class and the File class
import java.util.Scanner;
import java.io.File;

// Define the main class
public class Word_Counter {

    // Define the main method
    public static void main(String[] args) {

        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Declare and initialize a variable for the input text
        String text = "";

        // Prompt the user to choose between entering a text or providing a file
        System.out.println("Welcome to the Word Counter!");
        System.out.println("Do you want to enter a text or provide a file?");
        System.out.println("Enter 1 for text, 2 for file, or 0 to exit.");
        int choice = input.nextInt();

        // Check the user's choice
        if (choice == 1) {
            // The user chooses to enter a text

            // Consume the newline character after the choice
            input.nextLine();

            // Prompt the user to enter the text
            System.out.println("Enter the text:");
            text = input.nextLine();

        } else if (choice == 2) {
            // The user chooses to provide a file

            // Consume the newline character after the choice
            input.nextLine();

            // Prompt the user to enter the file name
            System.out.println("Enter the file name:");
            String fileName = input.nextLine();

            try {
                // Create a File object for reading the file
                File file = new File(fileName);

                // Create a Scanner object for scanning the file
                Scanner fileInput = new Scanner(file);

                // Read the file and append its contents to the text variable
                while (fileInput.hasNextLine()) {
                    text += fileInput.nextLine() + "\n";
                }

                // Close the file scanner
                fileInput.close();

            } catch (Exception e) {
                // Handle any file errors
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }

        } else if (choice == 0) {
            // The user chooses to exit

            // Print a farewell message and end the program
            System.out.println("Thank you for using the Word Counter!");
            return;

        } else {
            // The user enters an invalid choice

            // Print an error message and end the program
            System.out.println("Invalid choice. Please enter 1, 2, or 0.");
            return;
        }

        // Check if the text is empty
        if (text.isEmpty()) {
            // Print an error message and end the program
            System.out.println("No text entered or found in the file.");
            return;
        }

        // Split the text into an array of words using space or punctuation as delimiters
        String[] words = text.split("[\\s.,;:!?\"'()\\[\\]{}]+");

        // Initialize a counter variable to keep track of the number of words
        int count = 0;

        // Iterate through the array of words and increment the counter for each word encountered
        for (String word : words) {
            count++;
        }

        // Display the total count of words to the user
        System.out.println("The total number of words is: " + count);
    }
}
