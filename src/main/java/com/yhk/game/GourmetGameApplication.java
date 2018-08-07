package com.yhk.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.yhk.game.input.SwingGameInput;
import com.yhk.game.model.Game;


public class GourmetGameApplication {
	
	public static void main(String[] args) {
		
		JFrame screen = new JFrame("Jogo Gourmet");
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setLayout(null);
		screen.setSize(300, 150);
		screen.setLocationRelativeTo(null);
		JLabel label = new JLabel("Pense em um prato que gosta");
		label.setBounds(50, 0, 200, 50);
		JButton button = new JButton("OK");
		button.setBounds(70, 50, 150, 50);
		
		Game game = GameFactory.newGame(new SwingGameInput(screen));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.question();
			}
		});
		screen.add(label);
		screen.add(button);
	}
}
