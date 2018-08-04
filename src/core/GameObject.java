package core;

import core.components.Behaviour;
import core.components.SpriteComponent;
import core.components.Transform;

import java.util.Objects;

public class GameObject {

    private final String name;
    private final Scene scene;

    private final Transform transform;
    private final Behaviour behaviour;
    private final SpriteComponent spriteComponent;

    public GameObject(String name, Scene scene,
                      Transform transform, Behaviour behaviour, SpriteComponent spriteComponent) {
        this.name = name;
        this.scene = scene;
        this.transform = transform;
        this.behaviour = behaviour;
        this.spriteComponent = spriteComponent;
    }

    public Transform getTransform() {
        return transform;
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }

    public SpriteComponent getSpriteComponent() {
        return spriteComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
