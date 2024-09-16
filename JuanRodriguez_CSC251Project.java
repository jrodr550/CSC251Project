import java.util.Scanner;

public class Main
{
 public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Policy Number: ");
        String policyNumber1 = scanner.nextLine();
        
        System.out.print("Enter Provider Name: ");
        String providerName1 = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s First Name: ");
        String firstName1 = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Last Name: ");
        String lastName1 = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Age: ");
        int age1 = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline left-over
        
        System.out.print("Enter Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus1 = scanner.nextLine();
        
        System.out.print("Enter Policyholder’s Height (in inches): ");
        double height1 = scanner.nextDouble();
        
        System.out.print("Enter Policyholder’s Weight (in pounds): ");
        double weight1 = scanner.nextDouble();

        // Create Policy instance
        Policy policy = new Policy(policyNumber1, providerName1, firstName1, lastName1, age1, smokingStatus1, height1, weight1);
        
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
