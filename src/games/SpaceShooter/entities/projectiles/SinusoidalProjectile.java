package games.SpaceShooter.entities.projectiles;

import games.SpaceShooter.entities.characters.Player;

public class SinusoidalProjectile extends Projectile{

	public SinusoidalProjectile(double centerPointX, double centerPointY, int radius, Player player,boolean allied) {
		super(centerPointX, centerPointY, radius, player,allied);
	}

}
