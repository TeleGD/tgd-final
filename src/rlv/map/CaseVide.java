package rlv.map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import rlv.World;

public class CaseVide extends Case{
	public CaseVide(int x,int y,int difficulte){
		super(x,y,difficulte);
		try {
			sprite = new Image(World.DIRECTORY_IMAGES+"floor"+getCouleur()+".png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
