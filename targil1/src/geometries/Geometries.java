package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {
    private List<Intersectable> _intersectables = null;

    public Geometries() {
        _intersectables = new LinkedList<>();
    }

    public Geometries(Intersectable... intersectables) {
        _intersectables = new LinkedList<>();
        add(intersectables);
    }

    public void add(Intersectable... intersectables) {
        _intersectables.addAll(Arrays.asList(intersectables));
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> result = null;
        for(Intersectable element: _intersectables) {
            List<Point3D> elemList = element.findIntersections(ray);
            if (elemList != null){
                if(result==null){
                    result = new LinkedList<>();
                }
                result.addAll(elemList);
            }
        }

            return result;
    }
}
