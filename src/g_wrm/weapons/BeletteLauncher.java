package g_wrm.weapons;

import org.newdawn.slick.Sound;

import g_wrm.World;
import g_wrm.utils.PathUtils;
import g_wrm.weapons.projectiles.ProjectileSinusoidal;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BeletteLauncher extends Weapon {


    public BeletteLauncher(){
		super(10,5,0,200,1,UNLIMITED);
		try {
			image = new Image(PathUtils.Bazooka_Belette);
			sound = new Sound(PathUtils.Bellete_sound);
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
	@Override
	protected void fireOneShot(int x, int y, float alpha) {
		ProjectileSinusoidal proj = new ProjectileSinusoidal(x, y, alpha, this.firepower, this.weight, this);
        proj.setImages(PathUtils.Belette_1,PathUtils.Belette_2);
        proj.setExplodeDamage(destruction);
		proj.setDamage(dmg);

        World.addProjectile(proj);


    }

}
