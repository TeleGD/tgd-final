package g_rlv.entity.enemies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Enemy2 extends Enemy1{

	public Enemy2(float x, float y) {
		super(x, y);
		this.hp=3;
		try {
			this.imgB=new Image("images/rlv/blobRoseBas.png");
			this.imgT=new Image("images/rlv/blobRoseHaut.png");
			this.imgR=new Image("images/rlv/blobRoseDroite.png");
			this.imgL=new Image("images/rlv/blobRoseGauche.png");
			
			this.sprite=imgB;
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.width=36;
		this.height=36;
		zoning();
		this.hitbox=new Rectangle (x+4,y+4,width-8,height-8);
		speed=0.1;
	}

}