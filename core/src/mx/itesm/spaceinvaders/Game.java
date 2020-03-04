package mx.itesm.spaceinvaders;

import mx.itesm.spaceinvaders.resources.MenuScreen;

public class Game extends com.badlogic.gdx.Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
