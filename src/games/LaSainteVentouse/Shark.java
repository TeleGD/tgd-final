package games.LaSainteVentouse;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Shark {
	private int posx;
	private int posy;
	private int sens;
	private double speed;

	private Image shark;
	private Image shark1;
	private Image shark2;
	private String urlShark1 = "images/LaSainteVentouse/requin1.png";
	private String urlShark2 = "images/LaSainteVentouse/requin2.png";

	public Shark(int x, int dir) throws SlickException{
		posx = x;
		posy = 652-32;
		sens = dir;
		speed = 0.05+Math.random()*0.2;

		shark1 = new Image(urlShark1);
		shark2 = new Image(urlShark2);

		if(dir == 1){
			shark = shark1;
		}else{
			shark = shark2;
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if(sens == 1){
			posx += delta*speed;
			if(posx>980-32){
				sens = 1 - sens;
				shark = shark2;
			}
		}else{
			posx -= delta*speed;
			if(posx < 100){
				sens = 1 - sens;
				shark = shark1;
			}
		}
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(shark,posx,posy);
	}

	public int getPosX(){
		return posx;
	}

	public int getPosy(){
		return posy;
	}
}
