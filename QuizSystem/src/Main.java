import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Quiz");
        System.out.println("\nWould you like to start the Quiz?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        String UserFile = "Users.txt";
        try {

            Scanner Input = new Scanner(System.in);
            FileWriter Writer = new FileWriter(UserFile);

            System.out.print("Choice: ");
            String Choice = Input.nextLine();

            if (Choice.equals("1")||Choice.equalsIgnoreCase("yes")) {
                System.out.println("Starting Quiz");

                System.out.print("\nEnter your name: ");
                String Name = Input.nextLine();

                System.out.print("\nHow many questions do you guys want: ");
                int Number = Input.nextInt();

                Writer.append(Name+","+Number);
                Writer.close();

                Questions();

                //name, number of questions that they want and the amount of time that they'd like
            } else if (Choice.equals("2")||Choice.equalsIgnoreCase("no")) {
                System.out.println("Exiting Quiz");
            }

        } catch (IOException e) {
            System.out.println("Invalid Choice");
        }



    }

    public static void Questions() {
        try (FileReader Reader = new FileReader("Users.txt");) {
            /* have a thing in array which holds already used numbers, math.random too
            Reader. */
        } catch (IOException e) {
            System.out.println("Cannot find file");
        }



    }
}
