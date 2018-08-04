package core.rendering;

import core.components.SpriteComponent;
import core.components.Transform;
import math.Vector2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RenderSystem {

    private final RenderingEngine renderingEngine;

    public RenderSystem(RenderingEngine renderingEngine) {
        this.renderingEngine = renderingEngine;
    }

    public void render(List<SpriteComponent> spriteComponents) {
        Sprite[] sprites = new Sprite[spriteComponents.size()];
        int index = 0;
        for (SpriteComponent spriteComponent : spriteComponents) {
            String imageName = spriteComponent.getImageName();
            Transform transform = spriteComponent.getTransform();
            float worldWidth = spriteComponent.getWidth() * transform.getScale().getX();
            float worldHeight = spriteComponent.getHeight() * transform.getScale().getY();

            Vector2 center = Camera.worldToViewport(transform.getPosition());
            Vector2 dimensions = Camera.worldToViewport(worldWidth, worldHeight);
            System.out.println(center);
            System.out.println(dimensions);
            Vector2 topLeft = new Vector2(center.getX() - dimensions.getX()/2, center.getY() + dimensions.getY()/2);
            Vector2 bottomLeft = new Vector2(center.getX() - dimensions.getX()/2, center.getY() - dimensions.getY()/2);
            Vector2 topRight = new Vector2(center.getX() + dimensions.getX()/2, center.getY() + dimensions.getY()/2);
            Vector2 bottomRight = new Vector2(center.getX() + dimensions.getX()/2, center.getY() - dimensions.getY()/2);
            sprites[index++] = new Sprite(imageName, topLeft, bottomLeft, topRight, bottomRight,
                    spriteComponent.getRenderingLayer().sortingLayer, spriteComponent.getOrderInLayer());
        }

        Arrays.sort(sprites, new Comparator<Sprite>() {
            @Override
            public int compare(Sprite o1, Sprite o2) {
                if (o1.renderingLayer == o2.renderingLayer) {
                    if(o1.orderInLayer == o2.orderInLayer) {
                        return 0;
                    }
                    return o1.orderInLayer < o2.orderInLayer ? -1 : 1;
                }else {
                    return o1.renderingLayer < o2.renderingLayer ? -1 : 1;
                }
            }
        });
        renderingEngine.update(sprites);
    }


}
