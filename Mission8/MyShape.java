import java.awt.Graphics;
import java.awt.Color;

/**
 * Un exemple de figure
 * 
 * @author Charles Pecheur
 * @version 3 Nov 2012
 */
public class MyShape implements Shape
{

    private int n;  // nombre d'intervalles � dessiner

    /**
     * @pre  ---
     * @post cree un {@code MyShape} de 10 intervalles
     */
    public MyShape() {
        this(10);
    }
    
    /**
     * @pre  {@code n > 0}
     * @post cree un {@code MyShape} de {@code n} intervalles
     */
    public MyShape(int n) {
        this.n = n;
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine cette figure sur {@code g}. 
     */
    public void draw(Graphics g) {
        for (int i = 0; i <= n; i++) {

            Segment seg1 = new Segment(20, 20, 20 + (480 * i / n), 400);
            g.setColor(Color.RED);
            seg1.draw(g);

            Segment seg2 = new Segment(500, 20, 20 + (480 * i / n), 400);
            g.setColor(Color.BLUE);
            seg2.draw(g);
        }        
    }
    
    public int getXMin()
    {
        return 20;
    }
    
    public int getYMin()
    {
        return 20;
    }
    
    public int getXMax()
    {
        return 500;
    }
    
    public int getYMax()
    {
        return 400;
    }
    
    public static void main (String args[])
    {
        Shape shape = new MyShape(20);
        DrawPanel panel = new DrawPanel(shape, shape.getXMin(), shape.getXMax(), shape.getYMin(), shape.getYMax());
    }

}
