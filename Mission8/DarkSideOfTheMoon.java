import java.awt.Graphics;
import java.awt.Color;

/**
 * La pochette de l'album Dark Side of the Moon de Pink Floyd.
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-11-14
 */
public class DarkSideOfTheMoon implements Shape
{
    private int x;
    private int y;
    
    private final int SIDE = 300;
    
    /**
     * @pre  -
     * @post cree un {@code DarkSideOfTheMoon} centré au point ({@code x}, {@code y})
     */
    public DarkSideOfTheMoon(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine une ligne de couleur {@code color} dans {@code g}, partant du point ({@code x}, {@code y}),
     * de longueur {@code length}, à un angle {@code angle} en radians.
     */
    private void drawLine(Graphics g, double x, double y, double angle, int length, Color color) {
        double x2 = length*Math.cos(angle);
        double y2 = length*Math.sin(angle);
        
        g.setColor(color);
        (new Segment((int)Math.round(x), (int)Math.round(y), (int)(x+x2), (int)Math.round(y+y2))).draw(g);
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine {@code n} lignes parallèles de couleur {@code color} dans {@code g},
     * de longueur {@code length}, à un angle {@code angle} en radians, espacées de {@code space},
     * et dont la première part du point ({@code x}, {@code y}).
     */
    private void drawLines(Graphics g, double x, double y, double angle, int length, int n, int space, Color color) {
        g.setColor(color);
        for(int i = 0; i < n; i++)
            drawLine(g, x-i*space*Math.sin(angle), y+i*space*Math.cos(angle), angle, length, color);
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine cette figure sur {@code g}. 
     */
    public void draw(Graphics g) {
        // Dessiner le fond noir
        g.setColor(Color.BLACK);
        g.fillRect(getXMin(), getYMin(), SIDE, SIDE);
        
        // L'angle des traits de lumière
        final double ANGLE = Math.toRadians(30);
        
        // Dessiner le double triangle central
        (new Equilateral(x, y, 100, Math.PI/2, Color.WHITE)).draw(g);
        (new Equilateral(x, y, 100-4, Math.PI/2, Color.WHITE)).draw(g);
        
        // Dessiner les trois traits blancs à gauche
        drawLines(g, x-26, y-52, Math.PI-ANGLE, 130, 3, 1, Color.WHITE);
        
        // Dessiner le double triangle intérieur
        (new Triangle(x-28, y-53, x+17, y-70, x+36, y-36, Color.WHITE)).draw(g);
        (new Triangle(x-27, y-53, x+16, y-69, x+35, y-37, Color.WHITE)).draw(g);
        
        // Dessiner les 3*6 traits de couleur à droite
        drawLines(g, x+18, y-70, ANGLE, 130, 3, 1, Color.RED);
        drawLines(g, x+22, y-64, ANGLE, 130, 3, 1, Color.ORANGE);
        drawLines(g, x+25, y-58, ANGLE, 130, 3, 1, Color.YELLOW);
        drawLines(g, x+29, y-52, ANGLE, 130, 3, 1, Color.GREEN);
        drawLines(g, x+32, y-46, ANGLE, 130, 3, 1, Color.BLUE);
        drawLines(g, x+36, y-40, ANGLE, 130, 3, 1, Color.MAGENTA);
    }
    
    public int getXMin()
    {
        return x-SIDE/2;
    }
    
    public int getYMin()
    {
        return y-SIDE/2;
    }
    
    public int getXMax()
    {
        return x+SIDE/2;
    }
    
    public int getYMax()
    {
        return y+SIDE/2;
    }
    
    public static void main (String args[])
    {
        Shape shape = new DarkSideOfTheMoon(256, 256);
        DrawPanel panel = new DrawPanel(shape, shape.getXMin(), shape.getXMax(), shape.getYMin(), shape.getYMax());
    }

}
