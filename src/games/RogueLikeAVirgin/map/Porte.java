package games.RogueLikeAVirgin.map;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import games.RogueLikeAVirgin.World;
import games.RogueLikeAVirgin.entity.Entity;
import games.RogueLikeAVirgin.entity.Item;
import games.RogueLikeAVirgin.entity.Player;

public class Porte extends Case {
	
	int rotation;

	public Porte(int x, int y,int difficulte) {
		super(x, y,difficulte);
		try {
			sprite = new Image(World.DIRECTORY_IMAGES+"door"+getCouleur()+".png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("porte " + getCouleur() + " x : " + x + "   y " + y);
	}
	
	@Override
	public void ArriveSur(Entity e) {
		if(e instanceof Player){ //genere new map
			
		}
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
		int pX = Math.round(World.player.getX()/36);
		int pY = Math.round(World.player.getY()/36);

		
		if(pY == this.y && pX == this.x){
			World.changeMap(Generation.genereNewSalle(niveau, y, x));
			World.player.setMap(World.map.getCases());
			World.score += niveau * niveau * 10;
			Random r = new Random();
			int prob = r.nextInt(3);
			if(prob == 0)
				new Item();
			
		if(pX == 0)
			pX = 18;
		else if(pX == 19)
			pX = 1;
		if(pY == 0)
			pY = 18;
		else if(pY == 19)
			pY = 1;
		
			
			World.player.setX(pX*36);
			World.player.setY(pY*36);
			World.player.getHitbox().setX(pX*36+4);
			World.player.getHitbox().setY(pY*36+4);
		}
	}
	
}
