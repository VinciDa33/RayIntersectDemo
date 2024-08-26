package Base;

import Components.*;
import Objects.SimObject;
import Ray.RayCaster;
import Utility.Color;
import Utility.Vector;

public class Setup {
    public void setup() {

        SimObject s1 = new SimObject(new Vector(100, 100));
        s1.addComponent(new C_LineRenderer(new Vector(0, 150), new Vector(150, 0)));
        s1.addComponent(new C_LineCastTarget());

        SimObject s2 = new SimObject(new Vector(800, 800));
        C_LineRenderer lr2 = new C_LineRenderer(new Vector(-300, 0), new Vector(0, -200));
        lr2.setColor(new Color(150, 150, 220));
        s2.addComponent(lr2);
        s2.addComponent(new C_LineCastTarget());

        SimObject s3 = new SimObject(new Vector(600, 300));
        s3.addComponent(new C_CircleRenderer(100));
        s3.addComponent(new C_CircleCastTarget());

        SimObject s4 = new SimObject(new Vector(500, 800));
        s4.addComponent(new C_Movable(5));


        SimObject p1 = new SimObject(new Vector(100, 200));
        p1.addComponent(new C_Movable(5));

        SimObject p2 = new SimObject(new Vector(100, 800));
        p2.addComponent(new C_Movable(5));

        SimObject line = new SimObject(new Vector(0, 0));
        line.addComponent(new C_LineRenderer(p1, p2));
        line.addComponent(new C_LineCastTarget());

        RayCaster caster = new RayCaster(new Vector(500, 500), true);
        ObjectManager.getInstance().addObject(caster);
    }
}
