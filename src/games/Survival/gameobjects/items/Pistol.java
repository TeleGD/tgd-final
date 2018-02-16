package games.Survival.gameobjects.items;

import org.newdawn.slick.Image;

import games.Survival.gameobjects.gameplay.Player;
import games.Survival.utils.Vector2;

public class Pistol extends Items {
	
	private Player player;
	private float damage;
	private float range;
	private int ammo;
	
	public Pistol(Vector2 location, float damage, float range, int ammo,Image sprite) {
		super(location,sprite);
		this.damage = damage;
		this.range = range;
		this.ammo = ammo;
	}
	
	@Override
	public void action() {
		// Tir à distance
	}
	
}
