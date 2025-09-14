package ReverseWordsAdvanced;

import java.util.Scanner;

public class ReverseWordsAdvanced {

    // Utility method: reverse word order
    public static String reverseWordOrder(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    // Utility method: reverse each word individually
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }

    // Utility method: reverse word order AND each word
    public static String reverseWordOrderAndEachWord(String sentence) {
        String reversedOrder = reverseWordOrder(sentence);
        return reverseEachWord(reversedOrder);
    }

    // Display menu
    public static void displayMenu() {
        System.out.println("\n===== Sentence Reversal Program =====");
        System.out.println("1. Reverse word order");
        System.out.println("2. Reverse each word individually");
        System.out.println("3. Reverse word order AND each word");
        System.out.println("4. Exit");
        System.out.print("Choose an option (1-4): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            if (choice == 4) {
                System.out.println("Exiting... Goodbye!");
                running = false;
                break;
            }

            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            String result = "";
            switch (choice) {
                case 1:
                    result = reverseWordOrder(sentence);
                    System.out.println("Reversed word order: " + result);
                    break;
                case 2:
                    result = reverseEachWord(sentence);
                    System.out.println("Reversed each word: " + result);
                    break;
                case 3:
                    result = reverseWordOrderAndEachWord(sentence);
                    System.out.println("Reversed word order and each word: " + result);
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        }

        scanner.close();
    }
}
