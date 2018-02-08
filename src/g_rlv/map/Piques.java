package g_rlv.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import g_rlv.World;
import g_rlv.entity.Entity;

public class Piques extends Case {

	public Piques(int x, int y,int difficulte){
		super(x,y,difficulte);
		deplacementPossible=false;
		try {
			sprite = new Image(World.DIRECTORY_IMAGES+"pick"+getCouleur()+".png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void ArriveSur(Entity e) {
		//e prend des degats
	}
	
}
