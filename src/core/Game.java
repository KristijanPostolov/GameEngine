package core;

import core.components.SpriteComponent;
import core.components.Transform;
import core.rendering.*;
import math.Vector2;

public class Game {

    /*public static void main(String[] args) {
        RenderSystem renderSystem = new RenderSystem(new RenderingEngine() {
            @Override
            public void update(Sprite[] sprites) {
                System.out.println("Render mwahahahaaa");
            }
        });

        Scene scene = getLevel();
        renderSystem.render(scene.getSpriteComponents());
    }*/

    public static Scene getLevel() {
        ViewBounds world = new ViewBounds(-10, 10, -5, 5);
        ViewBounds viewport = new ViewBounds(-5, 5, -10, 10);
        Camera.setup(world, viewport);
        Scene scene = new Scene("Level 1");
        GameObjectBuilder builder = new GameObjectBuilder()
                .setTransform(new Transform(new Vector2(-9, -0.5f), new Vector2(2, 0.5f)))
                .setSpriteComponent(new SpriteComponent("C:\\Users\\user\\Desktop\\image.jpg"));
        scene.createGameObject("Object", builder);
        return scene;
    }

}
