package games.LaSainteVentouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Cloud {
	private int posx;
	private int posy;
	private double speed;

	private Image cloud;
	private String urlCloud = "images/LaSainteVentouse/cloud.png";

	public Cloud() throws SlickException{
    	cloud = new Image(urlCloud);

    	posx = 0;
    	posy = (int) (50 + Math.random() * 250);
    	speed=0.075+Math.random()*0.275;
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		posx += delta*speed;
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(cloud,posx,posy);
	}

	public int getPosX(){
		return posx;
	}

	public int getPosy(){
		return posy;
	}
}
