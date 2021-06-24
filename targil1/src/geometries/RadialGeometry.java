package geometries;

public abstract class RadialGeometry {
    protected final double _radius;

    public RadialGeometry(double radius) {
        if(radius<=0){
            throw new IllegalArgumentException("radius can't be smaller than 0");
        }
        _radius = radius;
    }

    /**
     * getter for Radius
     *
     * @return - returns Radius
     */
    public double getRadius() {
        return _radius;
    }
}
