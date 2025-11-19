package hub.thespace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Main game class.
 */
public class CrazyRocket extends Game {

    FitViewport viewport;
    SpriteBatch batch;

    @Override
    public void create() {
        viewport = new FitViewport(16, 9);
        batch = new SpriteBatch();
        setScreen(new FirstScreen(this));
    }
}
