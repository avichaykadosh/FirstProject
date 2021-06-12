package geometries;
import primitives.Ray;
import primitives.Point3D;
import primitives.Vector;

public class Tube implements Geometry{
    final Ray _axisRay;
    final double _radius;

    /**
     * constructor
     * @param axisRay - Ray
     * @param radius - double radious
     */
    public Tube(Ray axisRay, double radius) {
        _axisRay = axisRay;
        _radius = radius;
    }

    /**
     * getter for axisRay
     * @return - returns axisray
     */
    public Ray getAxisRay() {
        return _axisRay;
    }

    /**
     * getter for radius
     * @return - returns radius
     */
    public double getRadius() {
        return _radius;
    }

    /**
     *
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + _axisRay +
                ", radius=" + _radius +
                '}';
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - point after normalisation
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        double dir = _axisRay.getDir().dotProduct(point3d.subtract(_axisRay.getP0()));
        Point3D projection = _axisRay.getP0().add(_axisRay.getDir().scale(dir));
        return point3d.subtract(projection).normalize();
    }
}
