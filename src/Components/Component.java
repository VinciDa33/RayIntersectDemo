package Components;

import Base.ApplicationManager;
import Objects.SimObject;
import processing.core.PApplet;

public abstract class Component {
    protected SimObject object;
    protected PApplet app;
    public final String tag;
    public Component(String tag) {
        this.tag = tag;
        this.app = ApplicationManager.getInstance().getApp();
    }
    public abstract void update();

    public abstract void onStart();
    public abstract void onRemove();

    public SimObject getObject() {
        return object;
    }

    public void setObject(SimObject object) {
        this.object = object;
    }
}
