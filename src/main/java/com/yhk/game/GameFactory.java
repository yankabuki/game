package com.yhk.game;

import com.yhk.game.input.IGameInput;
import com.yhk.game.model.Game;
import com.yhk.game.model.GameQuestion;

public class GameFactory {

	public static Game newGame(IGameInput input) {
		Game game = new GameQuestion("massa", input);
		game.setYes(new GameQuestion("lasanha", game));
		game.setNo(new GameQuestion("bolo de chocolate", game));
		return game;
	}
}
