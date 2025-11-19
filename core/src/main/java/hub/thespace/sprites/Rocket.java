package hub.thespace.sprites;

import com.badlogic.gdx.math.Vector2;

public class Rocket extends BasicImageSprite {

    Vector2 velocity;
    Vector2 acceleration;

    public Rocket() {
        super("rocket.png");

        velocity = new Vector2(1, 0);
        acceleration = new Vector2();

        sprite.setSize(0.5f, 5482f / 2716f / 2f);
    }

    @Override
    public void logic(float delta) {
        sprite.translate(velocity.x * delta * 2.5f, velocity.y * delta * 2.5f);
    }
}
