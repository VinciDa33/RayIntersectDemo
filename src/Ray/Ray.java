package Ray;

import Base.CollisionManager;
import Utility.SlopeIntercept;
import Utility.Vector;

import java.util.ArrayList;
import java.util.List;

public class Ray {

    private Vector origin;
    private Vector direction;

    //Line intercept values | y = ax + b
    private SlopeIntercept slopeIntercept;

    public Ray(Vector origin, Vector direction, int distance) {
        this.origin = origin;
        this.direction = direction.normalized();

        Vector point = origin.added(direction);

        if (origin.x - point.x == 0) {
            //Specify line as vertical, through some value 'x'
            this.slopeIntercept = new SlopeIntercept(origin.x, origin.x, true);
        }
        else {

            float a = (origin.y - point.y) / (origin.x - point.x);
            float b = origin.y - a * origin.x;

            this.slopeIntercept = new SlopeIntercept(a, b);
        }
    }

    public SlopeIntercept getSlopeIntercept () {
        return slopeIntercept;
    }

    public Vector getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }


    public RayHit castFirst() {
        List<RayHit> allHits = castAll();

        float shortest = Float.MAX_VALUE;
        RayHit current = null;

        for (RayHit rh : allHits) {
            float distance = Vector.distance(rh.intersection, origin);
            if (distance < shortest) {
                shortest = distance;
                current = rh;
            }
        }

        return current;
    }

    public List<RayHit> castAll() {
        List<RayHit> result = new ArrayList<>();

        List<CastTarget> targets = CollisionManager.getInstance().getAllCastTargets();
        for (CastTarget target : targets) {
            result.addAll(target.intersect(this));
        }

        return result;
    }
}
