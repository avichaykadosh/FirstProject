package primitives;

import java.util.Objects;
/**
 * @author Avihay Kadosh - 316243070
 * */

public class Ray {
    final Point3D _p0;
    final Vector _dir;

    /**
     * constructor
     * @param p0 - a point3D
     * @param dir - a vector
     */
    public Ray(Point3D p0, Vector dir) {
        _p0 = p0;
        _dir = dir;
    }

    /**
     * getter for p0
     * @return - returns a point3D
     */
    public Point3D getP0() {
        return _p0;
    }

    /**
     * getter for dir
     * @return - returns a vector
     */
    public Vector getDir() {
        return _dir;
    }

    /**
     *
     * @param t -  number
     * @return -  a point with t distance from Ray
     */
    public Point3D getPoint(double t) {
        return _p0.add(_dir.scale(t));
    }

    /**
     * override toString
     * @return - returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + _p0 +
                ", dir=" + _dir +
                '}';
    }

    /**
     * override equals
     * @param o -  a bool
     * @return - returns a bool answer if they both are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals(ray._p0) && _dir.equals(ray._dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_p0, _dir);
    }
}
