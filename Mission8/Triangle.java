import java.awt.Graphics;
import java.awt.Color;

/**
 * Un triangle de couleur
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-11-14
 */
class Triangle implements Shape
{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private Color color;
    
    /**
     * @pre  -
     * @post cree un {@code Triangle} de couleur {@code color} dont les sommets sont les points
     * ({@code x1}, {@code y1}), ({@code x2}, {@code y2}) et ({@code x3}, {@code y3})
     */
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;
    }
    
    /**
     * @pre  -
     * @post cree un {@code Triangle} noir dont les sommets sont les points
     * ({@code x1}, {@code y1}), ({@code x2}, {@code y2}) et ({@code x3}, {@code y3})
     */
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        this(x1, y1, x2, y2, x3, y3, Color.BLACK);
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine un triangle sur {@code g}.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        (new Segment(x1, y1, x2, y2)).draw(g);
        (new Segment(x2, y2, x3, y3)).draw(g);
        (new Segment(x3, y3, x1, y1)).draw(g);
    }
    
    public int getXMin()
    {
        return Math.min(Math.min(x1, x2), x3);
    }
    
    public int getYMin()
    {
        return Math.min(Math.min(y1, y2), y3);
    }
    
    public int getXMax()
    {
        return Math.max(Math.max(x1, x2), x3);
    }
    
    public int getYMax()
    {
        return Math.max(Math.max(y1, y2), y3);
    }
    
    public static void main (String args[])
    {
        Shape shape = new Triangle(50, 50, 50, 100, 82, 50, Color.CYAN);
        DrawPanel panel = new DrawPanel(shape, shape.getXMin(), shape.getXMax(), shape.getYMin(), shape.getYMax());
    }
}