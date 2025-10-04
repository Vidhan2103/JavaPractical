package studentstream;
import java.util.*;

public class StudentStreamDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 82));
        students.add(new Student("Bob", 68));
        students.add(new Student("Charlie", 91));
        students.add(new Student("David", 74));
        students.add(new Student("Eve", 88));

        System.out.println("=== All Students ===");
        students.forEach(System.out::println);

        System.out.println("\n=== Students with Marks > 75 (Sorted by Marks) ===");
        students.stream()
                .filter(s -> s.getMarks() > 75)               
                .sorted((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks()))
                .map(Student::getName)                    
                .forEach(System.out::println);                    
    }
}
