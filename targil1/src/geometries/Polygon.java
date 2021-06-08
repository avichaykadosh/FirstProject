package geometries;
import primitives.*;
import java.util.List;

public class Polygon implements Geometry {
    protected List<Point3D> vertices;
    protected Plane plane;

    /**
     * construction
     * @param vertices - polygon vertices
     * @param plane - polygon plane
     */
    public Polygon(List<Point3D> vertices, Plane plane) {
        this.vertices = vertices;
        this.plane = plane;
    }

    /**
     * constructor for triangle
     * @param p1 point 1
     * @param p2 point 2
     * @param p3 point 3
     */
    public Polygon(Point3D p1, Point3D p2, Point3D p3) {
    }

    /**
     * getter for vertices
     * @return vertices
     */
    public List<Point3D> getVertices() {
        return vertices;
    }

    /**
     * getter for plane
     * @return returns plane
     */
    public Plane getPlane() {
        return plane;
    }

    /**
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "polygon{" +
                "vertices=" + vertices +
                ", plane=" + plane +
                '}';
    }

    /**
     * overrides getNormal
     * @param point - point
     * @return returns normal plane
     */
    @Override
    public Vector getNormal(Point3D point) {
        return plane.getNormal();
    }
}
