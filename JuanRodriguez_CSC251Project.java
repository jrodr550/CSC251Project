import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList to dynamically store Policy objects
        ArrayList<Policy> policies = new ArrayList<>();
        
        // Counters for smokers and non-smokers
        int smokers = 0;
        int nonSmokers = 0;

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

                // Increment the appropriate counter based on smoking status
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokers++;
                } else {
                    nonSmokers++;
                }

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
            System.out.println("Policyholder's Height : " + policy.getHeight()+" inches");
            System.out.println("Policyholder's Weight : " + policy.getWeight()+" pounds");

            // Calculate and display BMI
            double bmi = policy.calculateBMI();
            System.out.printf("Policyholder's BMI: %.2f%n", bmi);

            // Calculate and display the insurance policy price
            double policyPrice = policy.calculatePolicyPrice();
            System.out.printf("Insurance Policy Price: $%.2f%n", policyPrice);
        }

        // Display the count of smokers and non-smokers
        System.out.println("\nNumber of Policyholders that are smokers: " + smokers);
        System.out.println("Number of Policyholders that are non-smokers: " + nonSmokers);
    }
}
