package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry {

    private Point3D center;
    private double radius;

    /**
     * constractor
     * @param center - point
     * @param radius - Double
     */
    public Sphere(Point3D center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * getter for Center
     * @return center
     */
    public Point3D getCenter() {
        return center;
    }

    /**
     * getter for Radius
     * @return - returns Radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - point after normalisation
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        return point3d.subtract(this.center).normalize();
    }

    /**
     *
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Sphere{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
