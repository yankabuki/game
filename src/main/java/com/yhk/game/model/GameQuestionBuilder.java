package com.yhk.game.model;

public class GameQuestionBuilder extends Game {

	public GameQuestionBuilder(Game parent) {
		super(null, parent);
	}
	
	@Override
	public void question() {
		
		String dish = gameInput.getTextAnswer("Qual prato voce pensa?");
		String attribute = gameInput.getTextAnswer(String.format("%s e ____ mas %s nao.", dish, parent.requestedAttribute));
		
		Game newResponse = new GameQuestion(attribute, this);
		newResponse.setYes(new GameQuestion(dish, newResponse));
		newResponse.setNo(parent);
		
		Game oldParent = parent.parent;
		oldParent.choices[oldParent.getChoice(parent)] = newResponse;
		parent.parent = newResponse;
	}
}
