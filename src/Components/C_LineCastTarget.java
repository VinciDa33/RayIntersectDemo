package Components;

import Base.CollisionManager;
import Objects.SimObject;
import Ray.CastTarget;
import Ray.Ray;
import Ray.RayHit;
import Utility.SlopeIntercept;
import Utility.Vector;

import java.util.ArrayList;
import java.util.List;

public class C_LineCastTarget extends Component implements CastTarget {

    private SimObject point1;
    private SimObject point2;

    private SlopeIntercept slopeIntercept;

    public C_LineCastTarget() {
        super("LineCastTarget");
    }

    public C_LineCastTarget(SimObject s1, SimObject s2) {
        super("LineCastTarget");
        this.point1 = s1;
        this.point2 = s2;
    }

    @Override
    public void update() {
        calculateSlopeIntercept();
    }

    @Override
    public void onStart() {
        CollisionManager.getInstance().addCastTarget(this);

        if (point1 == null) {
            Component c = object.getComponent("LineRenderer");
            if (c instanceof C_LineRenderer lr) {
                this.point1 = lr.getPoint1();
                this.point2 = lr.getPoint2();
            }
        }

        calculateSlopeIntercept();
    }

    @Override
    public void onRemove() {
        CollisionManager.getInstance().removeCastTarget(this);
    }

    @Override
    public List<RayHit> intersect(Ray ray) {
        List<RayHit> results = new ArrayList<>();

        SlopeIntercept rayIntercept = ray.getSlopeIntercept();

        //System.out.println("Ray.Ray: " + ray.a + "x +" + ray.b);
        //System.out.println("Components.Line: " + a + "x +" + b);

        //a * x + b = ray.a * x + ray.b;
        //a * x + b - ray.a * x = ray.b;
        //a * x - ray.a * x = ray.b - b;
        //(a - ray.a) * x = ray.b - b;
        float x = (rayIntercept.b - slopeIntercept.b) / (slopeIntercept.a - rayIntercept.a);
        //y = a * x + b;
        float y = slopeIntercept.a * x + slopeIntercept.b;

        //System.out.println("Intersection: " + x + ":" + y);

        if (checkValidity(ray, new Vector(x, y)))
            results.add(new RayHit(this.object, new Vector(x, y)));
        return results;
    }

    private void calculateSlopeIntercept() {
        this.slopeIntercept = new SlopeIntercept(point1.getPosition(), point2.getPosition());
    }

    private boolean checkValidity(Ray ray, Vector intersectPoint) {
        Vector pPoint1 = point1.getPosition();
        Vector pPoint2 = point2.getPosition();

        if (ray.getDirection().x > 0 && intersectPoint.x < ray.getOrigin().x)
            return false;
        if (ray.getDirection().x < 0 && intersectPoint.x > ray.getOrigin().x)
            return false;
        if (ray.getDirection().y > 0 && intersectPoint.y < ray.getOrigin().y)
            return false;
        if (ray.getDirection().y < 0 && intersectPoint.y > ray.getOrigin().y)
            return false;

        if (intersectPoint.x > pPoint1.x && intersectPoint.x > pPoint2.x)
            return false;
        if (intersectPoint.x < pPoint1.x && intersectPoint.x < pPoint2.x)
            return false;
        if (intersectPoint.y > pPoint1.y && intersectPoint.y > pPoint2.y)
            return false;
        if (intersectPoint.y < pPoint1.y && intersectPoint.y < pPoint2.y)
            return false;


        return true;
    }
}
