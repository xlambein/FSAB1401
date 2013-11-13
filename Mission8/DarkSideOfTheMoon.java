import java.awt.Graphics;
import java.awt.Color;

/**
 * Un exemple de figure
 * 
 * @author Charles Pecheur
 * @version 3 Nov 2012
 */
public class DarkSideOfTheMoon implements Shape
{
    private int x;
    private int y;
    
    /**
     * @pre  -
     * @post cree un {@code DarkSideOfTheMoon} centré au point ({@code x}, {@code y})
     */
    public DarkSideOfTheMoon(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    private void drawLines(Graphics g, int x1, int y1, int x2, int y2, int n, Color color) {
        int factor = 1;
        if(y1 < y2)
            factor = -1;
        
        g.setColor(color);
        for(int i = 0; i < n; i++)
            (new Segment(x1+1*i*factor,y1-2*i,x2+1*i*factor,y2-2*i)).draw(g);
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine cette figure sur {@code g}. 
     */
    public void draw(Graphics g) {
        (new Equilateral(x, y, 100, Math.PI/2)).draw(g); // Dessine le triangle central
        (new Equilateral(x, y, 100-4, Math.PI/2)).draw(g);
        
        drawLines(g, x-150, y+20, x-30, y-50, 3, Color.BLACK);
            
        (new Triangle(x-29, y-53, x+17, y-70, x+39, y-32)).draw(g);
        
        drawLines(g, x+20, y-66, x+140, y+1, 3,  Color.RED);
        drawLines(g, x+24, y-59, x+144, y+8, 3,  Color.ORANGE);
        drawLines(g, x+28, y-52, x+148, y+15, 3, Color.YELLOW);
        drawLines(g, x+32, y-45, x+152, y+22, 3, Color.GREEN);
        drawLines(g, x+36, y-38, x+156, y+29, 3, Color.BLUE);
        drawLines(g, x+40, y-31, x+160, y+36, 3, Color.MAGENTA);
    }
    
    public static void main(String args[])
    {
        //Shape shape = new MyShape(30);
        Shape shape = new Equilateral(200, 200, 200, Math.PI/2);
        DrawPanel panel = new DrawPanel(shape, 20, 500, 20, 400);
    }

}
