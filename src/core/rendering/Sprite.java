package core.rendering;

import math.Vector2;

public class Sprite {

    public final String imageName;
    public final float[] coordinates;
    public final int renderingLayer;
    public final int orderInLayer;

    public Sprite(String imageName, Vector2 topLeft, Vector2 bottomLeft, Vector2 topRight, Vector2 bottomRight,
                  int renderingLayer, int orderInLayer) {
        this.imageName = imageName;
        this.coordinates = new float[]{
                topLeft.getX(), topLeft.getY(),
                bottomLeft.getX(), bottomLeft.getY(),
                bottomRight.getX(), bottomRight.getY(),
                topRight.getX(), topRight.getY()
        };
        this.renderingLayer = renderingLayer;
        this.orderInLayer = orderInLayer;
    }

    /*public Sprite(String imageName, float[] coordinates) {
        this.imageName = imageName;
        this.coordinates = coordinates;
    }*/
}
