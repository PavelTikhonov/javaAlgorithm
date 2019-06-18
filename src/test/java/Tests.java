import lesson3.deque.DequeTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests<E> {
    private DequeTest<E> dequeTest;
    @Before
    public void init() {
        dequeTest = new DequeTest<>();
    }

//    @Test
//    public void arrConversTest() {
//        Assert.assertArrayEquals((new int[]{7, 3, 6, 8}), mainTests.arrayConversion((new int[]{0, 1, 4, 7, 3, 6, 8})));
//    }

//    @Test(expected = RuntimeException.class)
//    public void arrConversTest1() {
//        Assert.assertArrayEquals((null), mainTests.arrayConversion((new int[]{0, 1, 3, 7, 4, 6, 8, 5, 4})));
//    }


    @Test
    public void stackTest() {
        Assert.assertTrue(dequeTest.stackTest((E[]) new Integer[]{1,2,3,4,5}, 6));
    }

    @Test(expected = RuntimeException.class)
    public void stackTest1() {
        Assert.assertTrue(dequeTest.stackTest((E[]) new Integer[]{1,2,3,4,5}, 4));
    }


    @Test
    public void queueTest() {
        Assert.assertTrue(dequeTest.stackTest((E[]) new Integer[]{1,2,3,4,5}, 6));
    }

    @Test(expected = RuntimeException.class)
    public void queueTest1() {
        Assert.assertTrue(dequeTest.stackTest((E[]) new Integer[]{1,2,3,4,5}, 4));
    }
}
