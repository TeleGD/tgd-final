package general.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ColorPicker extends TGDComponent {


    private Color colorSelected ;

    private int[] c = new int[]{0,0,0,255};

    private Button bouton ;
    private String s ="";
    private int rowSelected=0;

    public ColorPicker(GameContainer container, float x, float y, float width, float height) {
        super(container, x, y, width, height);

        bouton = new Button(container,x+5,5*(height-(paddingBottom-paddingTop))/6,width-10,(height-(paddingBottom-paddingTop))/6);
        bouton.setBackgroundColor(Color.black);
        bouton.setBackgroundColorEntered(new Color(30,30,30));
        bouton.setBackgroundColorPressed(new Color(40,40,40));
        bouton.setBorderColor(Color.white);
        bouton.setTextColor(Color.white);
        bouton.setTextColorEntered(Color.white);
        bouton.setTextColorPressed(Color.white);
        bouton.setCornerRadius(25);

        bouton.setText("Ok !");//sez

    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        bouton.setOnClickListener(listener);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        super.render(container, game, g);
        if(!visible)return;

        float h = height-paddingTop-paddingBottom;
        float w = width -paddingLeft-paddingRight;

        for(int i=0;i<4;i++) {
            g.setColor(Color.black);
            g.fillRect(x + paddingLeft, y + paddingTop + h / 6 * i, w, h / 6);
            if (i == 0) {
                g.setColor(new Color(c[i], 0, 0, 255));
                s = "R";
            } else if (i == 1){
                s = "V";
                g.setColor(new Color(0, c[i], 0, 255));
            }
            else if (i==2) {
                s = "B";
                g.setColor(new Color(0, 0, c[i], 255));
            }else if (i==3) {
                s = "A";
                g.setColor(new Color(255, 255, 255, c[i]));
            }
            g.fillRect(x+paddingLeft+1,y+paddingTop+h/6*i+1,w-2,h/6-1);
            g.setColor(Color.black);

            g.fillRect((float) (x+paddingLeft+1+(c[i]*(w-4))/255.0), y+paddingTop+h/6*i+1,4,h/6-1);
            g.setColor(Color.white);

            g.drawString(s+" : "+c[i],x+width/2-20,y+paddingTop+h/6*i+h/30);

        }




        g.setColor(Color.black);
        g.fillRect(x+paddingLeft,y+paddingTop+4*h/6,w,h/6);

        g.setColor(new Color(c[0],c[1],c[2],c[3]));
        g.fillRect(x+paddingLeft+1,y+paddingTop+4*h/6+1,w-2,h/6-2);

        bouton.render(container, game, g);

    }

    @Override
    public void setX(float x) {
    	super.setX(x);
    	bouton.setX(x+5);
    }
    @Override
    public void setY(float y) {
    	super.setY(y);
    	bouton.setY(y+5*(height-(paddingBottom-paddingTop))/6);
    }
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        super.update(container, game, delta);
        bouton.update(container, game, delta);
    }

    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
        this.c[0] = colorSelected.getRed();
        this.c[1] = colorSelected.getGreen();
        this.c[2] = colorSelected.getBlue();
        this.c[3] = colorSelected.getAlpha();

    }

    public Color getColorSelected() {
        colorSelected = new Color(c[0],c[1],c[2],c[3]);
        return colorSelected;
    }

    @Override
    public void mousePressed(int arg0, int xM, int yM) {
        super.mousePressed(arg0, xM, yM);
        int row = (int) ((yM-y)/((height-paddingTop-paddingBottom)/6));
        if(row<4 && row>=0 && contains(xM,yM)) {
            rowSelected = row;
        }
        changeColor(xM,yM);

    }

    @Override
    public void mouseDragged(int arg0, int arg1, int xM, int yM) {
        super.mouseDragged(arg0, arg1, xM, yM);
        changeColor(xM,yM);
    }

    private void changeColor(int xM, int yM) {
        int etat = (int) (255*((double)(xM-x)/(double)(width-paddingLeft-paddingRight)));

        if(contains(xM,yM)){

            if(xM>x+paddingLeft && xM<x+width-paddingLeft-paddingRight){
                c[rowSelected] = etat;
            }

        }else if(xM>x+width){
            c[rowSelected] = 255;

        }else if(xM<x){
            c[rowSelected] = 0;

        }
    }
}
