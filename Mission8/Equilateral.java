import java.awt.Graphics;
import java.awt.Color;

/**
 * Un triangle equialteral de couleur
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-11-14
 */
class Equilateral extends Triangle
{
    /**
     * Contient l'angle entre deux sommets d'un triangle equilateral (= 120°), en radians.
     */
    static final double DELTA = Math.PI*2/3;
    
    /**
     * @pre  -
     * @post cree un {@code Equilateral} de couleur {@code color} inscrit dans le cercle de centre
     * ({@code cx}, {@code cy}) et de rayon {@code radius}, dont l'un des sommets est à un angle
     * {@code angle} en radians, dans le sens trigonométrique.
     */
    public Equilateral(int cx, int cy, int radius, double angle, Color color)
    {
        super(cx+(int)(Math.round(radius*Math.cos(angle))), // Coord. du premier sommet
              cy-(int)(Math.round(radius*Math.sin(angle))),
              cx+(int)(Math.round(radius*Math.cos(angle+DELTA))), // Coord. du deuxième sommet
              cy-(int)(Math.round(radius*Math.sin(angle+DELTA))),
              cx+(int)(Math.round(radius*Math.cos(angle+DELTA*2))), // Coord. du troisième sommet
              cy-(int)(Math.round(radius*Math.sin(angle+DELTA*2))),
              color);
    }
    
    /**
     * @pre  -
     * @post cree un {@code Equilateral} noir inscrit dans le cercle de centre ({@code cx}, {@code cy})
     * de rayon {@code radius}, dont l'un des sommets est à un angle {@code angle} dans le sens
     * trigonométrique.
     */
    public Equilateral(int cx, int cy, int radius, double angle)
    {
        this(cx, cy, radius, angle, Color.BLACK);
    }
    
    public static void main (String args[])
    {
        Shape shape = new Equilateral(256, 256, 100, Math.PI*5/12, Color.RED);
        DrawPanel panel = new DrawPanel(shape, shape.getXMin(), shape.getXMax(), shape.getYMin(), shape.getYMax());
    }
}