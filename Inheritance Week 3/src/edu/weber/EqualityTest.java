package edu.weber;

public class EqualityTest {
    public static void main(String[] args) {
        Employee alice = new Employee("Alice", 50000);
        Employee bob = alice;
        Employee alice2 = new Employee("Alice", 50000);

        System.out.println("alice == bob " + (alice == bob));
        System.out.println("alice == bob " + (alice == alice2));
        System.out.println("alice.equals(bob) " + (alice.equals(bob)));
        System.out.println("alice.equals(alice2) " + (alice.equals(alice2)));
    }
}
