package primitives;

import java.util.Objects;
/**
 * @author Avihay Kadosh - 316243070
 * */

public class Ray {
    private Point3D p0;
    private Vector dir;

    /**
     * constructor
     * @param p0 - a point3D
     * @param dir - a vector
     */
    public Ray(Point3D p0, Vector dir) {
        this.p0 = p0;
        this.dir = dir;
    }

    /**
     * getter for p0
     * @return - returns a point3D
     */
    public Point3D getP0() {
        return p0;
    }

    /**
     * getter for dir
     * @return - returns a vector
     */
    public Vector getDir() {
        return dir;
    }

    /**
     *
     * @param t -  number
     * @return -  a point with t distance from Ray
     */
    public Point3D getPoint(double t) {
        return p0.add(dir.scale(t));
    }

    /**
     * override toString
     * @return - returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
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
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }
}
