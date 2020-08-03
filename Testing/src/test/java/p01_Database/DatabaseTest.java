package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;


public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(8, 9, 10);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void Test_setElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test()
    public void Test_setElementsShouldWorkProperly() throws OperationNotSupportedException {

        Integer[] expected = database.getElements();
        Integer[] actual = new Integer[]{8, 9, 10};

        assertArrayEquals(expected, actual);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void Test_addShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void Test_addShouldWorkProperly() throws OperationNotSupportedException {
        Integer value = 11;
        int expectedLength = database.getElements().length + 1;
        database.add(value);

        assertNotNull(database.getElements());
        assertEquals(expectedLength, database.getElements().length);
        assertEquals(value, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_removeShouldThrowException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void Test_removeShouldWorkProperly() throws OperationNotSupportedException {
        int expectedLength = database.getElements().length - 1;

        database.remove();

        assertEquals(expectedLength, database.getElements().length);
    }


    @Test
    public void Test_getElementsShouldWorkProperly() throws OperationNotSupportedException {
       Integer[] expected = {8,9,10};

        assertArrayEquals(expected, database.getElements());
    }

}
