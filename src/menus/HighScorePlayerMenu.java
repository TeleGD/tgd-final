package menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import api.APIListener;
import api.TGDApi;
import db.Person;

public class HighScorePlayerMenu extends Menu implements APIListener{
	
	public static int ID=-8;
	
	private static String namePlayer="nicorb";

	private Person player;
	@Override
	public void enter(GameContainer arg0, StateBasedGame arg1){
		TGDApi.setApiListener(this);
		TGDApi.getScoresForPlayer(namePlayer);
		player=new Person(namePlayer);
		
		super.setTitrePrincipal("MEILLEURS SCORES");
		super.setTitreSecondaire(namePlayer);
		
		super.removeAllItems();
		super.addItem("Score "+games.CathedralBloxxx.World.GAME_NAME +": "+player.getScoreAtGame(1));
		super.addItem("Score "+games.T7Laser.World.GAME_NAME +": "+player.getScoreAtGame(2));

		super.setEnableClignote(false);
		super.setCouleurClignote(Color.red);
		super.setTempsClignote(400);
		
	}
	
	@Override
	public void onOptionItemFocusedChanged(int position) {
	}
	@Override
	public void onOptionItemSelected(int position) {
		game.enterState(MainMenu.ID, new FadeOutTransition(),
				new FadeInTransition());
	}
	
	@Override
	public int getID() {
		return ID;
	}

	public static void setNamePlayer(String text) {
		namePlayer=text;
	}
	
	@Override
	public void keyPressed(int key,char c){
		super.keyPressed(key, c);
		if(key==Input.KEY_ESCAPE){
			game.enterState(ScoreMenu.ID, new FadeOutTransition(),new FadeInTransition());		
		}
	}

	@Override
	public void onContentReceived(Object content) {
		if(content instanceof Person){
			
			player=(Person)content;
			
			super.removeAllItems();
			super.addItem("Score "+games.CathedralBloxxx.World.GAME_NAME +": "+player.getScoreAtGame(1));
			super.addItem("Score "+games.T7Laser.World.GAME_NAME +": "+player.getScoreAtGame(2));
		}
	}

	@Override
	public void onContentUpdated(String reponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String reason) {
		// TODO Auto-generated method stub
		
	}
}