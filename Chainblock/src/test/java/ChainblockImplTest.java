import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private static ChainblockImpl chainblock;

    @Before
    public void init() {
        chainblock = new ChainblockImpl();
    }

    @Test
    public void Test_addShouldWorkProperly() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        chainblock.add(transaction);

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void Test_addShouldFindDuplicate() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);

        chainblock.add(transaction);
        chainblock.add(transaction);

        assertEquals(1, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_changeTransactionStatusShouldThrowException() {
        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void Test_changeTransactionStatusShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);

        chainblock.add(transaction);

        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
        Transaction actual = chainblock.getById(1);

        assertEquals(TransactionStatus.ABORTED, actual.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getByIdShouldThrowException() {
        chainblock.getById(1);
    }

    @Test
    public void Test_getByIdShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);

        chainblock.add(transaction);

        Transaction actual = chainblock.getById(1);

        assertEquals(transaction, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_removeTransactionByIdShouldThrowException() {
        chainblock.removeTransactionById(1);
    }

    @Test
    public void Test_removeTransactionByIdShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);

        chainblock.add(transaction);

        chainblock.removeTransactionById(1);

        assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getByTransactionStatusShouldThrowException() {
        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void Test_getByTransactionStatusShouldWork() {
        Transaction transaction =new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        Transaction transaction2 =
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 200);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.ABORTED, "Pesho", "Gosho", 200);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getAllSendersWithTransactionStatusShouldThrowException() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void Test_getAllSendersWithTransactionStatusShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Stamat", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Koceto", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<String> expected = List.of(transaction2.getFrom(), transaction.getFrom());
        List<String> actual = (List<String>) chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getAllReceiversWithTransactionStatusShouldThrowException() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void Test_getAllReceivesWithTransactionStatusShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Stamat", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Koceto", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<String> expected = List.of(transaction2.getTo(), transaction.getTo());
        List<String> actual = (List<String>) chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);

        assertEquals(expected, actual);
    }

    @Test
    public void Test_getAllOrderedByAmountDescendingThenByIdShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Stamat", "Misho", 100);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Koceto", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction3, transaction, transaction2);
        List<Transaction> actual = (List<Transaction>) chainblock.getAllOrderedByAmountDescendingThenById();

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getBySenderOrderedByAmountDescendingShouldThrowException() {
        chainblock.getBySenderOrderedByAmountDescending("Pesho");
    }

    @Test
    public void Test_getBySenderOrderedByAmountDescendingShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Koceto", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock.getBySenderOrderedByAmountDescending("Pesho");

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getByReceiverOrderedByAmountThenByIdShouldThrowException() {
        chainblock.getByReceiverOrderedByAmountThenById("Pesho");
    }

    @Test
    public void Test_getByReceiverOrderedByAmountThenByIdShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction3, transaction, transaction2);
        List<Transaction> actual = (List<Transaction>) chainblock.getByReceiverOrderedByAmountThenById("Misho");

        assertEquals(expected, actual);
    }

    @Test
    public void Test_getTransactionStatusAndMaximumAmountShouldReturnEmptyList() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> actual = (List<Transaction>) chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 50);

        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void Test_getTransactionStatusAndMaximumAmountShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Gosho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 300);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 300);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getBySenderAndMinimumAmountDescendingThrowException() {
        chainblock.getBySenderAndMinimumAmountDescending("Pesho", 20);
    }

    @Test
    public void Test_getBySenderAndMinimumAmountDescendingShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 50);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction);
        List<Transaction> actual = (List<Transaction>) chainblock
                .getBySenderAndMinimumAmountDescending("Pesho", 100);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_getByReceiverAndAmountRangeThrowException() {
        chainblock.getByReceiverAndAmountRange("Pesho", 20, 100);
    }

    @Test
    public void Test_getByReceiverAndAmountRangeShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 100);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction2, transaction, transaction3);
        List<Transaction> actual = (List<Transaction>) chainblock
                .getByReceiverAndAmountRange("Misho", 100, 201);

        assertEquals(expected, actual);
    }

    @Test
    public void Test_getAllInAmountRangeShouldReturnEmptyList() {
        List<Transaction> actual = (List<Transaction>) chainblock.getAllInAmountRange(20, 100);

        assertEquals(new ArrayList<>(), actual);
    }

    @Test
    public void Test_getAllInAmountRangeShouldWork() {
        Transaction transaction = (Transaction)
                new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 100);
        Transaction transaction2 = (Transaction)
                new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Pesho", "Misho", 200);
        Transaction transaction3 = (Transaction)
                new TransactionImpl(3, TransactionStatus.ABORTED, "Ivan", "Misho", 100);

        chainblock.add(transaction);
        chainblock.add(transaction2);
        chainblock.add(transaction3);

        List<Transaction> expected = List.of(transaction, transaction2, transaction3);
        List<Transaction> actual = (List<Transaction>) chainblock
                .getAllInAmountRange(100, 201);

        assertEquals(expected, actual);
    }
}