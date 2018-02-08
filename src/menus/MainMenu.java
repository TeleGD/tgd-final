package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class MainMenu extends Menu{

	public static int ID = -2;	
	
	public MainMenu(){
		super.setTitrePrincipal("Jeux de TGD");
		super.setTitreSecondaire("Tout n'est pas fini mais ça arrive :)");
		
		super.setItems("Jeux finis (ou à équilibrer)","A finir mais jouables","Non jouables (mais presque)","Scores","Quitter");

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
			game.enterState(PlayMenu.ID, new FadeOutTransition(), new FadeInTransition());
			break;
		case 1:
			game.enterState(UnfinishedMenu.ID, new FadeOutTransition(), new FadeInTransition());
			break;
		case 2:
			game.enterState(ToDoMenu.ID, new FadeOutTransition(), new FadeInTransition());
			break;
		case 3:
			game.enterState(ScoreMenu.ID, new FadeOutTransition(), new FadeInTransition());
			break;
		case 4:
			System.out.println("exit");
			System.exit(0);
			break;
		}
	}
	
	@Override
	public int getID() {
		return ID;
	}

}