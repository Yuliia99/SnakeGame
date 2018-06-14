package yuliia.SnakeGame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class EndGameWindow extends JFrame {
	static JLabel lEndGame = new JLabel("<html><span style='font-size:20px;color:green;'>"
			+ "Game is over!\nSnake is too small:(" + "</span></html>");
	static JFrame frame = new JFrame();

	public static void main(String[] args) {

		frame.add(lEndGame);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}
