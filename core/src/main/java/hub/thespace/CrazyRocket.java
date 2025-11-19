package hub.thespace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Main game class.
 */
public class CrazyRocket extends Game {

    FitViewport viewport;
    SpriteBatch batch;
    BitmapFont font;

    @Override
    public void create() {
        viewport = new FitViewport(16, 9);
        batch = new SpriteBatch();
        font = new BitmapFont();

        font.setUseIntegerPositions(false);
        font.getData().setScale(2 * viewport.getWorldHeight() / Gdx.graphics.getHeight());

        setScreen(new FirstScreen(this));
    }
}
