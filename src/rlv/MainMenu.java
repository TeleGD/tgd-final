package rlv;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import rlv.World;
import menus.Menu;




public class MainMenu extends Menu{

	public static int ID = -12;	
	
	public MainMenu(){
		super.setTitrePrincipal("Rogue Like A Virgin");
		super.setTitreSecondaire("Main Menu");
		super.setItems("Play","Scores (à débugguer)","Credits", "Quit");
		super.setEnableClignote(false);
		super.setCouleurClignote(Color.red);
		super.setTempsClignote(400);
	}
	
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	}
	
	@Override
	public void onOptionItemFocusedChanged(int position) {
		time=System.currentTimeMillis();
	}

	@Override
	public void onOptionItemSelected(int position) {
		switch (position) {
		case 0:
			World.reset();
			game.enterState(rlv.World.ID, new FadeOutTransition(),
					new FadeInTransition());
			//background.stop();
			break;
		/* case 1:
			//Score board
			game.enterState(rlv.ScoreMenu.ID, new FadeOutTransition(),
					new FadeInTransition());
			break; */
		case 2:
			game.enterState(rlv.CreditsMenu.ID, new FadeOutTransition(),
					new FadeInTransition());
			break;
		case 3:
			game.enterState(menus.MainMenu.ID, new FadeOutTransition(),
					new FadeInTransition());
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}
