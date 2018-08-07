package com.yhk.game.input;

import java.awt.Component;

import javax.swing.JOptionPane;

public class SwingGameInput implements IGameInput {

	private Component rootComponent;
	
	public SwingGameInput(Component rootComponent) {
		this.rootComponent = rootComponent;
	}
	
	@Override
	public Integer getYesNoAnswer(String message) {
		return  JOptionPane.showConfirmDialog(rootComponent, message, "Gourmet Game", JOptionPane.YES_NO_OPTION);
	}

	@Override
	public String getTextAnswer(String message) {
		return JOptionPane.showInputDialog(rootComponent, message);
	}

	@Override
	public void showMessage(String message) {
		 JOptionPane.showMessageDialog(rootComponent, message);
	}

}
