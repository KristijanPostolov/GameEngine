package core.rendering;

import math.Vector2;

public class ViewBounds {

    private final float minX;
    private final float maxX;
    private final float minY;
    private final float maxY;

    private final float width;
    private final float height;

    public ViewBounds(float minX, float maxX, float minY, float maxY) {
        if (minX >= maxX || minY >= maxY) {
            throw new IllegalArgumentException("Min coordinate cannot be greater or equal to max");
        }
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.width = maxX - minX;
        this.height = maxY - minY;
    }

    public ViewBounds(Vector2 center, float width, float aspectRatio) {
        this.width = width;
        this.height = width / aspectRatio;
        this.minX = center.getX() - width / 2;
        this.maxX = center.getX() + width / 2;
        this.minY = center.getY() - height / 2;
        this.maxY = center.getY() + height / 2;
    }

    public ViewBounds(float width, float aspectRatio) {
        this(Vector2.zero(), width, aspectRatio);
    }

    public float getMinX() {
        return minX;
    }

    public float getMaxX() {
        return maxX;
    }

    public float getMinY() {
        return minY;
    }

    public float getMaxY() {
        return maxY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
