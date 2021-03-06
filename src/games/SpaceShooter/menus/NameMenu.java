package games.SpaceShooter.menus;


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

import games.SpaceShooter.World;
import general.utils.FontUtils;


public class NameMenu extends BasicGameState{

	public static int ID=-6;
	private int compt;
	private TrueTypeFont font;


	@Override
	public void init(GameContainer arg0, StateBasedGame game) throws SlickException {
		compt =0;
		font=FontUtils.loadFont("space_age.ttf",Font.PLAIN,55,false);
	}

	@Override
	public void enter(GameContainer arg0, StateBasedGame game) throws SlickException {
		game.addState(new MenuPrincipal());
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Space Shooter !",(1280-font.getWidth("Space Shooter !"))/2 , (720-font.getHeight("Space Shooter !"))/2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame game, int arg2) throws SlickException {
		compt++;
		if(compt>200) {
			game.enterState(MenuPrincipal.ID,new FadeOutTransition(),new FadeInTransition());
		}

		if (compt==2) {
			game.getState(MenuPrincipal.ID).init(arg0, game);
			game.getState(World.ID).init(arg0, game);
		}
	}

	@Override
	public int getID() {
		return ID;
	}


}
