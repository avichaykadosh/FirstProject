package geometries;


import primitives.Point3D;
import primitives.Vector;


public class Plane implements Geometry {
    final Point3D _q0;
    final Vector _normal;

    /**
     * plain constructor
     *
     * @param point  - A Point3D for indicating the plane using Vector and a point.
     * @param vector - A Vector for indicating the plane using Vector and a point.
     */
    public Plane(Point3D point, Vector vector) {
        _q0 = point;
        _normal = vector.normalized();
    }


    /**
     * constructor for Plane object
     *
     * @param p1 - a point3D
     * @param p2 - a point3D
     * @param p3 - a point3D
     */
    Plane(Point3D p1, Point3D p2, Point3D p3) {
        _q0 = p1;
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);
        _normal = v1.crossProduct(v2).normalize();
    }

    /**
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Plane{" +
                "q0=" + _q0 +
                ", normal=" + _normal +
                '}';
    }

    /**
     * Getter for the private field q0.
     *
     * @return Point3D - q0
     */
    public Point3D getQ0() {

        return _q0;
    }

    /**
     * Getter for the private field normal
     * @return Vector - unit Vector(length of 1) that is orthogonal to the plane.
     */
//    public Vector getNormal() {
//        return _normal;
//    }

    /**
     * @param point3d - point on the shape surface
     * @return - returns the normal of the vector
     */
    @Override
    public Vector getNormal(Point3D point3d) {
        return _normal;
    }

    public Vector getNormal() {
        return _normal;
    }
}
