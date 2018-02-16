package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class UnfinishedMenu extends Menu{

	public static int ID = -4;	
	
	public UnfinishedMenu(){
		super.setTitrePrincipal("Jeux buggues");
		super.setTitreSecondaire("A vos risques et périls");
		
		super.setItems(games.LaSainteVentouse.World.GAME_NAME,games.SpaceShooter.World.GAME_NAME,games.CathedralBloxxx.World.GAME_NAME,games.Labyrinthe.World.GAME_NAME,games.TowerDefense.World.GAME_NAME,games.Survival.worlds.CityWorld.GAME_NAME,games.Worms3000.World.GAME_NAME,"Retour");

		super.setEnableClignote(false);
		super.setCouleurClignote(Color.red);
		super.setTempsClignote(400);
	}
	
	@Override
	public void onOptionItemFocusedChanged(int position) {
		time=System.currentTimeMillis();
	}

	@Override
	public void onOptionItemSelected(int position) {
		switch (position) {
		case 0:
			game.enterState(games.LaSainteVentouse.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 1:
			game.enterState(games.SpaceShooter.menus.NameMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 2:
			game.enterState(games.CathedralBloxxx.MainMenuCbl.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 3:
			game.enterState(games.Labyrinthe.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 4:
			game.enterState(games.TowerDefense.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 5:
			game.enterState(games.Survival.worlds.CityWorld.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 6:
			game.enterState(games.Worms3000.menus.WormMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 7:
			game.enterState(MainMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}