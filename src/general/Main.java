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
		System.setProperty("org.lwjgl.librarypath", new File("ressources/natives").getAbsolutePath());
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
		addState(new games.Worms3000.LevelEditor());
		addState(new games.Worms3000.menus.LoadLevelMenu());
		addState(new games.Worms3000.menus.LoadPlayerMenu());
		addState(new games.SpaceShooter.menus.NameMenu()); // Space Shooter
		addState(new games.CathedralBloxxx.MainMenuCbl()); // Cathedrale Bloxxx
		addState(new games.RogueLikeAVirgin.NameMenu()); // RogueLikeAVirgin
		addState(new games.AgeOfWar.World()); // AgeOfWar
		addState(new games.LaSainteVentouse.World()); // TetrisPolyBridge
		addState(new games.SpaceShooter.World()); 
		addState(new games.T7Laser.World()); //T7Laser
		addState(new games.CathedralBloxxx.World()); 
		addState(new games.Labyrinthe.World()); // Labyrinthe
		addState(new games.Snake.World()); // Snake
		addState(new games.TowerDefense.World()); // TowerDefense
		addState(new games.Worms3000.menus.WormMenu()); // Worms 3000
		addState(new games.Worms3000.World());
        addState(new games.Survival.worlds.CityWorld()); // Survival
		this.enterState(WelcomeMenu.ID);
	}
}
