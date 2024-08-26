package Components;

import Base.InputManager;
import Utility.Color;
import Utility.Vector;

public class C_Movable extends Component {


    private float size;
    private Color highlightColor = new Color(200, 120, 120);
    private Color baseColor;
    private C_CircleRenderer circleRenderer;

    private boolean isDragging = false;

    public C_Movable(float size) {
        super("Movable");
        this.size = size;
    }

    public C_Movable(float size, Color highlight) {
        super("Movable");
        this.size = size;
        this.highlightColor = highlight;
    }


    @Override
    public void update() {
        Vector mousePos = new Vector(app.mouseX, app.mouseY);
        float distance = Vector.distance(mousePos, object.getPosition());

        boolean mouseOver = distance <= size;
        if (mouseOver) {
            circleRenderer.color = highlightColor;
            if (InputManager.mousePressed)
                isDragging = true;
        }
        else {
            circleRenderer.color = baseColor;
        }

        if (isDragging) {
            circleRenderer.color = highlightColor;
            object.setPosition(mousePos);
            if (InputManager.mouseReleased)
                isDragging = false;
        }
    }

    @Override
    public void onStart() {
        if (object.getComponent("CircleRenderer") == null) {
            circleRenderer = new C_CircleRenderer(size);
            object.addComponent(circleRenderer);
        }
        else
            circleRenderer = (C_CircleRenderer) object.getComponent("CircleRenderer");

        circleRenderer.solid = true;
        baseColor = circleRenderer.color;

    }

    @Override
    public void onRemove() {

    }
}
