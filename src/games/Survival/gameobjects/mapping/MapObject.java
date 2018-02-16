package games.Survival.gameobjects.mapping;

import org.newdawn.slick.Image;

import games.Survival.gameobjects.GameObject;
import games.Survival.utils.Vector2;

public class MapObject extends GameObject{
	
	public MapObject(Image spr, Vector2 loc)
	{
		this(spr,loc,true);
	}
	
	public MapObject(Image spr, Vector2 loc, boolean collisions)
	{
		super(spr);
		if(collisions == false)
			boundingBox = null;
		location = loc;
		sprite = spr;
	}	
}
