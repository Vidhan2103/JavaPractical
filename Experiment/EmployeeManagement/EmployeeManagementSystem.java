package employeemanagement;

import java.io.*;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                continue;
            }
            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        try {
            System.out.print("Enter Employee ID: ");
            String idStr = scanner.nextLine().trim();
            int id = Integer.parseInt(idStr);

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine().trim();

            System.out.print("Enter Salary: ");
            String salaryStr = scanner.nextLine().trim();
            double salary = Double.parseDouble(salaryStr);

            Employee emp = new Employee(id, name, designation, salary);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(emp.toString());
                writer.newLine();
                System.out.println("Employee added successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number format. ID must be integer and salary must be numeric. Returning to menu.");
        }
    }

    private static void displayEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No employee records found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee Records ---");
            boolean any = false;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String designation = parts[2];
                        double salary = Double.parseDouble(parts[3]);
                        Employee emp = new Employee(id, name, designation, salary);
                        System.out.println(emp.display());
                        any = true;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Skipping invalid record: " + line);
                    }
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
            if (!any) {
                System.out.println("No valid employee records found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
