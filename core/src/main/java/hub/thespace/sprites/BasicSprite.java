package hub.thespace.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class BasicSprite {

    final Texture texture;
    final Sprite sprite;

    public BasicSprite(Texture texture, Sprite sprite) {
        this.texture = texture;
        this.sprite = sprite;
    }

    /**
     * The function is called every frame.
     *
     * @param delta Delta time.
     */
    abstract void logic(float delta);

    public Texture getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
