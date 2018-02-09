package g_srv.gameobjects.items;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import g_srv.gameobjects.GameObject;
import g_srv.gameobjects.gameplay.Player;
import g_srv.utils.Vector2;
import g_srv.worlds.World;

public abstract class Items extends GameObject {
	
	protected String name;
	private boolean onGround;
	
	public Items(Vector2 location,Image sprite) {
		super(sprite);
		//this.sprite = sprite;
		this.onGround = true;
		this.location = location;
	}
	
	public abstract void action();
	
	public boolean getOnGround() {
		return this.onGround;
	}
	
	public void pick() {
		if(onGround){
		this.onGround=false;
		World.activePlayer.addItem(this);
		destroy(this);
		}
		// objet rammassé par joueur --> inventaire		
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException
	{
		if(onGround && isCollidingWithSomething())
		{
			if(this.collisionOn.equals(World.activePlayer))
			{
				//System.out.println("entre");
				pick();
				collisionOn = null;
			}
		}
	}
	
	
}
