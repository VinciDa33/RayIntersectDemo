package Utility;

public class Color {
    public int r;
    public int g;
    public int b;
    public int a;

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Color (int v) {
        this.r = v;
        this.g = v;
        this.b = v;
        this.a = 255;
    }
}
