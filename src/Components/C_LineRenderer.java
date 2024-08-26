package Components;

import Base.ApplicationManager;
import Objects.SimObject;

import Utility.Vector;
import processing.core.PApplet;


public class C_LineRenderer extends Renderer {

    private SimObject point1;
    private SimObject point2;


    public C_LineRenderer(Vector point1, Vector point2) {
        super("LineRenderer");

        this.point1 = new SimObject(new Vector(point1.x, point1.y));
        this.point2 = new SimObject(new Vector(point2.x, point2.y));
    }

    public C_LineRenderer(SimObject s1, SimObject s2) {
        super("LineRenderer");

        this.point1 = s1;
        this.point2 = s2;
    }

    @Override
    public void update() {
        app.stroke(color.r, color.g, color.b, color.a);
        app.strokeWeight(2);
        app.line(point1.getPosition().x,  point1.getPosition().y, point2.getPosition().x, point2.getPosition().y);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRemove() {

    }

    public SimObject getPoint1() {
        return point1;
    }

    public SimObject getPoint2() {
        return point2;
    }
}
