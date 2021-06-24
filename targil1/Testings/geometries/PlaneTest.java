package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Avihay Kadosh - 316243070
 * */

class PlaneTest {

    @Test
    void getNormal() {
        double sqrt3 = Math.sqrt(1d / 3);
        Plane plane = new Plane(new Point3D(0, 0, 1), new Vector(sqrt3, sqrt3, sqrt3));

        assertEquals(new Vector(sqrt3, sqrt3, sqrt3), plane.getNormal(new Point3D(0, 0, 1)),"Bad normal to Plane");
    }
}