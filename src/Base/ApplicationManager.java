package Base;

import processing.core.PApplet;

public class ApplicationManager {

    private static ApplicationManager instance;
    private static double delta;
    private PApplet pApp;
    private ObjectManager um;

    //Singleton
    public static ApplicationManager getInstance() {
        if (instance == null)
            instance = new ApplicationManager();
        return instance;
    }

    //Singleton with applet assignment
    public static ApplicationManager getInstance(PApplet applet) {
        if (instance == null)
            instance = new ApplicationManager();
        if (instance.pApp == null)
            instance.setApp(applet);
        return instance;
    }
    private ApplicationManager() {}

    private void setApp(PApplet applet) {
        this.pApp = applet;
    }
    public PApplet getApp() {
        return pApp;
    }

    public void start() {
        um = ObjectManager.getInstance();
        new Setup().setup();
    }

    public void update(double d) {
        delta = d;

        pApp.background(30);
        um.update();
    }

    public static double getDelta() {
        return delta;
    }
}
