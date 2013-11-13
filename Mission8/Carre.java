import java.awt.Color;

/**
 * Un carre de couleur
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-11-14
 */
class Carre extends Rectangle
{
    /**
     * @pre  -
     * @post cree un {@code Carre} de couleur {@code color} et de cote {@code side}
     * situé au coin ({@code x}, {@code y})
     */
    public Carre(int x, int y, int side, Color color)
    {
        super(x, y, x+side, y+side, color);
    }
    
    /**
     * @pre  -
     * @post cree un {@code Carre} noir et de cote {@code side}
     * situé au coin ({@code x}, {@code y})
     */
    public Carre(int x, int y, int side)
    {
        this(x, y, side, Color.BLACK);
    }
    
    public static void main (String args[])
    {
        Shape shape = new Carre(42,42,42, Color.BLUE);
        DrawPanel panel = new DrawPanel(shape, shape.getXMin(), shape.getXMax(), shape.getYMin(), shape.getYMax());
    }
}
