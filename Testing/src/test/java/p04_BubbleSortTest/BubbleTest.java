package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void Test_SortCorrect() {
        int[] actual = {1, 6, 4, 5, 7};
        int[] expected = {1, 4, 5, 6, 7};

        Bubble.sort(actual);

        assertArrayEquals(expected,actual);
    }

    @Test
    public void Test_SortIncorrect() {
        int[] actual = {1, 6, 4, 5, 7};
        int[] expected = {1, 5, 4, 6, 7};

        Bubble.sort(actual);

        assertNotEquals(expected,actual);
    }
}