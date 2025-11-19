package hub.thespace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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

    Vector2 touchPos;

    public FirstScreen(CrazyRocket game) {
        this.game = game;
        background = new Texture("background.jpg");
        touchPos = new Vector2();
        rocket = new Rocket();
    }

    @Override
    public void render(float delta) {
        draw();
        logic(delta);
        input();
    }

    /**
     * Function draw everything.
     */
    void draw() {
        ScreenUtils.clear(Color.CLEAR);

        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
        game.batch.begin();

        game.batch.draw(background, 0, 0, 16, 9);
        rocket.getSprite().draw(game.batch);

        game.font.draw(game.batch, "Click on the ROCKET to START!", 0, 4.5f, game.viewport.getWorldWidth(), Align.center, false);

        game.batch.end();
    }

    /**
     * Main logic function.
     *
     * @param delta Delta time.
     */
    void logic(float delta) {
        rocket.logic(delta);
    }

    /**
     * The function reads the input data.
     */
    void input() {
        if (Gdx.input.isTouched()) {
            Rectangle rocketRectangle = new Rectangle(
                rocket.getSprite().getX(), rocket.getSprite().getY(),
                rocket.getSprite().getWidth(), rocket.getSprite().getHeight());
            touchPos.set(Gdx.input.getX(), Gdx.input.getY());
            game.viewport.unproject(touchPos);
            if (rocketRectangle.contains(touchPos)) {
                System.exit(0);
            }
        }
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
