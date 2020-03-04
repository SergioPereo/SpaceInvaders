package mx.itesm.spaceinvaders.resources;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Spaceship extends Item {
    public Spaceship(Texture texture, float x, float y) {
        super(texture, x, y);
        sprite.setColor(Color.BLUE);
    }

    public void move(float dx){
        sprite.setX(sprite.getX()+dx);
    }
}
