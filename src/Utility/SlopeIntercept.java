package Utility;

public class SlopeIntercept {
    public float a;
    public float b;
    boolean vertical = false;

    public SlopeIntercept (float a, float b) {
        this.a = a;
        this.b = b;
    }

    public SlopeIntercept(float a, float b, boolean v) {
        this.a = a;
        this.b = b;
        this.vertical = v;
    }

    public SlopeIntercept(Vector point1, Vector point2) {
        if (point1.x == point2.x) {
            vertical = true;
            a = point1.x;
            b = point1.x;
            return;
        }

        float a = (point1.y - point2.y) / (point1.x - point2.x);
        float b = point1.y - a * point1.x;
        this.a = a;
        this.b = b;
    }

}
