package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry {

    final Point3D _center;
    final double _radius;

    /**
     * constractor
     * @param center - point
     * @param radius - Double
     */
    public Sphere(Point3D center, double radius) {
        _center = center;
        _radius = radius;
    }

    /**
     * getter for Center
     * @return center
     */
    public Point3D getCenter() {
        return _center;
    }

    /**
     * getter for Radius
     * @return - returns Radius
     */
    public double getRadius() {
        return _radius;
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - point after normalisation
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        //TODO create normal vector
        return point3d.subtract(_center).normalize();
    }

    /**
     *
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + _center +
                ", radius=" + _radius +
                '}';
    }
}
