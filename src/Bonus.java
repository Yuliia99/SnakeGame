package yuliia.SnakeGame;

import java.awt.image.ImageObserver;

public abstract class Bonus implements ImageObserver {
	int posX;
	int posY;

	public Bonus(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void setRandomPosition(Bonus firstBonus, Bonus secondBonus, Bonus thirdBonus, Bonus fourthBonus,
			Bonus fifthBonus) {
		posX = (int) (Math.random() * SnakeField.WIDTH);
		posY = (int) (Math.random() * SnakeField.HEIGHT);
		if (posX == firstBonus.posX || posX == secondBonus.posX || posX == thirdBonus.posX || posX == fourthBonus.posX
				|| posX == fifthBonus.posX)
			posX = (int) (Math.random() * SnakeField.WIDTH);
		if (posY == firstBonus.posY || posY == secondBonus.posY || posY == thirdBonus.posY || posY == fourthBonus.posY
				|| posY == fifthBonus.posY)
			posY = (int) (Math.random() * SnakeField.WIDTH);
	}
}
