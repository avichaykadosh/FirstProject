package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Avihay Kadosh - 316243070
 * */

class TubeTest {

    @Test
    void testGetNormal() {
        Point3D p = new Point3D(-5, 0, 4.32);
        Point3D p0 = new Point3D(0, 0, 1);
        Vector dirVector = new Vector(0, 0, 1);
        Ray axisRay = new Ray(p0, dirVector);
        Tube tube = new Tube(5,axisRay);

        // calculate the o point.
        Vector vector = p.subtract(tube.getAxisRay().getP0());
        double t = tube.getAxisRay().getDir().dotProduct(vector);
        Point3D o = tube.getAxisRay().getP0().add(tube.getAxisRay().getDir().scale(t));

        // test for normal
        Vector actual = p.subtract(o).normalize();

        Vector expected = new Vector(-1, 0, 0);
        assertEquals(expected, actual,"normal was not correct.");
    }
}