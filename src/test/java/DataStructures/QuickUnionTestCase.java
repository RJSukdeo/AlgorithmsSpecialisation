package DataStructures;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickUnionTestCase {

    @Test
    public void testExample() {
        QuickUnion union = new QuickUnion(0, 9);
        union.unite(6, 9);
        union.unite(6, 5);
        union.unite(9, 6);
        union.unite(2, 6);
        union.unite(4, 3);
        union.unite(3, 2);

        assertFalse(union.find(0, 1));
        assertFalse(union.find(0, 2));
        assertFalse(union.find(0, 3));
        assertFalse(union.find(0, 4));
        assertFalse(union.find(0, 5));
        assertFalse(union.find(0, 6));
        assertFalse(union.find(0, 7));
        assertFalse(union.find(0, 8));
        assertFalse(union.find(0, 9));

        assertFalse(union.find(1, 2));
        assertFalse(union.find(1, 3));
        assertFalse(union.find(1, 4));
        assertFalse(union.find(1, 5));
        assertFalse(union.find(1, 6));
        assertFalse(union.find(1, 7));
        assertFalse(union.find(1, 8));
        assertFalse(union.find(1, 9));

        assertFalse(union.find(7, 2));
        assertFalse(union.find(7, 3));
        assertFalse(union.find(7, 4));
        assertFalse(union.find(7, 5));
        assertFalse(union.find(7, 6));
        assertFalse(union.find(7, 8));
        assertFalse(union.find(7, 9));

        assertFalse(union.find(8, 2));
        assertFalse(union.find(8, 3));
        assertFalse(union.find(8, 4));
        assertFalse(union.find(8, 5));
        assertFalse(union.find(8, 6));
        assertFalse(union.find(8, 9));

        assertTrue(union.find(6, 9));
        assertTrue(union.find(6, 5));
        assertTrue(union.find(6, 2));
        assertTrue(union.find(6, 4));
        assertTrue(union.find(6, 3));
    }

}
