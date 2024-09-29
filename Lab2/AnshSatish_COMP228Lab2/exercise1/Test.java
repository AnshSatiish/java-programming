package exercise1;
import java.util.Random;
import javax.swing.JOptionPane;


public class Test {
    Random random = new Random();
    int correctAnswers = 0;
    int incorrectAnswers = 0;

    private String[][] questions = {
            {"Who won the Ballon d'Or in 2021?", "Lionel Messi", "Cristiano Ronaldo", "Robert Lewandowski", "Karim Benzema", "1"},

            {"Which team won the NBA championship in 2022?", "Miami Heat", "Los Angeles Lakers", "Golden State Warriors", "Milwaukee Bucks", "3"},

            {"Which company developed the video game 'Fortnite'?", "Epic Games", "Activision", "EA Sports", "Ubisoft", "1"},

            {"Who was REAL the 2021 Formula 1 World Champion?", "Lewis Hamilton", "Max Verstappen", "Sebastian Vettel", "Fernando Alonso", "1"},

            {"Which planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter", "3"}
    };
    public void simulateQuestion()
    {
        for (int i = 0; i < questions.length; i++)
        {
            String question = questions[i][0] + "\n" +
                              "1. " + questions[i][1] + "\n" +
                              "2. " + questions[i][2] + "\n" +
                              "3. " + questions[i][3] + "\n" +
                              "4. " + questions[i][4];

            String userInput = JOptionPane.showInputDialog(null, question, "Question " + (i + 1), JOptionPane.QUESTION_MESSAGE);

            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Test canceled");
                return;
            }

            try
            {
                int userAnswer = Integer.parseInt(userInput);

                if (checkAnswer(userAnswer, Integer.parseInt(questions[i][5]))) {
                    correctAnswers++;
                    JOptionPane.showMessageDialog(null, generateMessage(true));
                } else {
                    incorrectAnswers++;
                    JOptionPane.showMessageDialog(null, generateMessage(false) + " The correct answer was: " + questions[i][Integer.parseInt(questions[i][5])]);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 4");
                i--;
            }
        }
        showResults();
    }

    public boolean checkAnswer(int userAnswer, int correctAnswer)
    {
        if (userAnswer == correctAnswer) {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void showResults() {
        JOptionPane.showMessageDialog(null, "Test finished!\n" +
                "Correct answers: " + correctAnswers + "\n" +
                "Incorrect answers: " + incorrectAnswers + "\n" +
                "Percentage correct: " + (correctAnswers / (double) questions.length * 100) + "%");
    }

    public String generateMessage(boolean isCorrect)
    {
        switch (random.nextInt(4)) {
            case 0:
                return isCorrect ? "Excellent!" : "No. Please try again.";
            case 1:
                return isCorrect ? "Good!" : "Wrong. Try once more.";
            case 2:
                return isCorrect ? "Keep up the good work!" :  "Don't give up!";
            case 3:
                return isCorrect ? "Nice work!" : "No. Keep trying..";
            default:
                return "";
        }
    }

    public void inputAnswer() {
        for (int i = 1; i <= 5; i++) {
            String answer = JOptionPane.showInputDialog("Question " + i + ": What is ...?");
            int userAnswer = Integer.parseInt(answer);
            if (checkAnswer(userAnswer, 1)) {
                correctAnswers++;
                JOptionPane.showMessageDialog(null, generateMessage(true));
            } else {
                incorrectAnswers++;
                JOptionPane.showMessageDialog(null, generateMessage(false) + " The correct answer was: " + 1);
            }
        }
    }
}
