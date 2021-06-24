package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Vector class
 *  @author Dan
 */
class VectorTest {

    // setup
    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(0, 3, -2);

    Vector v1pos = new Vector(1.0, 1.0, 1.0);
    Vector v2pos = new Vector(2.0, 2.0, 2.0);

    Vector v1neg = new Vector(-1.0, -1.0, -1.0);
    Vector v2neg = new Vector(-2.0, -2.0, -2.0);

    @Test
    void add() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: adding two positive vectors.

        Vector expected = new Vector(3.0, 3.0, 3.0);
        Vector actualValue = v1pos.add(v2pos);

        assertEquals(expected, actualValue,"Should Get back Vector: (3,3,3)");

        // TC02: adding two negative vectors
        expected = new Vector(-3.0, -3.0, -3.0);
        actualValue = v1neg.add(v2neg);

        assertEquals(expected, actualValue,"Should Get back Vector: (-3,-3,-3)");

        // TC03: adding one negative and one positive Vectors together.
        expected = new Vector(-1.0, -1.0, -1.0);
        actualValue = v1pos.add(v2neg);

        assertEquals( expected, actualValue,"Should Get back Vector: (-1,-1,-1)");

        // =============== Boundary Values Tests ==================
        // TC04: adding 2 numbers equal in size but different signs (sum equal to ZERO).
        assertThrows(IllegalArgumentException.class, () -> v1pos.add(v1neg),
                "Vector ZERO should not be created by adding 2 equal size vectors.");
    }

    @Test
    void subtract() {

        // ============ Equivalence Partitions Tests ==============
        // TC01: subtracting two positive vectors.
        Vector expected = new Vector(-1.0, -1.0, -1.0);
        Vector actualValue = v1pos.subtract(v2pos);

        assertEquals(expected, actualValue,"Should Get back Vector: (-1,-1,-1)");

        // TC02: subtracting two negative vectors
        expected = new Vector(1.0, 1.0, 1.0);
        actualValue = v1neg.subtract(v2neg);

        assertEquals(expected, actualValue,"Should Get back Vector: (1,1,1)");

        // TC03: subtracting one negative from one positive Vector.
        expected = new Vector(3.0, 3.0, 3.0);
        actualValue = v1pos.subtract(v2neg);

        assertEquals(expected, actualValue,"Should Get back Vector: (3,3,3)");
        // =============== Boundary Values Tests ==================
        // TC04: subtracting vector from himself or on that equal to him (result in
        // Vector ZERO).
        assertThrows(IllegalArgumentException.class,() -> v1pos.subtract(v1pos),
                "Vector ZERO should not be created.");
    }

    @Test
    void scale() {
        Vector vscale = v1.scale(-1);
        assertEquals(v1.length(),vscale.length());
    }

    @Test
    public void testCrossProduct() {

        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001,"crossProduct() wrong result length" );

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)),"crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v2)),"crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
//        Vector v3 = new Vector(-2, -4, -6);
//        assertThrows("crossProduct() for parallel vectors does not throw an exception",
//                IllegalArgumentException.class, () -> v1.crossProduct(v3));
//         try {
//             v1.crossProduct(v2);
//             fail("crossProduct() for parallel vectors does not throw an exception");
//         } catch (Exception e) {}
    }


    @Test
    void dotProduct() {
        // setup
        Vector vector = new Vector(1.0, 1.0, 1.0);
        Vector otherVector = new Vector(1.0, 2.0, 4.0);
        Vector orthogonalVector = new Vector(1.0, 1.0, -2.0);
        Vector scaledVectorByTwo = new Vector(2.0, 2.0, 2.0);
        Vector scaledVectorByMinusTwo = new Vector(-2.0, -2.0, -2.0);

        // ============ Equivalence Partitions Tests ==============
        // TC01: testing two linearly independent Vectors.
        double expected = 7.0;
        double actualValue = vector.dotProduct(otherVector);

        assertEquals( expected, actualValue, 0.00000001,"Should Get back Real Number(double): 7.0");

        // =============== Boundary Values Tests ==================
        // TC02: two orthogonal vectors should return 0.0
        expected = 0.0;
        actualValue = vector.dotProduct(orthogonalVector);

        assertEquals( expected, actualValue, 0.00000001,"Should Get back Real Number(double): 0.0");
        // TC03: two Vector on the same line and same direction.
        expected = 6.0;
        actualValue = vector.dotProduct(scaledVectorByTwo);

        assertEquals( expected, actualValue, 0.00000001,"Should Get back Real Number(double): 6.0");

        // TC04: two Vector on the same line and opposite direction.
        expected = -6.0;
        actualValue = vector.dotProduct(scaledVectorByMinusTwo);

        assertEquals( expected, actualValue, 0.00000001,"Should Get back Real Number(double): 6.0");
    }

    @Test
    void lengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Testing distanceSquared()
        Vector vector = new Vector(1, 2, 3);
        boolean lengthTestOk = isZero(vector.lengthSquared() - 14);
        assertTrue(lengthTestOk,"lengthSquared() wrong value");
    }

    @Test
    void length() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Testing length
        boolean lengthTestOk = isZero(new Vector(0, 3, 4).length() - 5);
        assertTrue(lengthTestOk,"length() wrong value");
    }

    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Testing Normalize
        Vector vector = new Vector(1, 2, 3);
        Vector vectorCopy = new Vector(vector.getHead());
        Vector normalizeVectorCopy = vectorCopy.normalize();

        assertTrue(vectorCopy.equals(normalizeVectorCopy),"normalize() function should not create a new vector");

        boolean unitVectorLengthOK = isZero(normalizeVectorCopy.length() - 1);
        assertTrue(unitVectorLengthOK,"normalize() result is not a unit vector");
    }

    @Test
    void normalized() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Testing for normalized()
        Vector vector = new Vector(1, 2, 3);
        Vector normalizedVector = vector.normalized();

        assertFalse(normalizedVector.equals(vector),"normalized() function does not create a new vector");
    }

    @Test
    public void testEquals() {
        // setup
        Vector vector = new Vector(1.0, 1.0, 1.0);
        Vector sameInValuesVector = new Vector(1.0, 1.0, 1.0);
        Vector differentInValuesVector = new Vector(2.0, 2.0, 2.0);
        Vector sameRefVector = vector;
        Point3D differentClassObj = new Point3D(1.0, 1.0, 1.0);

        // ============ Equivalence Partitions Tests ==============
        // TC01: two equal in values Vectors
        assertTrue(vector.equals(sameInValuesVector),"Vectors should Be equals");

        // TC02: two different in values Vectors
        assertFalse(vector.equals(differentInValuesVector),"Vectors should not Be equals");

        // =============== Boundary Values Tests ==================
        // TC03: same object different references
        assertTrue(vector.equals(sameRefVector),"Both references to same object should Be equals");
        // TC04: different class object
        assertFalse(vector.equals(differentClassObj),"Vectors should not Be equals");
    }
}