package midterm;

import midterm.MyOrderedList;
import midterm.OrderedList;
import org.junit.Assert;
import org.junit.Test;

public class MyOrderedListTest {

    @Test
    public void add() {
    }

    @Test
    public void get() {
        OrderedList<Integer> list = new MyOrderedList<>();
        list.add(5);
        list.add(8);
        list.add(10);
        list.add(12);
        list.add(17);
        Assert.assertEquals(Integer.valueOf(10), list.get(2));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
    }

    @Test
    public void size() {
    }

    @Test
    public void subList() {
    }

    @Test
    public void testToString() {
        OrderedList<Integer> list = new MyOrderedList<>();
        Assert.assertEquals("", list.toString());
        list.add(10);
        list.add(20);
        list.add(15);
        Assert.assertEquals("10 15 20", list.toString());
    }
}