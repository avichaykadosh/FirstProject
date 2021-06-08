package primitives;

import java.util.Objects;
/**
 * @author Avihay Kadosh - 316243070
 * basic object for 3D Point
 */

public class Point3D {
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;

    public static Point3D ZERO = new Point3D(0, 0, 0);

    /**
     * @param x coordinate for X axis
     * @param y coordinate for Y axis
     * @param z coordinate for Z axis
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this(x.coord, y.coord, z.coord);
    }

    /**
     * constructor
     * @param x coordinate for X axis
     * @param y coordinate for Y axis
     * @param z coordinate for Z axis
     */
    public Point3D(double x, double y, double z) {
        _x = new Coordinate(x);
        _y = new Coordinate(y);
        _z = new Coordinate(z);

    }

    public Coordinate get_x() {
//        return new Coordinate(_x.coord);
        return _x;
    }

    public Coordinate get_y() {
//        return new Coordinate(_y.coord);
        return _y;
    }

    public Coordinate get_z() {
//        return new Coordinate(_z.coord);
        return _z;
    }

    /**
     *
     * @param o -  a bool
     * @return - returns a bool answer if they both are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) && _y.equals(point3D._y) && _z.equals(point3D._z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x.coord, _y.coord, _z.coord);
    }

    /**
     * @param point3D -  a point
     * @return - returns the distance
     */
    public double distanceSquared(Point3D point3D) {
        double x1 = _x.coord;
        double y1 = _y.coord;
        double z1 = _z.coord;
        double x2 = point3D._x.coord;
        double y2 = point3D._y.coord;
        double z2 = point3D._z.coord;
        return ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));

    }

    /**
     * returns the sqrt to complete the distanceSquared func
     *
     * @param point3D - a point
     * @return - returns the distance power by 2
     */
    public double distance(Point3D point3D) {
        return Math.sqrt(distanceSquared(point3D));
    }

    /**
     * add function allowes to add the coordinates to combined resaults, by algebra;
     * @param vector -  a vector
     * @return - point after adding the vector
     */
    public Point3D add(Vector vector) {
        return new Point3D(_x.coord + vector._head._x.coord, _y.coord + vector._head._y.coord,
                _z.coord + vector._head._z.coord);
    }

    /**
     *
     * @param point - a point
     * @return - returns the vector after subtracting
     */
    public Vector subtract(Point3D point) {
        return new Vector(_x.coord - point._x.coord, _y.coord - point._y.coord, _z.coord - point._z.coord);
    }
}
