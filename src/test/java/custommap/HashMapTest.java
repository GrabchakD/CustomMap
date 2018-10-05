package custommap;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    HashMap hashMap;

    @Before
    public void init() {
        hashMap = new HashMap();
    }

    @Test
    public void testPutElement_happyPath() {
        int key = 1;
        long value = 1l;
        hashMap.put(key, value);

        long expectedResult = 1l;
        long actualResult = hashMap.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddMoreKeysThenInitialCapacity() {
        hashMap.put(1, 1l);
        hashMap.put(2, 1l);
        hashMap.put(3, 1l);
        hashMap.put(4, 1l);
        hashMap.put(5, 1l);
        hashMap.put(6, 1l);
        hashMap.put(7, 1l);
        hashMap.put(8, 1l);
        hashMap.put(9, 1l);
        hashMap.put(10, 1l);
        hashMap.put(11, 1l);
        hashMap.put(12, 1l);
        hashMap.put(13, 1l);
        hashMap.put(14, 1l);
        hashMap.put(15, 1l);
        hashMap.put(16, 1l);
        hashMap.put(17, 1l);
        hashMap.put(18, 1l);
        hashMap.put(19, 1l);
        hashMap.put(20, 1l);
        hashMap.put(21, 1l);
        hashMap.put(22, 1l);

        int expectedResult = 22;
        long actualResult = hashMap.getSize();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPutSameKeyTwice() {
        hashMap.put(1, 1l);
        hashMap.put(1, 2l);

        long expectedResult = 2l;
        long actualResult = hashMap.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGet_happyPath() {
        int key = 1;
        long value = 1l;
        hashMap.put(key, value);
        long actualResult = hashMap.get(1);

        long expectedResult = 1l;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSize() {
        hashMap.put(1, 1l);

        int actualResult = hashMap.getSize();
        int expectedResult = 1;

        assertEquals(expectedResult, actualResult);
    }
}
