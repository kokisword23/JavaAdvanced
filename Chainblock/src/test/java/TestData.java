import java.util.List;

public class TestData {

    public static List<Transaction> getTransactions() {
        return List.of(new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100),
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 200),
                new TransactionImpl(3, TransactionStatus.ABORTED, "Pesho", "Gosho", 200));
    }

    public static List<String> getTransactionForReceiver() {
        return List.of("Misho", "Stamat");
    }
}
