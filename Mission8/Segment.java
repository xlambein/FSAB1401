
/**
 * Une classe permettant de repr�senter un segment de droite
 * 
 * @author O. Bonaventure, Ch. Pecheur
 * @version 3 Nov 2012
 */

import java.awt.Color;
import java.awt.Graphics;

public class Segment implements Shape
{
   private int x0,y0; // coordonees de la premiere extremite
   private int x1,y1; // coordonnees de la seconde extremite

   /**
     * @pre x0,y0,x1,y1 >=0 et <512
     * @post a construit un segment de droite reliant x0,y0 a x1,y1
     */
    public Segment(int x0, int y0, int x1, int y1)
    {
        this.x0=x0;
        this.y0=y0;
        this.x1=x1;
        this.y1=y1;
    }
    
    public void draw(Graphics g)
    {
        g.drawLine(x0,y0,x1,y1);
    }
    
    public int getXMin()
    {
        return Math.min(x0, x1);
    }
    
    public int getYMin()
    {
        return Math.min(y0, y1);
    }
    
    public int getXMax()
    {
        return Math.max(x0, x1);
    }
    
    public int getYMax()
    {
        return Math.max(y0, y1);
    }
}
