package edu.weber;

public class VendingMachineTester {
    public static void main(String[] args)
    {
        VendingMachine machine = new VendingMachine(); //uses default constructor
        machine.insertToken();
        machine.insertToken();
        System.out.print("Token count: ");
        System.out.println(machine.getTokenCount());
        System.out.println("Expected: 2");
        System.out.print("Can count: ");
        System.out.println(machine.getCanCount());
        System.out.println("Expected: 8");

        VendingMachine machineSecondConstructor = new VendingMachine(1); //constructor that initializes
        machineSecondConstructor.fillUp(10);
        System.out.println("Can count: ");
        System.out.println(machineSecondConstructor.getCanCount());
        System.out.println("Token Count: ");
        System.out.println(machineSecondConstructor.getTokenCount());
        System.out.println("Insert 3 Tokens");
        machineSecondConstructor.insertToken();
        machineSecondConstructor.insertToken();
        machineSecondConstructor.insertToken();
        System.out.println("Can count: ");
        System.out.println(machineSecondConstructor.getCanCount());
        System.out.println("Token Count: ");
        System.out.println(machineSecondConstructor.getTokenCount());
    }
}
