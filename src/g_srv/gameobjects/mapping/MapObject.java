package g_srv.gameobjects.mapping;

import org.newdawn.slick.Image;

import g_srv.gameobjects.GameObject;
import g_srv.utils.Vector2;

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
