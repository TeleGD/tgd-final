package games.RogueLikeAVirgin.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import games.RogueLikeAVirgin.World;
import games.RogueLikeAVirgin.entity.Entity;

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
