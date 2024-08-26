package Ray;

import Base.ApplicationManager;
import Components.C_CircleRenderer;
import Objects.SimObject;
import Utility.Color;
import Utility.Vector;
import processing.core.PApplet;

import java.util.List;

public class RayCaster extends SimObject {

    private PApplet app;
    private Vector direction;
    private boolean drawRay = false;

    public RayCaster(Vector position, boolean drawRay) {
        super(position);
        app = ApplicationManager.getInstance().getApp();

        this.drawRay = drawRay;
        direction = new Vector(-0.2f, -1f);
    }

    @Override
    public void update() {
        float delta = (float) ApplicationManager.getDelta() * 0.001f;
        Vector position = getPosition();

        direction.rotate(5f * delta);

        if (drawRay) {
            app.stroke(80);
            app.strokeWeight(1);
            app.line(position.x, position.y, position.x + (direction.x * 1000f), position.y + (direction.y * 1000f));
        }


        Ray ray = new Ray(position, direction, 0);

        /*
        RayHit hit = ray.castFirst();
        if (hit != null) {
            SimObject circle = new SimObject(new Vector(hit.intersection.x, hit.intersection.y));
            C_CircleRenderer cr = new C_CircleRenderer(2);
            cr.setSolid(true);
            cr.setColor(new Color(200, 80, 80));
            circle.addComponent(cr);

            //app.fill(200, 80, 80);
            //app.noStroke();
            //app.circle(hit.intersection.x, hit.intersection.y, 10);
        }
         */


        List<RayHit> hits = ray.castAll();

        for (RayHit hit : hits) {
            app.fill(200, 80, 80);
            app.noStroke();
            app.circle(hit.intersection.x, hit.intersection.y, 10);
        }
    }
}
