package yuliia.SnakeGame;

import java.awt.Image;
import java.awt.image.ImageObserver;

public class Snake implements ImageObserver {
	int[] X = new int[SnakeField.WIDTH * SnakeField.SCALE];
	int[] Y = new int[SnakeField.HEIGHT * SnakeField.SCALE];
	private int length = 3;
	private int direction = 0;
	private int countApples = 0;

	public Snake(int xStart, int yStart, int xEnd, int yEnd) {
		X[0] = xStart;
		Y[0] = yStart;
		X[1] = xEnd;
		Y[1] = yEnd;
	}

	public void move() {
		for (int i = length; i > 0; i--) {
			X[i] = X[i - 1];
			Y[i] = Y[i - 1];
		}

		if (getDirection() == 0) {
			X[0]++;
			SnakeField.apple.setRandomPosition(SnakeField.apple1, SnakeField.apple2, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
			SnakeField.spider.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
					SnakeField.spider1, SnakeField.diamond);
		}
		if (getDirection() == 1) {
			Y[0]++;
			SnakeField.apple1.setRandomPosition(SnakeField.apple, SnakeField.apple2, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
		}
		if (getDirection() == 2) {
			X[0]--;
			SnakeField.apple2.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
		}
		if (getDirection() == 3) {
			Y[0]--;
			SnakeField.spider1.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
					SnakeField.spider, SnakeField.diamond);
		}

		for (int i = 1; i < length; i++) {
			if ((X[0] == X[i]) && (Y[0] == Y[i]))
				length = i;
		}

		if (X[0] == SnakeField.WIDTH)
			X[0] = 0;
		if (Y[0] == SnakeField.HEIGHT)
			Y[0] = 0;
		if (X[0] < 0)
			X[0] = SnakeField.WIDTH - 1;
		if (Y[0] < 0)
			Y[0] = SnakeField.HEIGHT - 1;

		for (int i = 1; i < length; ++i) {
			if (X[i] == SnakeField.apple.posX && Y[i] == SnakeField.apple.posY)
				SnakeField.apple.setRandomPosition(SnakeField.apple1, SnakeField.apple2, SnakeField.spider,
						SnakeField.spider1, SnakeField.diamond);
			if (X[i] == SnakeField.apple1.posX && Y[i] == SnakeField.apple1.posY)
				SnakeField.apple1.setRandomPosition(SnakeField.apple, SnakeField.apple2, SnakeField.spider,
						SnakeField.spider1, SnakeField.diamond);
			if (X[i] == SnakeField.apple2.posX && Y[i] == SnakeField.apple2.posY)
				SnakeField.apple2.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.spider,
						SnakeField.spider1, SnakeField.diamond);

			if (X[i] == SnakeField.spider.posX && Y[i] == SnakeField.spider.posY)
				SnakeField.spider.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
						SnakeField.spider1, SnakeField.diamond);
			if (X[i] == SnakeField.spider1.posX && Y[i] == SnakeField.spider1.posY)
				SnakeField.spider1.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
						SnakeField.spider, SnakeField.diamond);
			if (X[i] == SnakeField.diamond.posX && Y[i] == SnakeField.diamond.posY)
				SnakeField.diamond.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
						SnakeField.spider, SnakeField.spider1);
		}

		if (length < 3) {
			EndGameWindow.main(new String[] {});
			SnakeField.frame.setVisible(false);
		}

		if (X[0] == SnakeField.apple.posX && Y[0] == SnakeField.apple.posY) {
			SnakeField.apple.setRandomPosition(SnakeField.apple1, SnakeField.apple2, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
			length += 2;
			setCountApples(getCountApples() + 1);

		}
		if (X[0] == SnakeField.apple1.posX && Y[0] == SnakeField.apple1.posY) {
			SnakeField.apple1.setRandomPosition(SnakeField.apple, SnakeField.apple2, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
			length += 2;
			setCountApples(getCountApples() + 1);

		}
		if (X[0] == SnakeField.apple2.posX && Y[0] == SnakeField.apple2.posY) {
			SnakeField.apple2.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.spider,
					SnakeField.spider1, SnakeField.diamond);
			length += 2;
			setCountApples(getCountApples() + 1);

		}

		if (X[0] == SnakeField.diamond.posX && Y[0] == SnakeField.diamond.posY) {
			length += 4;
		}
		if (X[0] == SnakeField.spider.posX && Y[0] == SnakeField.spider.posY) {
			SnakeField.spider.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
					SnakeField.spider1, SnakeField.diamond);
			length -= 1;
		}
		if (X[0] == SnakeField.spider1.posX && Y[0] == SnakeField.spider1.posY) {
			SnakeField.spider1.setRandomPosition(SnakeField.apple, SnakeField.apple1, SnakeField.apple2,
					SnakeField.spider, SnakeField.diamond);
			length -= 1;
		}

	}

	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		return false;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCountApples() {
		return countApples;
	}

	public void setCountApples(int countApples) {
		this.countApples = countApples;
	}

}
