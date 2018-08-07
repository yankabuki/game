package com.yhk.game;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.yhk.game.input.IGameInput;
import com.yhk.game.model.Game;

@RunWith(MockitoJUnitRunner.class)
public class GameQuestionTest {

	private static final Integer YES = 0;
	private static final Integer NO = 1;
	
	@Mock
	private IGameInput gameInputMock;
	
	@Test
	public void gameMustFinishIfAllAnswersCorrect() {
		Game game = GameFactory.newGame(gameInputMock);
		when(gameInputMock.getYesNoAnswer(anyString())).thenReturn(YES, YES);
		game.question();
		verify(gameInputMock).getYesNoAnswer(contains("massa"));
		verify(gameInputMock).getYesNoAnswer(contains("lasanha"));
		verify(gameInputMock, times(1)).showMessage(contains("Acertei de novo!"));
	}
	
	@Test
	public void gameMustUpdateNewAnswer() {
		Game game = GameFactory.newGame(gameInputMock);
		when(gameInputMock.getYesNoAnswer(anyString())).thenReturn(YES, NO);
		when(gameInputMock.getTextAnswer(anyString())).thenReturn("pastel", "frito");
		game.question();
		verify(gameInputMock).getYesNoAnswer(contains("massa"));
		verify(gameInputMock).getYesNoAnswer(contains("lasanha"));
		verify(gameInputMock).getTextAnswer(contains("Qual prato você pensa?"));
		verify(gameInputMock).getTextAnswer(contains("pastel é ____ mas lasanha não."));
	}
	
	@Test
	public void gameMustValidateNewAnswer() {
		Game game = GameFactory.newGame(gameInputMock);
		when(gameInputMock.getYesNoAnswer(anyString())).thenReturn(YES, NO, YES, NO, YES);
		when(gameInputMock.getTextAnswer(anyString())).thenReturn("pastel", "frito");
		game.question();
		game.question();
		verify(gameInputMock, times(1)).showMessage(contains("Acertei de novo!"));
	}
}
