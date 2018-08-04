package core.components;

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
        try {
            File file = new File(imageName);
            BufferedImage bufferedImage = ImageIO.read(file);
            float aspectRatio = bufferedImage.getHeight() / (float) bufferedImage.getWidth();
            this.width = bufferedImage.getWidth() / pixelsPerUnit;
            this.height = this.width * aspectRatio;
        } catch (IOException ex) {
            throw new IllegalArgumentException("There is no image file with the given imageName");
        }
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
