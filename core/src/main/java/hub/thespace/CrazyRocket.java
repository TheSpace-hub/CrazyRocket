package hub.thespace;

import com.badlogic.gdx.Game;

/**
 * Main game class.
 */
public class CrazyRocket extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}
