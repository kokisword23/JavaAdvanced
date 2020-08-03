import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> database;

    public ChainblockImpl() {
        this.database = new LinkedHashMap<>();
    }

    public int getCount() {
        return database.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            database.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.database.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        Transaction transaction = getById(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        this.database.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        return this.database.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));
        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));

        return transactions.stream().map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getStatus() == status)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));

        return transactions.stream().map(Transaction::getTo).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.database.values()
                .stream()
                .sorted((t1, t2) -> {
                    if (t1.getAmount() == t2.getAmount()) {
                        return Integer.compare(t1.getId(), t2.getId());
                    }

                    return Double.compare(t2.getAmount(), t1.getAmount());
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions.stream().sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions
                .stream()
                .sorted((t1, t2) -> {
                    if (t1.getAmount() == t2.getAmount()) {
                        return Integer.compare(t1.getId(), t2.getId());
                    }

                    return Double.compare(t2.getAmount(), t1.getAmount());
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.database.values()
                .stream()
                .filter(t -> t.getStatus().equals(status) && t.getAmount() <= amount)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getFrom().equals(sender) && t.getAmount() >= amount)
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        transactions.sort((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()));
        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.database.values()
                .stream()
                .filter(t -> t.getTo().equals(receiver) && (t.getAmount() >= lo && t.getAmount() < hi))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions
                .stream()
                .sorted((t1, t2) -> {
                    if (t1.getAmount() == t2.getAmount()) {
                        return Integer.compare(t1.getId(), t2.getId());
                    }

                    return Double.compare(t2.getAmount(), t1.getAmount());
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.database.values()
                .stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return new Iterator<Transaction>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return database.size() < index;
            }

            @Override
            public Transaction next() {
                return database.get(index++);
            }
        };
    }
}
