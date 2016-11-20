import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RangeSetTest {

    @Test
    public void simpleTest() {
        RangeSet set = new RangeSet();

        set.add(2);
        set.addRange(10, 100_000);
        set.addRange(1_000_000, 2_000_000);
        set.remove(1_500_000);


        assertTrue(set.contains(10));
        assertTrue(set.contains(500));
        assertTrue(set.contains(99_000));
        assertTrue(set.contains(1_500_001));
        assertTrue(set.contains(2));

        assertFalse(set.contains(3));
    assertFalse(set.contains(1_500_000));


        /*for (Integer value : set) {
            assertTrue(set.contains(value));
        }*/
    }

    @Test
    public void checkOverlappingRanges() {
        RangeSet set = new RangeSet();
        set.addRange(1, 10);
        set.addRange(5, 100);

      assertTrue(set.contains(6));
    }

}