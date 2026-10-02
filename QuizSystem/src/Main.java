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

                System.out.print("How many questions do you want: ");
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
        Scanner Input = new Scanner(System.in);

        try (BufferedReader Reader = new BufferedReader(new FileReader("Users.txt"))){
            String line = Reader.readLine();
            int Correct = 0;

            String [] Parts = line.split(",");

            String Name = Parts[0].trim();
            int QuestionAmount = Integer.parseInt(Parts[1].trim());

            for (int i = 0; i < QuestionAmount; i++) {
                System.out.println("\nQuestion "+(i+1));
                System.out.println("--------------------");
                String Question = QuizMethods.QuestionGetter();

                // String Score = QuizMethods.QuestionSetter(Question);

                String [] QuizParts = Question.split(",");

                String Problem = QuizParts[0];
                String Answer1 = QuizParts[1];
                String Answer2 = QuizParts[2];
                String Answer3 = QuizParts[3];
                String Answer4 = QuizParts[4];

                System.out.println(Problem);

                System.out.println("\nPick an Answer:");
                System.out.println("1. " + Answer1);
                System.out.println("2. " + Answer2);
                System.out.println("3. " + Answer3);
                System.out.println("4. " + Answer4);

                String Answer = Input.nextLine().toUpperCase();

                if (Answer.equals("1") || Answer.equals(Answer1)) {
                    Answer = Answer1;
                } else if (Answer.equals("2") || Answer.equals(Answer2)) {
                    Answer = Answer2;
                } else if (Answer.equals("3") || Answer.equals(Answer3)) {
                    Answer = Answer3;
                } else if (Answer.equals("4") || Answer.equals(Answer4)) {
                    Answer = Answer4;
                }

                System.out.println("You entered: " + Answer);

                boolean CorrectAnswer = QuizMethods.AnswerChecker(Problem, Answer);

                if (CorrectAnswer = true) {
                    Correct += 1;
                }


            }

            System.out.println(Correct);

            /* have a thing in array which holds already used numbers, math.random too
            Reader. */

        } catch (IOException e) {
            System.out.println("Cannot find file");
        }



    }
}
