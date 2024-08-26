package Base;

import processing.core.PApplet;

public class App extends PApplet {
    ApplicationManager am;

    long delta = 0;
    long last = 0;

    public void settings()
    {
        size(1000,1000);
    }

    public void setup()
    {
        am = ApplicationManager.getInstance(this);
        am.start();
    }


    public void draw()
    {

        delta = millis() - last;
        am.update(delta);
        last = millis();

        InputManager.mousePressed = false;
        InputManager.mouseReleased = false;
    }

    public void mousePressed() {
        InputManager.mousePressed = true;
    }

    public void mouseReleased() {
        InputManager.mouseReleased = true;
    }
}
