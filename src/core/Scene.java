package core;

import core.components.SpriteComponent;
import core.components.Transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scene {

    private final String name;
    private final Map<String, GameObject> gameObjects = new HashMap<>();

    private List<Transform> transforms = new ArrayList<>();
    private List<SpriteComponent> spriteComponents = new ArrayList<>();

    public Scene(String name) {
        this.name = name;
    }

    public GameObject createGameObject(String name, GameObjectConfigurer configurer) {
        return createGameObject(name, configurer.configureBuilder());
    }

    public GameObject createGameObject(String name, GameObjectBuilder gameObjectBuilder) {
        if(gameObjects.containsKey(name)) {
            throw new IllegalStateException("A GameObject with the given name already exists in this scene");
        }

        GameObject gameObject = gameObjectBuilder
                .setName(name)
                .setScene(this)
                .build();

        gameObjects.put(name, gameObject);
        initializeComponents(gameObject);
        return gameObject;
    }

    private void initializeComponents(GameObject gameObject) {
        Transform transform = gameObject.getTransform();
        if(transform != null) {
            transform.init();
            transforms.add(transform);
        }

        SpriteComponent spriteComponent = gameObject.getSpriteComponent();
        if(spriteComponent != null) {
            spriteComponent.init();
            spriteComponents.add(spriteComponent);
        }
    }

    public List<SpriteComponent> getSpriteComponents() {
        return spriteComponents;
    }
}
