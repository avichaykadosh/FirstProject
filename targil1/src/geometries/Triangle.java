package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class Triangle extends Polygon {

    /**
     * constructor
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     */
    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(p1, p2, p3);
    }

//    public Triangle(List<Point3D> vertices, Plane plane) {
//        super(vertices, plane);
//    }

    @Override
    public String toString() {
        return "Triangle{}";
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
