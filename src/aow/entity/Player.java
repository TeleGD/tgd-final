package aow.entity;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import aow.World;
import aow.entity.minions.Minion;
import aow.entity.minions.Sort;

public class Player {
	
	
	private int PV; //pts de vie de la base
	private int PVMax;
	private int gold;
	private int ID; //num joueur
	private int xp;
	private int xpMax = 3000;
	private int age = 1;
	private int boardLength = World.tailleBoard;
	private int temps = 0;
	private Image base1;
	private Image base2;
	private Music sadMusic;
	private Music goodMusic;
	private Music musicAge;
	
	//constructeur
	public Player(int num, int gold, int HP ) // init num joueur, or et pv 
	{
		ID=num;
		try {
			sadMusic=new Music("musics/aow/sadMusic.ogg");
			goodMusic = new Music("musics/aow/I_LIKE_TRAINS.ogg");

		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.gold=gold;
		PV=HP;
		PVMax=HP;
		try {
			base1=new Image("images/aow/base_1_a1.png");
			base2=new Image("images/aow/base_2_a1.png");
		} catch (SlickException e) {
			// nous donne la trace de l'erreur si on ne peut charger l'image correctement
			e.printStackTrace();
		}
	}
	
	public void takeDamage(int degat) {
		PV=PV-degat;
		if (PV<=0) {
			System.out.println("Défaite du joueur "+ID);
			World.etat = 1;
			sadMusic.loop();
//			System.exit(0);
		}
	}
	
	public int getHp()
	{
		return PV;
	}
	
	public int getId()
	{
		return ID;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void addGold(int toAdd) {
		gold += toAdd;
	}
	
	public boolean removeGold(int toRemove) // enleve toRemove a l or du joueur, retourne true si le joueur peut payer
	{
		if((gold-toRemove)<0 )return false;
		
		else
		{
			gold-=toRemove;
			return true;
		}
	}
	
	public void augmenteXp(int inc)
	{
		if (age < 3) {
			xp+=inc;
		}
	}
	
	private boolean removeXp(int toRemove) {
		if((xp-toRemove)<0 )return false;
		
		else
		{
			xp-=toRemove;
			return true;
		}
	}
	
	public void achatMinion(int type) {
		
		if (ID==1 && World.board.getCase(0)==0 ) { //Teste si case de spawn vide
			if (World.p1.removeGold(15*age*type)) { // teste si le joueur peut payer et l'encaisse si oui
				if (Math.random() > 0.95) {
					type += 3;
				}
				Minion m = new Minion(1, age, type);
				World.board.setMinionToCase(1,0);
				World.t1.removeRail(3); // Le joueur recrute, il perd des rails
			}
		} else if (ID==2 && World.board.getCase(boardLength-1) == 0) {
			if (World.p2.removeGold(15*age*type)) {
				if (Math.random() > 0.95) {
					type += 3;
				}
				Minion m = new Minion(2, age, type);
				World.board.setMinionToCase(2, boardLength -1);	
				World.t2.removeRail(3); // Le joueur recrute, il perd des rails
			}
		}
	}
	
	public void castSpell() {
	
		if (ID==1) { //Teste si case de spawn vide
			if (World.p1.removeXp(250*age)) { // teste si le joueur peut payer et l'encaisse si oui
				World.spells.add(new Sort(ID, age));
			}
		} else {
			if (World.p2.removeXp(250*age)) {
				World.spells.add(new Sort(ID, age));
			}
		}
	}
	

	public void update(GameContainer container,StateBasedGame game, int delta) throws SlickException
	{
		// update de age, xpMax, pv, pvmax ;
		if(xp>=xpMax && age < 3)
		{
			age++;
			xpMax=(int)(xpMax*3);
			PVMax=(int)(PVMax*1.25);
			PV=(int)(PV*1.25);
			base1=new Image("images/aow/base_1_a"+age+".png");
			base2=new Image("images/aow/base_2_a"+age+".png");
			
			// Gestion musique du fond sonore : vérifie qu'il est le premier à lancer cette musique, sinon ne fait rien
			if (needMusic()) {
				try {
					musicAge =new Music("musics/aow/age" + age + ".ogg");

				} catch (SlickException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				musicAge.loop();
			}	
		}
		
		temps ++;
		if (temps >= 90) {
			gold += 5;
			temps = 0;
		}
	}
	
	public void render(GameContainer container,StateBasedGame game, Graphics g) throws SlickException
	{
		if(ID==1)
		{
			g.drawImage(base1, 6, 250);
			
			g.setColor(new Color(153,0,0));
			g.fillRect(6, 229, 120, 18);
		
			g.setColor(new Color(255,0,0));
			g.fillRect(6, 229, (int)(120*(double)(PV)/PVMax), 18);
			
			g.setColor(Color.white);
			g.drawString(""+(int)(((double)(PV)/PVMax)*100)+" %", 8, 229);
			
			g.setColor(Color.yellow);
			g.drawString((int)(gold) + " gold", 8, 255);
			
			g.setColor(Color.magenta);
			g.drawString("Age : " + (int)(age), 8, 280);
			
			g.setColor(new Color(0,153,0));
			g.fillRect(6, 200, 120, 18);
		
			g.setColor(new Color(0,255,0));
			g.fillRect(6, 200, (int)(120*(double)(xp)/xpMax), 18);
			
			g.setColor(Color.white);
			g.drawString(""+(int)(((double)(xp)/xpMax)*100)+" %", 8, 200);
			
		}		
		else // joueur 2
		{
			g.drawImage(base2, 1151, 250);
			
			g.setColor(new Color(153,0,0));
			g.fillRect(1151, 229, 120, 18); //
			
			g.setColor(new Color(255,0,0));
			g.fillRect(1151, 229, (int)(120*(double)(PV)/PVMax), 18);
			
			g.setColor(Color.white);
			g.drawString(""+(int)(((double)(PV)/PVMax)*100)+" %", 1153, 229);
			
			g.setColor(Color.yellow);
			g.drawString((int)(gold) + " gold", 1153, 255);
			
			g.setColor(Color.magenta);
			g.drawString("Age : " + (int)(age), 1153, 280);
			
			g.setColor(new Color(0,153,0));
			g.fillRect(1151, 200, 120, 18);
		
			g.setColor(new Color(0,255,0));
			g.fillRect(1151, 200, (int)(120*(double)(xp)/xpMax), 18);
			
			g.setColor(Color.white);
			g.drawString(""+(int)(((double)(xp)/xpMax)*100)+" %", 1153, 200);
		}
	}
	
	private boolean needMusic() {
		if (ID ==1) {
			if (age > World.p2.getAge() ) {
				return true;
			}
		} else {
			if (age > World.p1.getAge() ) {
				return true;
			}
		}
		return false;
	}
	
	private boolean aPress,zPress,ePress,iPress,oPress,pPress,sPress,lPress = false;
	
	public void keyPressed(int key, char c) {
		switch (key){
		case Input.KEY_A:
			aPress = true;
			World.p1.achatMinion(1);
			break;
		case Input.KEY_Z:
			zPress = true;
			World.p1.achatMinion(2);
			break;
		case Input.KEY_E:
			ePress = true;
			World.p1.achatMinion(3);
			break;
		case Input.KEY_S:
			lPress = true;
			World.p1.castSpell();
			break;
		case Input.KEY_I:
			iPress = true;
			World.p2.achatMinion(1);
			break;
		case Input.KEY_O:
			oPress = true;
			World.p2.achatMinion(2);
			break;
		case Input.KEY_P:
			pPress = true;
			World.p2.achatMinion(3);
			break;
		case Input.KEY_L:
			lPress = true;
			World.p2.castSpell();
			break;
		}
	}
	
	public void keyReleased(int key, char c) {
		switch (key){
		case Input.KEY_A:
			aPress = false;
			break;
		case Input.KEY_Z:
			zPress = false;
			break;
		case Input.KEY_E:
			ePress = false;
			break;
		case Input.KEY_S:
			sPress = false;
			break;
		case Input.KEY_I:
			iPress = false;
			break;
		case Input.KEY_O:
			oPress = false;
			break;
		case Input.KEY_P:
			pPress = false;
			break;
		case Input.KEY_L:
			lPress = false;
			break;
		}
	}
	
}
