import core.GameObjectBuilder;
import core.GameObjectConfigurer;
import core.components.Behaviour;
import core.components.Transform;

public class Kici extends Behaviour implements GameObjectConfigurer {

    @Override
    public GameObjectBuilder configureBuilder() {
        return new GameObjectBuilder()
                .setTransform(new Transform())
                .setBehaviour(this);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void delete() {
        super.delete();
    }
}
