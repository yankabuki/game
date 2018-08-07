package com.yhk.game.model;

import java.util.Arrays;

import com.yhk.game.input.IGameInput;

public abstract class Game {

	protected static final Integer YES = 0;
	protected static final Integer NO = 1;
	
	protected Game choices[] = new Game[2];
	 
	protected Game parent;
	protected String requestedAttribute;
	protected IGameInput gameInput;
	
	public Game(String requestedAttribute, Game parent) {
		this.requestedAttribute = requestedAttribute;
		this.parent = parent;
	}
	
	public Game(String requestedAttribute, IGameInput gameInput) {
		this.requestedAttribute = requestedAttribute;
		this.gameInput = gameInput;
	}
	
	protected void pickChoice(Integer choice) {
		choices[choice].question();
	}
	
	protected Integer getChoice(Game child) {
		return Arrays.asList(choices).indexOf(child);
	}
	
	public void setYes(Game yesNode) {
		yesNode.gameInput = gameInput;
		choices[YES] = yesNode;
	}
	
	public void setNo(Game noNode) {
		noNode.gameInput = gameInput;
		choices[NO] = noNode;
	}
	
	public abstract void question();
}
