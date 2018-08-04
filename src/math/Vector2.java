package math;

public class Vector2 {

    private static final Vector2 zero = new Vector2(0, 0);

    private float x;
    private float y;

    public Vector2() {
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("{x = %f, y = %f}", x, y);
    }

    public static Vector2 zero() {
        return zero;
    }
}
