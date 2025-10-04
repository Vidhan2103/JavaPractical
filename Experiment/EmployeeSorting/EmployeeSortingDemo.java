package employeesorting;
import java.util.*;
public class EmployeeSortingDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alice", 30, 60000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 70000));
        employees.add(new Employee("David", 28, 55000));
        employees.add(new Employee("Eve", 32, 65000));

        System.out.println("=== Original List ===");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        System.out.println("\n=== Sorted by Name (Alphabetical) ===");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\n=== Sorted by Age (Ascending) ===");
        employees.forEach(System.out::println);
        
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\n=== Sorted by Salary (Descending) ===");
        employees.forEach(System.out::println);
    }
}
