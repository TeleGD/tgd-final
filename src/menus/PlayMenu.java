package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class PlayMenu extends Menu{

	public static int ID = -3;	
	
	public PlayMenu(){
		super.setTitrePrincipal("Jeux fonctionnels");
		super.setTitreSecondaire("Vous pouvez jouer");
		
		super.setItems(g_aow.World.GAME_NAME,g_t7l.World.GAME_NAME,g_rlv.World.GAME_NAME,"Retour");

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
			game.enterState(g_aow.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 1:
			game.enterState(g_t7l.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 2:
			game.enterState(g_rlv.NameMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 3:
			game.enterState(MainMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}