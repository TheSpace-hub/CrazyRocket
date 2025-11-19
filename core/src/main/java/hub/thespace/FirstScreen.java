package hub.thespace;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import hub.thespace.sprites.Rocket;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen implements Screen {

    final CrazyRocket game;
    Texture background;

    Rocket rocket;

    public FirstScreen(CrazyRocket game) {
        this.game = game;
        background = new Texture("background.jpg");
        rocket = new Rocket();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.CLEAR);

        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
        game.batch.begin();

        game.batch.draw(background, 0, 0, 16, 9);
        rocket.getSprite().draw(game.batch);

        game.font.draw(game.batch, "Click on the ROCKET!", 0, 4.5f, game.viewport.getWorldWidth(), Align.center, false);

        game.batch.end();

        logic(delta);
    }

    /**
     * Main logic function.
     *
     * @param delta Delta time.
     */
    void logic(float delta) {
        rocket.logic(delta);
    }

    @Override
    public void show() {
        // Prepare your screen here.
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
    }
}
