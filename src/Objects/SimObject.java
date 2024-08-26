package Objects;

import Base.ObjectManager;
import Components.Component;
import Utility.Vector;

import java.util.ArrayList;
import java.util.List;

public class SimObject {

    private String name;

    private Vector position;
    private List<Component> components = new ArrayList<>();


    public SimObject(String name, Vector position) {
        this.name = name;
        this.position = position;

        ObjectManager.getInstance().scheduleAddObject(this);
    }

    public SimObject(Vector position) {
        this.name = "Object_" + ObjectManager.getCount();
        this.position = position;

        ObjectManager.getInstance().scheduleAddObject(this);
    }

    public void addComponent(Component c) {
        if (getComponent(c.tag) != null) {
            System.out.println("Component [" + c.tag + "] already added to object!");
            return;
        }
        c.setObject(this);
        c.onStart();
        components.add(c);

    }

    public Component getComponent(String tag) {
        for (Component c : components)
            if (c.tag.equals(tag))
                return c;
        return null;
    }

    public void removeComponent(Component c) {
        c.onRemove();
        components.remove(c);
    }

    public void update() {
        for (Component c : components)
            c.update();
    };

    public Vector getPosition() {
        return position;
    }
    public void setPosition(Vector position) {
        this.position = position;
    }

}
