package Ray;

import Objects.SimObject;
import Utility.Vector;

public class RayHit {
    public SimObject object;
    public Vector intersection;

    public RayHit(SimObject object, Vector intersection) {
        this.object = object;
        this.intersection = intersection;
    }
}
