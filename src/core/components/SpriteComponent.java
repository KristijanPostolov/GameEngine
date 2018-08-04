package core.components;

import core.filesystem.Files;
import core.filesystem.ImageDimensions;
import core.rendering.RenderingLayer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteComponent extends Component {

    private String imageName;
    private float width;
    private float height;
    private RenderingLayer renderingLayer;
    private int orderInLayer;

    private Transform transform;

    public SpriteComponent(String imageName) {
        this(imageName, RenderingLayer.DEFAULT);
    }

    public SpriteComponent(String imageName, RenderingLayer renderingLayer) {
        this(imageName, renderingLayer, 0);
    }

    public SpriteComponent(String imageName, RenderingLayer renderingLayer, int orderInLayer) {
        // TODO: Default values configuration
        this(imageName, renderingLayer, orderInLayer, 100);
    }

    public SpriteComponent(String imageName, RenderingLayer renderingLayer, int orderInLayer, int pixelsPerUnit) {
        this.imageName = imageName;
        this.renderingLayer = renderingLayer;
        this.orderInLayer = orderInLayer;

        ImageDimensions dimensions = Files.getImageDimensions(imageName);
        float aspectRatio = dimensions.height / (float) dimensions.width;
        this.width = dimensions.width / pixelsPerUnit;
        this.height = this.width * aspectRatio;
    }

    public String getImageName() {
        return imageName;
    }

    public Transform getTransform() {
        return transform;
    }

    @Override
    public void init() {
        transform = gameObject.getTransform();
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public RenderingLayer getRenderingLayer() {
        return renderingLayer;
    }

    public void setRenderingLayer(RenderingLayer renderingLayer) {
        this.renderingLayer = renderingLayer;
    }

    public int getOrderInLayer() {
        return orderInLayer;
    }

    public void setOrderInLayer(int orderInLayer) {
        this.orderInLayer = orderInLayer;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }
}
