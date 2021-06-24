package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Cylinder extends Tube {

    final double _height;

    /**
     * constructor
     * @param axisRay axisRay
     * @param radius radius
     * @param height height
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(radius, axisRay);
        _height = height;
    }

    /**
     * getter for height
     * @return returns height
     */
    public double getHeight() {
        return _height;
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - returns null
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        return null;
    }


    @Override
    public String toString() {
        return "Cylinder{" +
                "_height=" + _height +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
