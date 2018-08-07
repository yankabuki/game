package com.yhk.game.model;

public class GameCompleted extends Game {

	public GameCompleted(Game parent) {
		super(null, parent);
	}
	

	@Override
	public void question() {
		gameInput.showMessage("Acertei de novo!");
	}
}
