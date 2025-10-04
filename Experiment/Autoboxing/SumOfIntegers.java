package SumOfIntegers;
import java.util.ArrayList;
import java.util.Scanner;
public class SumOfIntegers {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                Integer number = Integer.parseInt(input); 
                numbers.add(number); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'done'.");
            }
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        System.out.println("The sum of the entered integers is: " + sum);
        scanner.close();

	}

}
