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
		addState(new g_wrm.LevelEditor());
		addState(new g_wrm.menus.LoadLevelMenu());
		addState(new g_wrm.menus.LoadPlayerMenu());
		addState(new g_sps.menus.NameMenu()); // Space Shooter
		addState(new g_cbl.MainMenuCbl()); // Cathedrale Bloxxx
		addState(new g_rlv.NameMenu()); // RogueLikeAVirgin
		addState(new g_aow.World()); // AgeOfWar
		addState(new g_tpb.World()); // TetrisPolyBridge
		addState(new g_sps.World()); 
		addState(new g_t7l.World()); //T7Laser
		addState(new g_cbl.World()); 
		addState(new g_lab.World()); // Labyrinthe
		addState(new g_snk.World()); // Snake
		addState(new g_twd.World()); // TowerDefense
		addState(new g_wrm.menus.WormMenu()); // Worms 3000
		addState(new g_wrm.World());
        addState(new g_srv.worlds.CityWorld()); // Survival
		this.enterState(WelcomeMenu.ID);
	}
}
