import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account sharedAccount = new Account(1000);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(sharedAccount, true, 200));   // Deposit $200
        transactions.add(new Transaction(sharedAccount, false, 500));  // Withdraw $500
        transactions.add(new Transaction(sharedAccount, true, 300));   // Deposit $300
        transactions.add(new Transaction(sharedAccount, false, 800));  // Withdraw $800
        transactions.add(new Transaction(sharedAccount, true, 400));   // Deposit $400

        // Use ExecutorService to execute threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }


        executor.shutdown();

        while (!executor.isTerminated()) {
        }

        System.out.println("Final balance: $" + sharedAccount.getBalance());
    }
}
