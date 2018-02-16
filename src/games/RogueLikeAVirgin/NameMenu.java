package games.RogueLikeAVirgin;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import general.Main;
import general.utils.FontUtils;

public class NameMenu extends BasicGameState{

	public static int ID=-13;
	private int compt;
	private TrueTypeFont fontTitrePrincipal;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame game) throws SlickException {
		fontTitrePrincipal=FontUtils.loadFont("iCrack.ttf",Font.PLAIN,55,false);
		compt =0;
	}
	
	@Override
	public void enter(GameContainer arg0, StateBasedGame game) throws SlickException {
		game.addState(new games.RogueLikeAVirgin.MainMenu());
		game.addState(new games.RogueLikeAVirgin.World());
		game.addState(new games.RogueLikeAVirgin.ScoreMenu(game));
		game.addState(new games.RogueLikeAVirgin.CreditsMenu());
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.setFont(fontTitrePrincipal);
		g.drawString("Rogue Like A Virgin",(Main.longueur-fontTitrePrincipal.getWidth("Rogue Like A Virgin"))/2 , (Main.hauteur-fontTitrePrincipal.getHeight("Rogue Like A Virgin"))/2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame game, int arg2) throws SlickException {
		compt++;
		if(compt>15) {
			game.enterState(games.RogueLikeAVirgin.MainMenu.ID,new FadeOutTransition(),new FadeInTransition());
		}
		
		if (compt==2) {
			game.getState(games.RogueLikeAVirgin.MainMenu.ID).init(arg0, game);
			game.getState(games.RogueLikeAVirgin.World.ID).init(arg0, game);
			game.getState(games.RogueLikeAVirgin.ScoreMenu.ID).init(arg0, game);
			game.getState(games.RogueLikeAVirgin.CreditsMenu.ID).init(arg0, game);
		}
	}

	@Override
	public int getID() {
		return ID;
	}

	
}
