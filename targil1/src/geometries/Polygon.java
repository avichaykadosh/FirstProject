package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

public class Polygon implements Geometry {
    protected List<Point3D> _vertices;
    protected Plane _plane;

    /**
     * construction
     *
     * @param _vertices - polygon _vertices
     * @param plane    - polygon plane
     */
    public Polygon(Point3D... vertices) {

        if (vertices.length < 3)
            throw new IllegalArgumentException("A polygon can't have less than 3 vertices");
        _vertices = List.of(vertices);
        // Generate the plane according to the first three vertices
        _plane = new Plane(vertices[0], vertices[1], vertices[2]);
        if (vertices.length == 3)
            return;

        Vector n = _plane.getNormal();

        Vector edge1 = vertices[vertices.length - 1].subtract(vertices[vertices.length - 2]);
        Vector edge2 = vertices[0].subtract(vertices[vertices.length - 1]);


        boolean positive = edge1.crossProduct(edge2).dotProduct(n) > 0;
        for (int i = 1; i < vertices.length; ++i) {
            // Test that the point is in the same plane as calculated originally
            if (!isZero(vertices[i].subtract(vertices[0]).dotProduct(n)))
                throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
            // Test the consequent edges have
            edge1 = edge2;
            edge2 = vertices[i].subtract(vertices[i - 1]);
            if (positive != (edge1.crossProduct(edge2).dotProduct(n) > 0))
                throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
        }
    }

    /**
     * constructor for triangle
     *
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     */
    public Polygon(Point3D p1, Point3D p2, Point3D p3) {
    }

    /**
     * getter for vertices
     *
     * @return vertices
     */
    public List<Point3D> getVertices() {
        return _vertices;
    }

    /**
     * getter for plane
     *
     * @return returns plane
     */
    public Plane getPlane() {
        return _plane;
    }

    /**
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "polygon{" +
                "vertices=" + _vertices +
                ", plane=" + _plane +
                '}';
    }

    /**
     * overrides getNormal
     *
     * @param point - point
     * @return returns normal plane
     */
    @Override
    public Vector getNormal(Point3D point) {
        return _plane.getNormal();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
