package Components;

import Objects.SimObject;
import Utility.Color;

public abstract class Renderer extends Component{

    protected Color color;
    protected boolean solid = false;

    public Renderer(String tag) {
        super(tag);
        color = new Color(200);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}
