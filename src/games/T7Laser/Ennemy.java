package games.T7Laser;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Ennemy {
	private int x = 0;
	private int y = 0;

	private Image image;

	int moveTimer = 100;

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public Ennemy(int x, int y){
		try{
			image = new Image(World.DIRECTORY_IMAGES+"nyan.png");
		}catch(Exception e){}
		this.x = x;
		this.y = y;

		World.getGrid().getCell(x, y).setDeadly(true);
	}



	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		//Affichage
		image.draw(280+(x*100*World.getRenderScale())+360-World.getGrid().getColumns()*100*World.getRenderScale()/2,y*100*World.getRenderScale()+360-World.getGrid().getColumns()*100*World.getRenderScale()/2,100*World.getRenderScale(),100*World.getRenderScale());

	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		moveTimer--;
		Player p = World.getPlayer();
		int newX = x;
		int newY = y;
		if(moveTimer <= 0){
			if(x > p.getX())
				newX = x-1;
			if(x < p.getX())
				newX = x+1;
			if(y > p.getY())
				newY = y-1;
			if(y < p.getY())
				newY = y+1;

			if(World.getGrid().MoveEnnemy(newX, newY, this)){
				//move
				x = newX;
				y = newY;
			}


			moveTimer=50;
		}
	}
}
