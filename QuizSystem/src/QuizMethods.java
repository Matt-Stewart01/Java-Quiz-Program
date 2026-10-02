import java.io.*;
import java.lang.Math;

public class QuizMethods {
    public static String QuestionGetter(){
        String[] Questions = new String[5];

        try (BufferedReader Reader = new BufferedReader(new FileReader("Questions.txt"))) {
            String line;
            int count = 0;

            while ((line = Reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;

                }
                Questions[count] = line;
                count++;
            }
        } catch(IOException e){
            System.out.println("Cannot find file");
        }
        return Questions[(int) (Math.random() * (Questions.length))];

    }

    // public static String QuestionSetter(String Question){
       // System.out.println(Question);
        //return Question;
    //}

    public static boolean AnswerChecker(String problem, String answer) {
        boolean Correct = false;

        try (BufferedReader br = new BufferedReader(new FileReader("QuestionsAnswers.txt"))) {
            String line;

            while ((line = br.readLine()) != null){

                String [] QuizAns = line.split(",");

                String Problem = QuizAns[0];
                String ActAnswer = QuizAns[1];

                if (Problem.equals(problem) && ActAnswer.equals(answer)) {
                    //System.out.println("Answer is Correct");
                    Correct = true;
                    break;
                } else {
                    //System.out.println("Answer is Wrong");
                    Correct = false;
                }

            }
        } catch(IOException e){
            System.out.println("Cannot find file");
        }

        return Correct;
    }
}
