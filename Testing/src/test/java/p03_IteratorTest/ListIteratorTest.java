package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static ListIterator listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator("Pesho","Gosho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_ConstructorShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void Test_ConstructorShouldWorkProperly() throws OperationNotSupportedException {
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void Test_HasNextShouldReturnFalse(){
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void Test_HasNextShouldReturnTrue(){
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void Test_MoveShouldReturnFalse() {
        listIterator.move();
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void Test_MoveShouldReturnTrue() {
        assertTrue(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void Test_PrintShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void Test_PrintShouldWorkProperly()  {
       String expected = "Pesho";
       String actual = listIterator.print();

       assertEquals(expected, actual);
    }

}