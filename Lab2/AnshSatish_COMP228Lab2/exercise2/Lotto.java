package exercise2;
import javax.swing.JOptionPane;
import java.util.Random;


public class Lotto {
private int[] number = new int[3];

    public Lotto()
    {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            number[i] = random.nextInt(9) + 1;
        }
    }

    public int[] getNumber() {
        return number;
    }

    public int getSum() {
        int sum = 0;
        for (int number : number) {
            sum += number;
        }
        return sum;
    }

    public void gameLogic() {
        int userChoice = Integer.parseInt(JOptionPane.showInputDialog("Choose a number between 3 and 27:"));
        int attempts = 0;
        boolean won = false;

        // Run the lotto game for up to 5 attempts
        while (attempts < 5) {
            Lotto lotto = new Lotto();
            int sum = lotto.getSum();

            JOptionPane.showMessageDialog(null, "Lotto numbers: " +
                    lotto.getNumber()[0] + ", " +
                    lotto.getNumber()[1] + ", " +
                    lotto.getNumber()[2] + "\nSum: " + sum);

            if (sum == userChoice) {
                JOptionPane.showMessageDialog(null, "Hurraay! You won!");
                won = true;
                break;
            }

            attempts++;
        }
        if (!won) {
            JOptionPane.showMessageDialog(null, "You lose. Computer wins.");
        }
    }

}



