package primitives;
import java.util.Objects;

import static primitives.Point3D.ZERO;
/**
 * @author Avihay Kadosh - 316243070
 * */

public class Vector {
    Point3D _head;

    /**
     * constructor for Vector head
     * @param head - a point of the head
     */
    public Vector(Point3D head) {
        if (head.equals(ZERO)){
            throw new IllegalArgumentException("head cannot be (0,0,0)");
        }
        _head = head;
    }

    public Vector(double x, double y, double z) {
    }

    /**
     * getter for vector head
     * @return - returns the point
     */
    public Point3D getHead() {
        return new Point3D(_head._x, _head._y, _head._z);
    }

    /**
     * add function for vector
     * @param vec- a vector
     * @return - returns the vector after the addition
     */
    public Vector add(Vector vec) {
        return new Vector(_head.add(vec));
    }

    /**
     * subtract function for vector
     * @param vec - a vector
     * @return - returns the vector after the subtraction
     */
    public Vector subtract(Vector vec) {
        return _head.subtract(vec._head);
    }

    /**
     * sacle function scales the vector by a scalar number
     * @param scalar - a scalar
     * @return - returns a vector after enlarging it by a scalar
     */
    public Vector scale(double scalar) {
        return new Vector(scalar * _head._x.coord, scalar * _head._y.coord, scalar * _head._z.coord);
    }

    /**
     * calculates the cross between vectors, and returning the orthogonal vector to both
     * @param vec - a vector
     * @return - returns a vector orthogonal to both the originals
     */
    public Vector crossProduct(Vector vec) {
        double crossProductYZ = _head._y.coord * vec._head._z.coord;
        double crossProductZX = _head._z.coord * vec._head._x.coord;
        double crossProductXY = _head._x.coord * vec._head._y.coord;
        double crossProductZY = _head._z.coord * vec._head._y.coord;
        double crossProductXZ = _head._x.coord * vec._head._z.coord;
        double crossProductYX = _head._y.coord * vec._head._x.coord;

        return new Vector(crossProductYZ - crossProductZY, crossProductZX - crossProductXZ, crossProductXY - crossProductYX);
    }

    /**
     * calculating the dot product between two vectors, and returns the value of the dot
     * @param vec - a vector
     * @return - returns a point
     */
    public double dotProduct(Vector vec) {
        double dotProductX = _head._x.coord * vec._head._x.coord;
        double dotProductY = _head._y.coord * vec._head._y.coord;
        double dotProductZ = _head._z.coord * vec._head._z.coord;
        return dotProductX + dotProductY + dotProductZ;
    }

    /**
     * Calculates the length of the Vector, powerd by 2
     * @return  -returns the length power by 2
     */
    public double lengthSquared() {
        return _head.distanceSquared(ZERO);
    }

    /**
     * Calculates the length of the Vector
     * @return - returns the length
     */
    public double length() {
        return _head.distance(Point3D.ZERO);
    }

    /**
     * returns the vector to be with length size of 1
     * @return - returns the original vector
     */
    public Vector normalize() {
        double factor = 1 / this.length();
        _head = new Point3D(factor * _head._x.coord, factor * _head._y.coord, factor * _head._z.coord);
        return this;
    }

    /**
     * copy the vector to be with length size of 1
     * @return - returns a copy of the vector
     */
    public Vector normalized() {
        double factor = 1 / this.length();
        return scale(factor);
    }

    /**
     *
     * @return -returns a string with a description of a point (x,y,z)
     */
    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
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
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }
}
