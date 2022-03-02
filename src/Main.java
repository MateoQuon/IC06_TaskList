import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name, dueDate, deadline;
        int priority, count= 0;
        Task[] tasks = new Task[10];

        // Read binary file w/ ObjectInputStream and edit with ObjectOutputStream
        File binaryFile = new File("TaskList.dat");
        // Check to see if file exists AND non-zero size
        System.out.println("Previously saved Tasks from binary file: ");
        if (binaryFile.exists() && binaryFile.length() > 1L) // L = long
        {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                // Read the entire array into tasks[]
                // readObject() returns Object
                // Tasks[] = Object
                tasks = (Task[])fileReader.readObject();
                // Loop through the array and print all Objects
                while(tasks[count] != null){
                    System.out.println(tasks[count++]);
                }
                fileReader.close();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else
            System.out.println("[None, please enter new Tasks]");

        do {
            System.out.print("Please enter task name (or \"quit\" to exit): ");
            name = keyboard.nextLine();
            if ("quit".equalsIgnoreCase(name))
                break;

            System.out.print("Please enter due date (in form MM/DD/YYYY): ");
            dueDate = keyboard.nextLine();
            System.out.print("Please enter deadline: ");
            deadline = keyboard.nextLine();
            System.out.print("Please enter priority: ");
            priority = keyboard.nextInt();
            keyboard.nextLine();

            tasks[count++] = new Task(deadline, dueDate, name, priority);
        } while (true);

        // After user "quit"s, write the Task array to binary file
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            fileWriter.writeObject(tasks);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
