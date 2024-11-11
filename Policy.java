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
     * Constructor that initializes the policy with provided values.
     *
     * @param policyNumber the policy number
     * @param providerName the provider's name
     * @param policyHolder the PolicyHolder object representing the policyholder
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        policyCount++;
    }

    // Getters and Setters for Policy fields
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getProviderName() { return providerName; }
    public void setProviderName(String providerName) { this.providerName = providerName; }

    public PolicyHolder getPolicyHolder() { return policyHolder; }
    public void setPolicyHolder(PolicyHolder policyHolder) { this.policyHolder = policyHolder; }

    /**
     * Method to calculate the price of the insurance policy based on the policyholder's
     * age, smoking status, and BMI.
     * 
     * @return the calculated insurance policy price
     */
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (policyHolder.getAge() > 50) {
            additionalFee += 75.0;
        }

        if ("smoker".equalsIgnoreCase(policyHolder.getSmokingStatus())) {
            additionalFee += 100.0;
        }

        double bmi = policyHolder.calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20.0;
        }

        return baseFee + additionalFee;
    }

    /**
     * Returns a string representation of the policy, including details of the policy and policyholder.
     *
     * @return a string containing policy information
     */
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber +
               "\nProvider Name: " + providerName +
               "\n" + policyHolder.toString();
    }
}
