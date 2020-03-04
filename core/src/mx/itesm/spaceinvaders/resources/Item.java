package mx.itesm.spaceinvaders.resources;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Item {

    protected Sprite sprite;

    public Item(Texture texture, float x, float y){
        sprite = new Sprite(texture);
        sprite.setPosition(x, y);
    }

    public void render(SpriteBatch batch){
        sprite.draw(batch);
    }
}
