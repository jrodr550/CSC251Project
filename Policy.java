/**
 * The Policy class represents an insurance policy, containing details
 * about the policy and a reference to a PolicyHolder object.
 */
public class Policy {

    // Attributes specific to the policy
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Reference to the PolicyHolder object

    // Static field to keep track of the number of Policy objects created
    private static int policyCount = 0;

    /**
     * No-arg constructor that initializes the policy with default values and a default policyholder.
     */
    public Policy() {
        this.policyNumber = "Unknown";
        this.providerName = "Unknown";
        this.policyHolder = new PolicyHolder("John", "Doe", 30, "non-smoker", 60.0, 150.0); // Default PolicyHolder
        policyCount++;
    }

    /**
     * Constructor that initializes the policy with provided values, creating a deep copy of the PolicyHolder.
     *
     * @param policyNumber the policy number
     * @param providerName the provider's name
     * @param policyHolder the PolicyHolder object representing the policyholder
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        // Creating a deep copy of PolicyHolder to avoid exposing the original reference
        this.policyHolder = new PolicyHolder(policyHolder.getFirstName(), policyHolder.getLastName(),
                                             policyHolder.getAge(), policyHolder.getSmokingStatus(),
                                             policyHolder.getHeight(), policyHolder.getWeight());
        policyCount++;
    }

    // Getters and Setters for Policy fields
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    /**
     * Returns a copy of the PolicyHolder to prevent external modification.
     * 
     * @return a deep copy of the PolicyHolder
     */
    public PolicyHolder getPolicyHolder() {
        return new PolicyHolder(policyHolder.getFirstName(), policyHolder.getLastName(),
                                policyHolder.getAge(), policyHolder.getSmokingStatus(),
                                policyHolder.getHeight(), policyHolder.getWeight());
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        // Setting a deep copy to avoid exposing the original reference
        this.policyHolder = new PolicyHolder(policyHolder.getFirstName(), policyHolder.getLastName(),
                                             policyHolder.getAge(), policyHolder.getSmokingStatus(),
                                             policyHolder.getHeight(), policyHolder.getWeight());
    }

    /**
     * Calculates the price of the insurance policy based on the policyholder's age, smoking status, and BMI.
     * 
     * @return the calculated insurance policy price
     */
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        // Incremento de tarifa basado en la edad
        if (policyHolder.getAge() > 50) {
            additionalFee += 75.0;
        }

        // Incremento de tarifa basado en el estado de fumador
        if ("smoker".equalsIgnoreCase(policyHolder.getSmokingStatus())) {
            additionalFee += 100.0;
        }

        // Incremento de tarifa basado en el BMI
        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20.0;
        }

        return baseFee + additionalFee;
    }

    /**
     * Static method to retrieve the number of Policy objects created.
     * 
     * @return the number of Policy objects created
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString();
    }
}
