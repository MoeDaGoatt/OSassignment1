package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.printf("%-15s %-25s %-30s %-20s\n", "Process Id", "Starting Memory Address", "Size of the Process MB", "Unused Space MB");
        System.out.println("-----------------------------------------------------------------------------------");

        MemoryManagementSimulator simulator = new MemoryManagementSimulator();
        simulator.userMemoryAllocation();

    }
}