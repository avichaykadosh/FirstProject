package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Avihay Kadosh - 316243070
 * */

class Point3DTest {

    Point3D p1 = new Point3D(1.0d, 2.0d,3.0d);
    Point3D p2 = new Point3D(1.0001d, 2.0d,3.0d);



    @Test
    void distanceSquared() {
        Point3D p3 = new Point3D(-1,-2,-3);
        double result = p1.distanceSquared(p3);
        System.out.println(result);
        assertTrue(true);
    }
}