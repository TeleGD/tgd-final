package general;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import menus.*;


public class Main extends StateBasedGame{
	
	public static int longueur=1280;
	public static int hauteur=720;
	
	public static void main(String[] args) throws SlickException {
		//Normalement c'est plus necessaire, c'est fait dans le setup du projet en theorie
		//Et pourtant quand je cree un runnable jar il le faut sinon le jar ne se lance pas...
		System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
		AppGameContainer app = new AppGameContainer(new Main(),longueur, hauteur, false);
		app.setTargetFrameRate(60);
		app.setVSync(true);
		app.setShowFPS(true);
		app.start();
	}
	

	public Main() {
		super("TGD");
	}



	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new WelcomeMenu());
		addState(new MainMenu());
		addState(new PlayMenu());
		addState(new UnfinishedMenu());
		addState(new ToDoMenu());
		addState(new ScoreMenu());
		addState(new HighScorePlayerMenu());
		addState(new sps.menus.NameMenu()); // Space Shooter
		addState(new cbl.MainMenuCbl()); // Cathedrale Bloxxx
		addState(new rlv.NameMenu()); // RogueLikeAVirgin
		addState(new aow.World()); // AgeOfWar
		addState(new tpb.World()); // TetrisPolyBridge
		addState(new sps.World()); 
		addState(new t7l.World()); //T7Laser
		addState(new cbl.World()); 
		addState(new lab.World()); // Labyrinthe
		this.enterState(WelcomeMenu.ID);
	}
}
