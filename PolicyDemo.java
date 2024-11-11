public class PolicyDemo {
    public static void main(String[] args) {
        // Crear un objeto PolicyHolder
        PolicyHolder holder = new PolicyHolder("Alice", "Johnson", 45, "smoker", 65.0, 180.0);

        // Crear un objeto Policy que contiene el PolicyHolder
        Policy policy = new Policy("P1001", "Best Health Insurance", holder);

        // Mostrar los detalles de la póliza y del titular usando toString()
        System.out.println(policy);

        // Mostrar el número total de objetos Policy creados
        System.out.println("\nTotal Policies Created: " + Policy.getPolicyCount());
    }
}
