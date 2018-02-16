package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class ToDoMenu extends Menu{

	public static int ID = -5;	
	
	public ToDoMenu(){
		super.setTitrePrincipal("Jeux non-fonctionnels");
		super.setTitreSecondaire("Fuyez pauvre fou !");
		
		super.setItems(/*AgeOfWar.World.GAME_NAME,*/"Retour");

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
		/*case 0:
			game.enterState(ToDoMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;*/
		case 0:
			game.enterState(MainMenu.ID, new FadeOutTransition(),new FadeInTransition());
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}