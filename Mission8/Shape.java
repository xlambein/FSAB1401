import java.awt.Graphics;

/**
 * Une interface servant à représenter des formes à dessiner
 * 
 * @author Xavier Lambein & Victor Lecomte
 * @version 2013-11-14
 */
public interface Shape
{
    public void draw(Graphics g);
    public int getXMin();
    public int getYMin();
    public int getXMax();
    public int getYMax();
}
