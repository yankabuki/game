package com.yhk.game.model;

import com.yhk.game.input.IGameInput;

public class GameQuestion extends Game {

	public GameQuestion(String response, IGameInput gameInput) {
		super(response, gameInput);
	}
	
	public GameQuestion(String response, Game parent) {
		super(response, parent);
		this.gameInput = parent.gameInput;
		this.setYes(new GameCompleted(this));
		this.setNo(new GameQuestionBuilder(this));
	}
	
	@Override
	public void question() {
		Integer response = gameInput.getYesNoAnswer(String.format("O prato que você pensou é %s?", requestedAttribute));
		pickChoice(response);
	}
}
 