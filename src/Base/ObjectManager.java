package Base;

import Objects.SimObject;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {

    private static int count = 0;

    private static ObjectManager instance;
    private List<SimObject> objects = new ArrayList<>();
    private List<SimObject> scheduled = new ArrayList<>();

    public static ObjectManager getInstance() {
        if (instance == null)
            instance = new ObjectManager();
        return instance;
    }
    private ObjectManager() {}

    public void update() {
        for (SimObject so : objects)
            so.update();
        objects.addAll(scheduled);
        scheduled.clear();
    }

    public void addObject(SimObject so) {
        objects.add(so);
        count++;
    }

    public void scheduleAddObject(SimObject so) {
        scheduled.add(so);
    }

    public void removeOject(SimObject so) {
        objects.remove(so);
    }

    public static int getCount () {
        return count;
    }
}
