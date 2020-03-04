package mx.itesm.spaceinvaders.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import mx.itesm.spaceinvaders.Game;

public class MenuScreen extends Pantalla {

    private final Game game;

    private Texture texturaFondo;

    private Stage menuStage;

    public MenuScreen(Game game){
        this.game = game;
    }


    @Override
    public void show() {
        texturaFondo = new Texture("moving-stars-background.jpg");
        createMenu();
    }

    private void createMenu() {
        menuStage = new Stage(vista);

        Texture playTexture = new Texture("button_jugar.png");
        TextureRegionDrawable playRegionDrawable = new TextureRegionDrawable(new TextureRegion(playTexture));

        Texture playTextureP = new Texture("button_jugarP.png");
        TextureRegionDrawable playRegionDrawableP = new TextureRegionDrawable(new TextureRegion(playTextureP));

        ImageButton playButton = new ImageButton(playRegionDrawable, playRegionDrawableP);
        playButton.setPosition(ANCHO/2-playButton.getWidth()/2, 2*ALTO/3);

        menuStage.addActor(playButton);

        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new SpaceInvaders(game));
            }
        });

        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void render(float delta) {
        borrarPantalla();
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        batch.draw(texturaFondo, 0, 0);
        batch.end();

        menuStage.draw();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texturaFondo.dispose();
    }
}
