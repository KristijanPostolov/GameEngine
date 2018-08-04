package core;

import core.components.*;

public class GameObjectBuilder {

    private String name;
    private Scene scene;
    private Transform transform;
    private Behaviour behaviour;
    private SpriteComponent spriteComponent;

    public GameObjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GameObjectBuilder setScene(Scene scene) {
        this.scene = scene;
        return this;
    }

    public GameObjectBuilder setTransform(Transform transform) {
        this.transform = transform;
        return this;
    }

    public GameObjectBuilder setBehaviour(Behaviour behaviour) {
        this.behaviour = behaviour;
        return this;
    }

    public GameObjectBuilder setSpriteComponent(SpriteComponent spriteComponent) {
        this.spriteComponent = spriteComponent;
        return this;
    }

    public GameObject build() {
        GameObject gameObject = new GameObject(name, scene, transform, behaviour, spriteComponent);
        tryAttach(transform, gameObject);
        tryAttach(behaviour, gameObject);
        tryAttach(spriteComponent, gameObject);
        return gameObject;
    }

    public void tryAttach(Component component, GameObject gameObject) {
        if(component != null) {
            component.attachTo(gameObject);
        }
    }

}
