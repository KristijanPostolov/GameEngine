package core.components;

import math.Vector2;

public class Transform extends Component {

    private final Vector2 position;
    private final Vector2 scale;

    public Transform() {
        position = new Vector2(0, 0);
        scale = new Vector2(1, 1);
    }

    public Transform(Vector2 position, Vector2 scale) {
        this.position = position;
        this.scale = scale;
    }

    @Override
    public void init() { }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getScale() {
        return scale;
    }
}
