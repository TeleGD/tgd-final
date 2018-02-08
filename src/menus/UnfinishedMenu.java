package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class UnfinishedMenu extends Menu{

	public static int ID = -4;	
	
	public UnfinishedMenu(){
		super.setTitrePrincipal("Jeux buggues");
		super.setTitreSecondaire("A vos risques et périls");
		
		super.setItems(tpb.World.GAME_NAME,sps.World.GAME_NAME,cbl.World.GAME_NAME,lab.World.GAME_NAME,"Retour");

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
			game.enterState(tpb.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 1:
			game.enterState(sps.menus.NameMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 2:
			game.enterState(cbl.MainMenuCbl.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 3:
			game.enterState(lab.World.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		case 4:
			game.enterState(MainMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}