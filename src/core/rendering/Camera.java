package core.rendering;

import math.Vector2;

public class Camera {

    private static ViewBounds worldSpace;
    private static ViewBounds viewportSpace;

    private static float xWorldToViewport;
    private static float yWorldToViewport;
    private static float xViewportToWorld;
    private static float yViewportToWorld;


    public static void setup(ViewBounds worldSpace, ViewBounds viewportSpace) {
        Camera.worldSpace = worldSpace;
        Camera.viewportSpace = viewportSpace;
        Camera.xWorldToViewport = viewportSpace.getWidth() / worldSpace.getWidth();
        Camera.yWorldToViewport = viewportSpace.getHeight() / worldSpace.getHeight();
        Camera.xViewportToWorld = 1 / xWorldToViewport;
        Camera.yViewportToWorld = 1 / yWorldToViewport;
    }

    public static Vector2 worldToViewport(float x, float y) {
        float viewportX = (x - worldSpace.getMinX()) * xWorldToViewport + viewportSpace.getMinX();
        float viewportY = (y - worldSpace.getMinY()) * yWorldToViewport + viewportSpace.getMinY();
        return new Vector2(viewportX, viewportY);
    }

    public static Vector2 worldToViewport(Vector2 point) {
        return worldToViewport(point.getX(), point.getY());
    }

    public static Vector2 viewportToWorld(float x, float y) {
        float worldX = (x - viewportSpace.getMinX()) * xViewportToWorld + worldSpace.getMinX();
        float worldY = (y - viewportSpace.getMinY()) * yViewportToWorld + worldSpace.getMinY();
        return new Vector2(worldX, worldY);
    }

    public static Vector2 viewportToWorld(Vector2 point) {
        return viewportToWorld(point.getX(), point.getY());
    }

}
