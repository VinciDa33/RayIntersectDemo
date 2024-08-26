package Utility;

public class Vector  {
    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void multiply(float value) {
        this.x *= value;
        this.y *= value;
    }

    public void divide(float value) {
        this.x /= value;
        this.y /= value;
    }

    public void add(Vector other) {
        this.x += other.x;
        this.y += other.y;
    }

    public void subtract(Vector other) {
        this.x -= other.x;
        this.y -= other.y;
    }

    public Vector multiplied(float value) {
        return new Vector(this.x * value, this.y * value);
    }

    public Vector divided(float value) {
        return new Vector(this.x / value, this.y / value);
    }

    public Vector added(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    public Vector subtracted(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y);
    }


    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        float mag = magnitude();
        x /= mag;
        y /= mag;
    }

    public Vector normalized() {
        float mag = magnitude();
        return new Vector(x / mag, y / mag);
    }

    public static float distance(Vector v1, Vector v2) {
        float dx = v1.x - v2.x;
        float dy = v1.y - v2.y;

        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public void rotate(float angle) {
        float theta = (float) Math.toRadians(angle);

        float cs = (float) Math.cos(theta);
        float sn = (float) Math.sin(theta);

        float px = x * cs - y * sn;
        float py = x * sn + y * cs;

        x = px;
        y = py;
    }

    public boolean compare(Vector v) {
        return this.x == v.x && this.y == v.y;
    }
}
