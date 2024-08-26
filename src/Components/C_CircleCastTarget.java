package Components;

import Base.CollisionManager;
import Objects.SimObject;
import Ray.CastTarget;
import Ray.Ray;
import Ray.RayHit;
import Utility.CircleEquation;
import Utility.Vector;

import java.util.ArrayList;
import java.util.List;

public class C_CircleCastTarget extends Component implements CastTarget {

    private float radius = 0;
    private CircleEquation circleEquation;

    public C_CircleCastTarget() {
        super("CircleCastTarget");
    }

    public C_CircleCastTarget(float radius) {
        super("CircleCastTarget");
        this.radius = radius;
    }

    @Override
    public void update() {

    }

    @Override
    public void onStart() {
        CollisionManager.getInstance().addCastTarget(this);

        if (radius == 0) {
            Component c = object.getComponent("CircleRenderer");
            if (c instanceof C_CircleRenderer) {
                C_CircleRenderer cr = (C_CircleRenderer) c;
                this.radius = cr.getRadius();
            }
        }

        calculateCircleEquation();
    }

    @Override
    public void onRemove() {
        CollisionManager.getInstance().removeCastTarget(this);
    }

    @Override
    public List<RayHit> intersect(Ray ray) {
        List<RayHit> results = new ArrayList<>();

        float a = ray.getSlopeIntercept().a;
        float b = ray.getSlopeIntercept().b;
        float x = circleEquation.x;
        float y = circleEquation.y;
        float r = circleEquation.r;

        float A = 1 + (a * a);
        float B = -2 * x + 2 * a * (b - y);
        float C = (x * x) + ((b - y) * (b - y)) - (r * r);

        float dis = (B * B) - (4 * A * C);

        if (dis < 0)
            return results;

        float x1 = (-B + (float) Math.sqrt(dis)) / (2 * A);
        float x2 = (-B - (float) Math.sqrt(dis)) / (2 * A);

        float y1 = a * x1 + b;
        if (checkValidity(ray, new Vector(x1, y1)))
            results.add(new RayHit(object, new Vector(x1, y1)));

        //System.out.println(dis);

        if (dis < 0.1f)
            return results;

        float y2 = a * x2 + b;
        if (checkValidity(ray, new Vector(x2, y2)))
            results.add(new RayHit(object, new Vector(x2, y2)));

        return results;
    }

    private void calculateCircleEquation() {
        Vector position = object.getPosition();
        this.circleEquation = new CircleEquation(position.x, position.y, radius);
    }

    private boolean checkValidity(Ray ray, Vector intersectPoint) {
        Vector position = object.getPosition();

        float xHigh = position.x + radius;
        float xLow = position.x - radius;
        float yHigh = position.y + radius;
        float yLow = position.y - radius;


        if (ray.getDirection().x > 0 && (xHigh < ray.getOrigin().x && xLow < ray.getOrigin().x))
            return false;
        if (ray.getDirection().x < 0 && (xHigh > ray.getOrigin().x && xLow > ray.getOrigin().x))
            return false;
        if (ray.getDirection().y > 0 && (yHigh < ray.getOrigin().y && yLow < ray.getOrigin().y))
            return false;
        if (ray.getDirection().y < 0 && (yHigh > ray.getOrigin().y && yLow > ray.getOrigin().y))
            return false;

        return true;
    }
}
