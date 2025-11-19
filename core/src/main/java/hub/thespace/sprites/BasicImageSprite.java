package hub.thespace.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class BasicImageSprite {

    final Texture texture;
    final Sprite sprite;

    public BasicImageSprite(String internalPath) {
        this.texture = new Texture(internalPath);
        this.sprite = new Sprite(texture);
    }

    /**
     * The function is called every frame.
     *
     * @param delta Delta time.
     */
    abstract public void logic(float delta);

    public Texture getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
