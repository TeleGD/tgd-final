package g_srv.gameobjects.items;

import org.newdawn.slick.Image;

import g_srv.gameobjects.gameplay.Compteur;
import g_srv.gameobjects.gameplay.Player;
import g_srv.gameobjects.gameplay.TestObject;
import g_srv.utils.Vector2;
import g_srv.worlds.World;

public class Food extends Items {
	
	public float amount;
	
	public Food (Vector2 location, String name,float amount,Image sprite)
	{
		super(location,sprite);
		this.name = name;
		this.amount = amount;
	}
	
	//the action that made the item
	public void action()
	{
		World.activePlayer.hunger.canAdd(amount);
		World.activePlayer.removeItem(this);
	}

	


}
