package serializationexample; // adjust if no package

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeStudent {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", "A");
        String filename = "student.ser";

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(student);
            System.out.println("Serialized data is saved in " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
