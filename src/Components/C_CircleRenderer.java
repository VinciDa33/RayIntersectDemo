package Components;

import Base.ApplicationManager;
import Utility.Vector;
import processing.core.PApplet;

public class C_CircleRenderer extends Renderer {

    private float radius;

    public C_CircleRenderer(float radius) {
        super("CircleRenderer");
        this.radius = radius;
    }


    @Override
    public void update() {
        Vector position = object.getPosition();

        if (!solid)
            app.noFill();
        else
            app.fill(color.r, color.g, color.b, color.a);

        app.stroke(color.r, color.g, color.b, color.a);
        app.circle(position.x, position.y, radius * 2);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRemove() {

    }

    public float getRadius() {
        return radius;
    }
}
