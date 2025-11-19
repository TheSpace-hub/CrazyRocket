package hub.thespace.sprites;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * A rocket class.
 */
public class Rocket extends BasicImageSprite {

    Vector2 velocity;
    Vector2 accelerationLeft;
    Vector2 accelerationRight;
    Vector2 accelerationStop;
    boolean fly;

    public Rocket() {
        super("rocket.png");
        fly = true;

        velocity = new Vector2(MathUtils.random(-8, 8), MathUtils.random(-8, 8));
        accelerationLeft = new Vector2();
        accelerationRight = new Vector2();
        accelerationStop = new Vector2();

        sprite.setPosition(MathUtils.random(1, 15), MathUtils.random(1, 8));
        sprite.setSize(0.5f, 5482f / 2716f / 2f);
        sprite.setOriginCenter();
    }

    /**
     * Function move the rocket.
     *
     * @param delta Delta time.
     */
    @Override
    public void logic(float delta) {

        if (fly) {
            accelerationLeft = new Vector2(
                4f - (sprite.getX() + sprite.getWidth() / 2f),
                4.5f - (sprite.getY() + sprite.getWidth() / 2f)
            ).nor();
            accelerationRight = new Vector2(
                12f - (sprite.getX() + sprite.getWidth() / 2f),
                4.5f - (sprite.getY() + sprite.getWidth() / 2f)
            ).nor();

            velocity.add(accelerationLeft.scl(delta * 10f));
            velocity.add(accelerationRight.scl(delta * 10f));
        } else {
            accelerationStop = new Vector2();
            if (velocity.len() > .1f)
                accelerationStop = velocity.cpy().scl(-1).nor();

            velocity.add(accelerationStop.scl(delta * 10f));

        }

        sprite.translate(velocity.x * delta, velocity.y * delta);
        sprite.setRotation(velocity.angleDeg() - 90);

        if (sprite.getX() < 0 || sprite.getX() + sprite.getWidth() > 16)
            velocity = new Vector2(-velocity.x / 2, velocity.y);
        if (sprite.getY() < 0 || sprite.getY() + sprite.getHeight() > 9)
            velocity = new Vector2(velocity.x, -velocity.y / 2);
    }

    /**
     * Stop the rocket flying.
     */
    public void stopFlying() {
        fly = false;
    }
}
