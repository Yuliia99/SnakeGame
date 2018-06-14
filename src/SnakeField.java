package yuliia.SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SnakeField extends JPanel implements ActionListener {
	public static final int SCALE = 35;
	public static final int WIDTH = 25;
	public static final int HEIGHT = 25;
	public static int SPEED = 2;
	Snake snake = new Snake(5, 10, 4, 10);
	Timer timer = new Timer(1000 / SPEED, this);
	static Bonus apple = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	static Bonus apple1 = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	static Bonus apple2 = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	static Bonus diamond = new Diamond((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	static Bonus spider = new Spider((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	static Bonus spider1 = new Spider((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
	Image imgApple = new ImageIcon("images/apple.png").getImage();
	Image imgDiamond = new ImageIcon("images/diamond.png").getImage();
	Image imgSpider = new ImageIcon("images/spider.jpg").getImage();
	Image imgSnakeHead = new ImageIcon("images/snakeHead.png").getImage();
	Image imgSnake = new ImageIcon("images/snake.png").getImage();

	public SnakeField() {
		timer.start();
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (snake.getDirection() != 2 && e.getKeyCode() == KeyEvent.VK_RIGHT) {
					snake.setDirection(0);
				}
				if (snake.getDirection() != 3 && e.getKeyCode() == KeyEvent.VK_DOWN) {
					snake.setDirection(1);
				}
				if (snake.getDirection() != 0 && e.getKeyCode() == KeyEvent.VK_LEFT) {
					snake.setDirection(2);
				}
				if (snake.getDirection() != 1 && e.getKeyCode() == KeyEvent.VK_UP) {
					snake.setDirection(3);
				}
			}
		});
		setFocusable(true);

	}

	public void paint(Graphics g) {

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		g.setColor(new Color(255, 255, 0));
		for (int i = 0; i < WIDTH * SCALE; i += SCALE)
			g.drawLine(i, 0, i, HEIGHT * SCALE);
		g.setColor(new Color(255, 255, 0));
		for (int j = 0; j < HEIGHT * SCALE; j += SCALE)
			g.drawLine(0, j, WIDTH * SCALE, j);

		g.drawImage(imgSnakeHead, snake.X[0] * SCALE, snake.Y[0] * SCALE, snake);

		for (int k = 1; k < snake.getLength(); ++k) {
			g.drawImage(imgSnake, snake.X[k] * SCALE, snake.Y[k] * SCALE, snake);
		}

		g.drawImage(imgApple, apple.posX * SCALE, apple.posY * SCALE, apple);
		g.drawImage(imgApple, apple1.posX * SCALE, apple1.posY * SCALE, apple1);
		g.drawImage(imgApple, apple2.posX * SCALE, apple2.posY * SCALE, apple2);
		if (snake.getCountApples() != 0 && snake.getCountApples() % 4 == 0) {
			g.drawImage(imgDiamond, diamond.posX * SCALE, diamond.posY * SCALE, diamond);
			if (snake.X[0] == diamond.posX && snake.Y[0] == diamond.posY) {
				g.setColor(new Color(0, 0, 0));
				g.fillRect(diamond.posX * SCALE, diamond.posY * SCALE, SCALE, SCALE);
				snake.setCountApples(0);
			}
		}
		g.drawImage(imgSpider, spider.posX * SCALE, spider.posY * SCALE, spider);
		g.drawImage(imgSpider, spider1.posX * SCALE, spider1.posY * SCALE, spider1);

	}

	static JFrame frame = new JFrame("Snake");

	public static void main(String[] args) {

		frame.add(new SnakeField());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH * SCALE + 6, HEIGHT * SCALE + 40);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		snake.move();
		repaint();

	}

}
