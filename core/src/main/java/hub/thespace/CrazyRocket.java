package hub.thespace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Main game class.
 */
public class CrazyRocket extends Game {

    OrthographicCamera camera;

    @Override
    public void create() {
        camera = new OrthographicCamera(16, 9);
        setScreen(new FirstScreen(this));
    }
}
