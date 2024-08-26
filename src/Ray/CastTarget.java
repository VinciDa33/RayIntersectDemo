package Ray;

import Utility.Vector;

import java.util.List;

public interface CastTarget {
    public List<RayHit> intersect(Ray ray);
}
