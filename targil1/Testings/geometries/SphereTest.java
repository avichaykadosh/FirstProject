package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Avihay Kadosh - 316243070
 * */

class SphereTest {

    @Test
    void testGetNormal() {

        Sphere sphere = new Sphere(new Point3D(0, 0, 1), 5);
        Point3D p = new Point3D(0, 0, 6);

        Vector expected = new Vector(0, 0, 1);
        Vector actualValue = p.subtract(sphere.getCenter()).normalize();

        assertEquals( expected, actualValue,"Bad normal to Sphere");

    }
}