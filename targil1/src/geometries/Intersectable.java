package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/**
 *TODO - description
 */
public interface Intersectable {
    /**
     * finds all intersection pointsfrom the ray
     * @param ray ray
     * @return intersection points
     */
    public List<Point3D> findIntersections(Ray ray);
}
