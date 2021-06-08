package geometries;
import primitives.Ray;
import primitives.Point3D;
import primitives.Vector;

public class Tube implements Geometry{
    protected Ray axisRay;
    protected double radius;

    /**
     * constructor
     * @param axisRay - Ray
     * @param radius - double radious
     */
    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    /**
     * getter for axisRay
     * @return - returns axisray
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    /**
     * getter for radius
     * @return - returns radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     *
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - point after normalisation
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        double t = this.axisRay.getDir().dotProduct(point3d.subtract(this.axisRay.getP0()));
        Point3D projection = this.axisRay.getP0().add(this.axisRay.getDir().scale(t));
        return point3d.subtract(projection).normalize();
    }
}
