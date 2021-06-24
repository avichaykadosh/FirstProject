package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Sphere extends RadialGeometry implements Geometry {

    final Point3D _center;

    /**
     * constractor
     * @param center - point
     * @param radius - Double
     */
    public Sphere(double radius,Point3D center) {
        super(radius);
        _center = center;
    }

    /**
     * getter for Center
     * @return center
     */
    public Point3D getCenter() {
        return _center;
    }

    /**
     * override of getNormal
     * @param point3d - point on the shape surface
     * @return - point after normalisation
     */
    @Override
    public Vector getNormal(Point3D point3d) {
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

    @Override
    public List<Point3D> findIntersections(Ray ray) {
//        List<Point3D> result = null;

        Point3D P0 = ray.getP0();
        Vector v = ray.getDir();

        if(_center.equals(P0)){
            throw new IllegalArgumentException("ray origin is not in sphere center");
        }
        Vector u = _center.subtract(P0);

        double tm =alignZero(u.dotProduct(v));
        double d = alignZero( Math.sqrt(u.lengthSquared() - tm*tm));

        if(d>_radius){
            return null;
        }
        double th = alignZero(Math.sqrt(_radius*_radius - d*d));

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0){
            Point3D p1 = P0.add(v.scale(t1));
            Point3D p2 = P0.add(v.scale(t2));

            return List.of(p1,p2);
        }
        else if(t1 > 0){
            Point3D p1 = P0.add(v.scale(t1));
            return List.of(p1);
        }
        else if(t2 >= 0){
            Point3D p2 = P0.add(v.scale(t2));
            return List.of(p2);
        }

        return null;
    }
}
