package core.components;

import core.GameObject;

public abstract class Component {

    public GameObject gameObject;

    public final void attachTo(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public abstract void init();

}
