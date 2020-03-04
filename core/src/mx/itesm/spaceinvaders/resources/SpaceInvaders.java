package mx.itesm.spaceinvaders.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import mx.itesm.spaceinvaders.Game;

class SpaceInvaders extends Pantalla {

    private Game game;
    private final int COLUMNS = 11;
    private final int ROWS = 5;
    private Texture textureInvader;
    private Texture textureSpaceship;
    private Movement movement = Movement.IDLE;

    private Array<Invader> enemies;
    private Spaceship spaceship;


    public SpaceInvaders(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        loadTextures();
        createInvaders();
        createSpaceship();

        Gdx.input.setInputProcessor(new CustomInputProcessor());
    }

    private void createSpaceship() {
        spaceship = new Spaceship(textureSpaceship, ANCHO/2, 0);
    }

    private void loadTextures() {
        textureInvader = new Texture("space/enemigoArriba.png");
        textureSpaceship = new Texture("space/nave.png");
    }

    private void createInvaders() {
        enemies = new Array<>(55);
        float dx = ANCHO*0.8f/COLUMNS;
        float dy = ALTO*0.4f/ROWS ;
        for(int i = 0 ; i < COLUMNS ; i++){
            for(int j = 0 ; j < ROWS; j++){
                enemies.add(new Invader(textureInvader, (i*dx) + ANCHO*0.1f, (j*dy)+ ALTO*0.6f));
            }
        }
    }

    @Override
    public void render(float delta) {
        borrarPantalla(0, 0,0);
        moveSpaceShip();
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        for(Invader enemy: enemies){
            enemy.render(batch);
        }
        spaceship.render(batch);
        batch.end();
    }

    private void moveSpaceShip() {
        switch(movement){
            case IDLE:
                spaceship.move(0);
                break;
            case LEFT:
                spaceship.move(-5);
                break;
            case RIGHT:
                spaceship.move(5);
                break;
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    private class CustomInputProcessor implements InputProcessor {
        @Override
        public boolean keyDown(int keycode) {
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            Vector3 v = new Vector3(screenX, screenY, 0);
            camara.unproject(v);
            if(v.x>=ANCHO/2){
                movement = Movement.RIGHT;
            } else {
                movement = Movement.LEFT;
            }
            return true;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            movement = Movement.IDLE;
            return true;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            return false;
        }
    }

    public enum Movement{
        RIGHT,
        LEFT,
        IDLE
    }

}
