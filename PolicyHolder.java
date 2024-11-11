/**
 * The PolicyHolder class represents a person associated with an insurance policy,
 * containing details such as name, age, smoking status, height, and weight, as well
 * as a method to calculate BMI.
 */
public class PolicyHolder {

    // Attributes specific to the policyholder
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus; // "smoker" or "non-smoker"
    private double height; // in inches
    private double weight; // in pounds

    /**
     * Constructor that initializes the policyholder's details.
     * 
     * @param firstName      the first name of the policyholder
     * @param lastName       the last name of the policyholder
     * @param age            the age of the policyholder
     * @param smokingStatus  the smoking status of the policyholder ("smoker" or "non-smoker")
     * @param height         the height of the policyholder in inches
     * @param weight         the weight of the policyholder in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters and Setters for PolicyHolder fields
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSmokingStatus() { return smokingStatus; }
    public void setSmokingStatus(String smokingStatus) { this.smokingStatus = smokingStatus; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

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
     * Returns a string representation of the policyholder's details.
     *
     * @return a string containing policyholder information
     */
    @Override
    public String toString() {
        return "Policyholder's Name: " + firstName + " " + lastName +
               "\nAge: " + age +
               "\nSmoking Status: " + smokingStatus +
               "\nHeight (in inches): " + height +
               "\nWeight (in pounds): " + weight +
               "\nBMI: " + String.format("%.2f", calculateBMI());
    }
}
