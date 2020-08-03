package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    public static CustomLinkedList<String> linkedList;

    @Before
    public void init() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("Pesho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_GetShouldThrowException() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(1);
    }

    @Test
    public void Test_GetShouldWorkProperly() {
        String expected = "Pesho";
        String actual = linkedList.get(0);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_SetShouldThrowException() {
        linkedList.set(2, "Pecata");
    }

    @Test
    public void Test_SetShouldWorkProperly() {
        String expected = "Pecata";
        linkedList.set(0, "Pecata");
        String actual = linkedList.get(0);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_AddIfListIsEmpty() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Pesho");
        String expected = "Pesho";
        String actual = customLinkedList.get(1);

        assertEquals(expected, actual);
    }

    @Test
    public void Test_AddIfNonEmptyList() {
        linkedList.add("Pesho");
        linkedList.add("Gosho");

        assertEquals(2, linkedList.indexOf("Gosho"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_RemoveAtShouldThrowException() {
        linkedList.removeAt(4);
    }

    @Test
    public void Test_RemoveAtShouldWorkProperly() {
        linkedList.add("Pesho");

        String actual = linkedList.removeAt(1);

        assertEquals("Pesho", actual);
    }
}