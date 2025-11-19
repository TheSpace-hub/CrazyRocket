package hub.thespace.sprites;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Rocket extends BasicImageSprite {

    Vector2 velocity;
    Vector2 acceleration;

    public Rocket() {
        super("rocket.png");

        velocity = new Vector2(MathUtils.random(3, 8), MathUtils.random(3, 8));
        acceleration = new Vector2();

        sprite.setPosition(MathUtils.random(1, 15), MathUtils.random(1, 8));
        sprite.setSize(0.5f, 5482f / 2716f / 2f);
        sprite.setOriginCenter();
    }

    @Override
    public void logic(float delta) {
        acceleration = new Vector2(
            8f - (sprite.getX() + sprite.getWidth() / 2f),
            4.5f - (sprite.getY() + sprite.getWidth() / 2f)
        ).nor();
        velocity.add(acceleration.scl(delta * 10f));

        sprite.translate(velocity.x * delta, velocity.y * delta);
        sprite.setRotation(velocity.angleDeg() - 90);
    }
}
