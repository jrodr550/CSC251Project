import java.util.Scanner;

public class JuanRodriguez_CSC251Project
{
 public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Policy Number: ");
        String policyNumber = scanner.nextLine();
        
        System.out.print("Enter Provider Name: ");
        String providerName = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Age: ");
        int age = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline left-over
        
        System.out.print("Enter Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Height (in inches): ");
        double height = scanner.nextInt();
        
        System.out.print("Enter Policyholder’s Weight (in pounds): ");
        double weight = scanner.nextInt();

        // Create Policy instance
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
        
        // Display all information about the policy
        System.out.println("\nPolicy Information:");
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height (in inches): " + policy.getHeight());
        System.out.println("Policyholder’s Weight (in pounds): " + policy.getWeight());

        // Calculate and display BMI
        double bmi = policy.calculateBMI();
        System.out.printf("Policyholder’s BMI: %.2f%n", bmi);

        // Calculate and display the policy price
        double policyPrice = policy.calculatePolicyPrice();
        System.out.printf("Insurance Policy Price: $%.2f%n", policyPrice);
        
        scanner.close();
    }
}

