package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(new Person(1, "Pesho"),
                new Person(2, "Gosho"),
                new Person(3, "Ivan"));
    }


    @Test(expected = OperationNotSupportedException.class)
    public void Test_setElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test()
    public void Test_setElementsShouldWorkProperly() {

        Person[] expected = database.getElements();
        Person[] actual = new Person[]{new Person(1, "Pesho"),
                new Person(2, "Gosho"),
                new Person(3, "Ivan")};

        assertArrayEquals(expected, actual);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void Test_addShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void Test_addShouldWorkProperly() throws OperationNotSupportedException {
        Person value = new Person(4,"Kiril");
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
    public void Test_getElementsShouldWorkProperly() {
        Person[] expected = new Person[]{new Person(1, "Pesho"),
                new Person(2, "Gosho"),
                new Person(3, "Ivan")};;

        assertArrayEquals(expected, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_findByUsernameShouldThrowExceptionIfNameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_findByUsernameShouldThrowExceptionIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(4,"Gosho"));
        database.findByUsername("Gosho");
    }

    @Test
    public void Test_findByUsernameShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(2,"Gosho");
        Person actual = database.findByUsername("Gosho");

        assertEquals(expected,actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_findByIdShouldThrowExceptionIfNoMatch() throws OperationNotSupportedException {
        database.findById(4);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void Test_findByIdShouldThrowExceptionIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(3,"Stamat"));
        database.findById(3);
    }

    @Test
    public void Test_findByIdShouldWorkProperly() throws OperationNotSupportedException {
        Person expected = new Person(1,"Pesho");
        Person actual = database.findById(1);

        assertEquals(expected, actual);
    }

}