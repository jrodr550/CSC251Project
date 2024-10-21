/**
 * The Policy class represents an insurance policy, containing details
 * about the policyholder and methods to calculate BMI and insurance policy price.
 */
public class Policy {

    // Attributes
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    /**
     * No-arg constructor that initializes the policy with default values.
     */
    public Policy() {
        this.policyNumber = "Unknown";
        this.providerName = "Unknown";
        this.firstName = "John";
        this.lastName = "Doe";
        this.age = 30;
        this.smokingStatus = "non-smoker";
        this.height = 60.0; // default height 5 feet
        this.weight = 150.0; // default weight
    }

    /**
     * Constructor that initializes the policy with provided values.
     * 
     * @param policyNumber the policy number
     * @param providerName the provider's name
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokingStatus the smoking status of the policyholder ("smoker" or "non-smoker")
     * @param height the height of the policyholder in inches
     * @param weight the weight of the policyholder in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Returns the policy number.
     * 
     * @return the policy number
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     * 
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Returns the provider's name.
     * 
     * @return the provider's name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider's name.
     * 
     * @param providerName the provider's name to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Returns the policyholder's first name.
     * 
     * @return the policyholder's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the policyholder's first name.
     * 
     * @param firstName the policyholder's first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the policyholder's last name.
     * 
     * @return the policyholder's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the policyholder's last name.
     * 
     * @param lastName the policyholder's last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the policyholder's age.
     * 
     * @return the policyholder's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the policyholder's age.
     * 
     * @param age the policyholder's age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the policyholder's smoking status.
     * 
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the policyholder's smoking status.
     * 
     * @param smokingStatus the policyholder's smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Returns the policyholder's height in inches.
     * 
     * @return the policyholder's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the policyholder's height in inches.
     * 
     * @param height the policyholder's height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Returns the policyholder's weight in pounds.
     * 
     * @return the policyholder's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the policyholder's weight in pounds.
     * 
     * @param weight the policyholder's weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates the Body Mass Index (BMI) for the policyholder.
     * 
     * @return the calculated BMI
     */
    public double calculateBMI() {
        if (height == 0) {
            throw new IllegalArgumentException("Height cannot be zero");
        }
        return (weight * 703.0) / (height * height);
    }

    /**
     * Calculates the price of the insurance policy based on the policyholder's
     * age, smoking status, and BMI.
     * 
     * @return the calculated insurance policy price
     */
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (age > 50) {
            additionalFee += 75.0;
        }

        if ("smoker".equalsIgnoreCase(smokingStatus)) {
            additionalFee += 100.0;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20.0;
        }

        return baseFee + additionalFee;
    }
}
