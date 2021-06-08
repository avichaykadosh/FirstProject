package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {

    private double height;

    /**
     * constructor
     * @param axisRay axisRay
     * @param radius radius
     * @param height height
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    /**
     * getter for height
     * @return returns height
     */
    public double getHeight() {
        return height;
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
}
