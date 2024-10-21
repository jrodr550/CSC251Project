import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to dynamically store Policy objects
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            // Open the PolicyInformation.txt file
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);

            // Reading data from the file to create Policy objects
            while (fileScanner.hasNext()) {
                // Read each policy's information in the correct order
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                // Create a new Policy object and add it to the list
                policies.add(new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight));

                // Skip the blank line between policies, if it exists
                if (fileScanner.hasNextLine()) {
                    fileScanner.nextLine();
                }
            }

            // Close the file scanner after reading
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        // Display all policies
        for (Policy policy : policies) {
            System.out.println("\nPolicy Information:");
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height (in inches): " + policy.getHeight());
            System.out.println("Policyholder's Weight (in pounds): " + policy.getWeight());

            // Calculate and display BMI
            double bmi = policy.calculateBMI();
            System.out.printf("Policyholder's BMI: %.2f%n", bmi);

            // Calculate and display the insurance policy price
            double policyPrice = policy.calculatePolicyPrice();
            System.out.printf("Insurance Policy Price: $%.2f%n", policyPrice);
        }
    }
}
