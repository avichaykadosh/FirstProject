package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * @author Avihay Kadosh - 316243070
 * */


public interface Geometry extends Intersectable{
    /**
     *
     * @param point3d - point on the shape surface
     * @return - A perpendicular unit vector to the shape in the point.
     */
    public Vector getNormal(Point3D point3d);

}
